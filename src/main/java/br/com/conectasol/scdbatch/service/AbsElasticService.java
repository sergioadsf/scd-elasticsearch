package br.com.conectasol.scdbatch.service;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.conectasol.scdbatch.util.CloseUtil;
import br.com.conectasol.scdbatch.util.PathProperties;

@Configuration
public class AbsElasticService {
	
	@Autowired
	private PathProperties pathProperties; 

	private static final int TIMEOUT = 60000;
	protected ThreadPoolExecutor executor;

	private RestClientBuilder createConnection() {
		return RestClient.builder(new HttpHost(pathProperties.getUrl(), Integer.valueOf(pathProperties.getPort())))
				.setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(TIMEOUT).setSocketTimeout(TIMEOUT))
				.setMaxRetryTimeoutMillis(TIMEOUT);
	}

	protected RestClient openConnection() {
		return this.createConnection().build();
	}

	protected RestHighLevelClient openHighConnection() {
		return new RestHighLevelClient(this.createConnection());
	}

	protected void close(TransportClient client) {
		CloseUtil.close(client);
	}
	
	protected void close(RestClient client) {
		CloseUtil.close(client);
	}

	protected void close(RestHighLevelClient client) {
		CloseUtil.close(client);
	}

	protected String doGet(final RestClient client, StringBuilder jBuilder, String index) throws IOException {
		return doGet(client, jBuilder.toString(), index);
	}

	protected String doGet(final RestClient client, String jBuilder, String index) throws IOException {
		HttpEntity entity = new NStringEntity(jBuilder, ContentType.APPLICATION_JSON);
		Response response = client.performRequest("GET", String.format("%s/%s", index, "_search"), Collections.emptyMap(), entity);
		return EntityUtils.toString(response.getEntity());
	}

	protected void doBulk(final RestClient client, StringBuilder jBuilder) throws IOException {
		this.doBulk(client, jBuilder.toString());
	}

	protected void doBulk(final RestClient client, String jBuilder) throws IOException {
		HttpEntity entity = new NStringEntity(jBuilder, ContentType.APPLICATION_JSON);
		client.performRequest("POST", "_bulk", Collections.emptyMap(), entity);
	}
}
