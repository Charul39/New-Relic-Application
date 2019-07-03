package com.newrelic.infraplatform.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("serial")
@Entity
@Table(name = "integrations")
@EntityListeners(AuditingEntityListener.class)
public class Integrations implements Serializable{
	
	@Id
	private Long test_id;
	
	private Long user_id;
	
	private String infra_profile;

	public Integrations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integrations(Long test_id, Long user_id, String infra_profile) {
		super();
		this.test_id = test_id;
		this.user_id = user_id;
		this.infra_profile = infra_profile;
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

	public String getInfra_profile() {
		return infra_profile;
	}

	public void setInfra_profile(String infra_profile) {
		this.infra_profile = infra_profile;
	}

	@Override
	public String toString() {
		return "Integrations [test_id=" + test_id + ", user_id=" + user_id + ", infra_profile=" + infra_profile + "]";
	}
	
}
