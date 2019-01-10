package br.com.conectasol.scdbatch.elastic.model;

public class RequestSearchList {

	public enum QueryType {
		MATCH, MATCH_PHRASE,
	}

	private StringBuilder sb;

	private RequestSearchList(int size) {
		this.sb = new StringBuilder("\"size\": ").append(size).append(",");
	}

	public static final RequestSearchList start() {
		return start(0);
	}

	public static final RequestSearchList start(int size) {
		return new RequestSearchList(size);
	}

	public RequestSearchList addQuery(QueryType type, String field, String value) {
		sb.append("\"query\": {")
			.append("\"").append(type.name().toLowerCase()).append("\"").append(":{")
				.append("\"").append(field).append("\"").append(":").append("\"").append(value).append("\"")
			.append("}")
		.append("},");
		return this;
	}

	public RequestSearchList addAggs(String field) {
		sb.append("\"aggs\": {")
			.append("\"").append(field).append("\"").append(":{")
				.append("\"").append("terms").append("\"").append(":{")
					.append("\"").append("field").append("\"").append(":").append("\"").append(field).append(".keyword").append("\"")
				.append("}")
			.append("}")
		.append("}");
		return this;
	}
	
	public String build() {
		StringBuilder json = new StringBuilder("{");
		json.append(sb).append("}");
		
		return json.toString();
	}
}
