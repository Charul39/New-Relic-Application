package com.newrelic.infraplatform.dto;

public class ValuesDTO {

	private String host_name;
	private Double value;
	
	public ValuesDTO() {
		super();
	}
	
	public ValuesDTO(String host_name, Double value) {
		super();
		this.host_name = host_name;
		this.value = value;
	}

	public String getHost_name() {
		return host_name;
	}

	public Double getValue() {
		return value;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
