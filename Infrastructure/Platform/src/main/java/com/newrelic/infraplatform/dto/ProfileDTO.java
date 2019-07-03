package com.newrelic.infraplatform.dto;

public class ProfileDTO {
	
	private Long test_id;
	
	private String profile_name;

	public ProfileDTO() {
		super();
	}

	public ProfileDTO(String profile_name) {
		super();
		this.profile_name = profile_name;
	}

	public ProfileDTO(Long test_id, String profile_name) {
		super();
		this.test_id = test_id;
		this.profile_name = profile_name;
	}

	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	}

	public String getProfile_name() {
		return profile_name;
	}

	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}

}
