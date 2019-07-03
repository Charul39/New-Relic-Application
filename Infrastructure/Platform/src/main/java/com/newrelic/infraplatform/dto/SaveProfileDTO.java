package com.newrelic.infraplatform.dto;

import java.util.List;

public class SaveProfileDTO {

	private Long user_id;
	private String profile_name;
	private String query_key;
	private String key_title;
	private Integer acc_id;
	private Long test_id;
	
	private List<HostDTO> hostList;
	
	public SaveProfileDTO() {
		super();
	}
	
	public SaveProfileDTO(Long user_id, String profile_name, String query_key, String key_title, Integer acc_id,
			List<HostDTO> hostList, Long test_id) {
		super();
		this.user_id = user_id;
		this.profile_name = profile_name;
		this.query_key = query_key;
		this.key_title = key_title;
		this.acc_id = acc_id;
		this.hostList = hostList;
		this.test_id = test_id;
	}
	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	}

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getProfile_name() {
		return profile_name;
	}
	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}
	public String getQuery_key() {
		return query_key;
	}
	public void setQuery_key(String query_key) {
		this.query_key = query_key;
	}
	public String getKey_title() {
		return key_title;
	}
	public void setKey_title(String key_title) {
		this.key_title = key_title;
	}
	public Integer getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}
	public List<HostDTO> getHostList() {
		return hostList;
	}
	public void setHostList(List<HostDTO> hostList) {
		this.hostList = hostList;
	}
	
}