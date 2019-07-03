package com.newrelic.infraplatform.dto;

public class QueryKeyNameDTO {
	private String key_title;

	public QueryKeyNameDTO() {
		super();
	}
	
	public QueryKeyNameDTO(String key_title) {
		super();
		this.key_title = key_title;
	}

	public String getKey_title() {
		return key_title;
	}

	public void setKey_title(String key_title) {
		this.key_title = key_title;
	}
	
}