package br.com.conectasol.scdbatch.elastic.model;

import br.com.conectasol.scdbatch.util.ElasticJsonBuilder;

public class RequestSearchList {

	public enum QueryType {
		MATCH, MATCH_PHRASE,
	}

	private ElasticJsonBuilder esb;
//	private StringBuilder sb;

	private RequestSearchList(int size) {
		this.esb = new ElasticJsonBuilder();
		this.esb.key("size", size).comma();
//		this.sb = new StringBuilder("\"size\": ").append(size).append(",");
	}

	public static final RequestSearchList start() {
		return start(0);
	}

	public static final RequestSearchList start(int size) {
		return new RequestSearchList(size);
	}

	public RequestSearchList addQuery(QueryType type, String field, String value) {
		this.esb.key("query");
			this.esb.key(type.name().toLowerCase());
				this.esb.key(field, value);
			this.esb.closeQuotes();
		this.esb.closeQuotes();
		this.esb.comma();
		return this;
	}

	public RequestSearchList addAggs(String field) {
		this.esb.key("aggs");
			this.esb.key(field);
				this.esb.key("terms");
					this.esb.key("field", field+".keyword");
				this.esb.closeQuotes();
			this.esb.closeQuotes();
		this.esb.closeQuotes();
		return this;
	}
	
//	public RequestSearchList addQuery(QueryType type, String field, String value) {
//		sb.append("\"query\": {")
//		.append("\"").append(type.name().toLowerCase()).append("\"").append(":{")
//		.append("\"").append(field).append("\"").append(":").append("\"").append(value).append("\"")
//		.append("}")
//		.append("},");
//		return this;
//	}
//	
//	public RequestSearchList addAggs(String field) {
//		sb.append("\"aggs\": {")
//		.append("\"").append(field).append("\"").append(":{")
//		.append("\"").append("terms").append("\"").append(":{")
//		.append("\"").append("field").append("\"").append(":").append("\"").append(field).append(".keyword").append("\"")
//		.append("}")
//		.append("}")
//		.append("}");
//		return this;
//	}
	
	public String build() {
		StringBuilder json = new StringBuilder("{");
		json.append(esb.toString()).append("}");
		
		return json.toString();
	}
}
