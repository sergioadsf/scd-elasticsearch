package br.com.conectasol.scdbatch.util;

public class ElasticJsonBuilder {

	private StringBuilder sb;
	
	public ElasticJsonBuilder() {
		this.sb = new StringBuilder();
	}
	
	public ElasticJsonBuilder key(String key) {
		this.key(key, true);
		return this;
	}

	public ElasticJsonBuilder key(String key, boolean addQuotes) {
		this.sb.append("\"").append(key).append("\": { ");
		return this;
	}

	public ElasticJsonBuilder key(String key, String value) {
		this.sb.append("\"").append(key).append("\": ");
		this.sb.append("\"").append(value).append("\"");
		return this;
	}

	public ElasticJsonBuilder key(String key, Number value) {
		this.sb.append("\"").append(key).append("\": ");
		this.sb.append(value);
		return this;
	}
	
	public ElasticJsonBuilder closeQuotes() {
		this.sb.append("}");
		return this;
	}

	public ElasticJsonBuilder comma() {
		this.sb.append(",");
		return this;
	}
	
	@Override
	public String toString() {
		return this.sb.toString();
	}
}
