package br.com.conectasol.scdbatch.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService extends AbsElasticService {

	public void bulk(String json) throws IOException {

		RestClient client = null;

		try {
			client = this.openConnection();
			this.doBulk(client, json);
		} catch (IOException e) {
			Logger.getRootLogger().error(e.getMessage(), e);
		} finally {
			this.close(client);
		}
	}
	
}
