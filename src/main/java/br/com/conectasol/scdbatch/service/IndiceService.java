package br.com.conectasol.scdbatch.service;

import java.io.IOException;
import java.util.Map;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.stereotype.Service;

import br.com.conectasol.scdbatch.service.exception.CriarIndiceException;

@Service
public class IndiceService extends AbsElasticService {

	public CreateIndexRequest criar(String nome, Map<String, Object> mapping) throws IOException, CriarIndiceException {

		RestHighLevelClient client = null;
		CreateIndexRequest request = null;

		try {
			client = this.openHighConnection();

			if (this.indexExists(client, nome)) {
				throw new CriarIndiceException(String.format("Indice %s já existe!", nome));
			}

			request = new CreateIndexRequest(nome);
			request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
			request.mapping("_doc", mapping);
			return request;
		} finally {
			this.close(client);
		}
	}

	private boolean indexExists(RestHighLevelClient client, String indexname) {
		GetIndexRequest request = new GetIndexRequest();
		request.indices(indexname);
		try {
			return client.indices().exists(request);
		} catch (IOException e) {
			return false;
		}
	}
}
