package br.com.conectasol.scdbatch.service;

import java.io.IOException;
import java.util.HashMap;

import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.conctasol.annotation.MIndex;
import br.com.conectasol.scdbatch.Folha;
import br.com.conectasol.scdbatch.elastic.model.RequestSearchList;
import br.com.conectasol.scdbatch.elastic.model.RequestSearchList.QueryType;
import br.com.conectasol.scdbatch.service.exception.CriarIndiceException;

@Service
public class FolhaService extends AbsElasticService {

	public String consultar(String campo, String valor) throws IOException, CriarIndiceException {

		RestClient client = null;

		try {
			MIndex mIndex = Folha.class.getAnnotation(MIndex.class);
			client = this.openConnection();
			return this.doGet(client,
					RequestSearchList.start().addQuery(QueryType.MATCH_PHRASE, campo, valor).addAggs(campo).build(),
					mIndex.name());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.close(client);
		}
	}

	@SuppressWarnings("unchecked")
	public String listarAgregacoes(String campo, String valor) throws IOException, CriarIndiceException {

		String json = this.consultar(campo, valor);
		HashMap<String, Object> map = new ObjectMapper().readValue(json, HashMap.class);
		HashMap<String, Object> mapAggs = (HashMap<String, Object>) map.get("aggregations");
		HashMap<String, Object> mapCampo = (HashMap<String, Object>) mapAggs.get(campo);
		return new ObjectMapper().writeValueAsString(mapCampo.get("buckets"));
	}

}