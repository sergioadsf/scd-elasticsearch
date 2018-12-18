package br.com.conectasol.scdbatch.service;

import java.io.IOException;

import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import br.com.conectasol.scdbatch.service.exception.CriarIndiceException;

@Service
public class DocumentoService extends AbsElasticService {

	public void bulk(String nome, String json) throws IOException, CriarIndiceException {

		RestClient client = null;

		try {
			client = this.openConnection();
			this.doBulk(client, json);
		} catch (Exception e) {
			e.printStackTrace();
			this.close(client);
		} finally {
			this.close(client);
		}
	}
	
}
