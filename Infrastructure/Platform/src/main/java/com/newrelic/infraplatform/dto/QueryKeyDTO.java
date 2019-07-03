package com.newrelic.infraplatform.dto;

public class QueryKeyDTO {

	private String query_key;
	private String key_title;
	private Integer acc_id;
	public QueryKeyDTO() {
		super();
	}

	public QueryKeyDTO(String query_key, String key_title,Integer acc_id) {
		super();
		this.query_key = query_key;
		this.key_title = key_title;
		this.acc_id = acc_id;
	}

	public Integer getAcc_id() {
		return acc_id;
	}
	
	public String getKey_title() {
		return key_title;
	}

	public String getQuery_key() {
		return query_key;
	}
	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}
	public void setKey_title(String key_title) {
		this.key_title = key_title;
	}
	public void setQuery_key(String query_key) {
		this.query_key = query_key;
	}
	
}
