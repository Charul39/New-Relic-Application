package com.newrelic.infraplatform.dto;

public class StatusDTO {

	private String statusCode;

	public StatusDTO() {
		super();
	}
	
	public StatusDTO(String statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
