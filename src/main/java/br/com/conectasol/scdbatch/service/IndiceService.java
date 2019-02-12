package br.com.conectasol.scdbatch.service;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import br.com.conectasol.scdbatch.service.exception.CriarIndiceException;

@Service
public class IndiceService extends AbsElasticService {

	public CreateIndexRequest criar(String nome, String mapping) throws IOException, CriarIndiceException {

		RestHighLevelClient client = null;
		CreateIndexRequest request = null;

		try {
			client = this.openHighConnection();

			if (this.indexExists(client, nome)) {
				throw new CriarIndiceException(String.format("Indice %s já existe!", nome));
			}
			
//			HashMap<String,Object> mapping =
//			        new ObjectMapper().readValue(json, new TypeReference<Map<String, Object>>(){});
			
			request = new CreateIndexRequest(nome);
			
			request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
			request.mapping("_doc", mapping, XContentType.JSON);
			client.indices().create(request);
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
