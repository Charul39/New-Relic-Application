package com.newrelic.infraplatform.dto;

public class HostDTO {
	private String fullHostname;

	public HostDTO() {
		super();
	}
	
	public HostDTO(String fullHostname) {
		super();
		this.fullHostname = fullHostname;
	}

	public String getFullHostname() {
		return fullHostname;
	}

	public void setFullHostname(String fullHostname) {
		this.fullHostname = fullHostname;
	}
	
}