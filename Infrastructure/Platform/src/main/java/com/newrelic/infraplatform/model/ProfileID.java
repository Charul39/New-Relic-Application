package com.newrelic.infraplatform.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ProfileID implements Serializable {

	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="profile_name")
	private String profile_name;
	
	public ProfileID() {
		
	}	

	public ProfileID(Long user_id, String profile_name) {
		super();
		this.user_id = user_id;
		this.profile_name = profile_name;
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileID)) return false;
        ProfileID that = (ProfileID) o;
        return Objects.equals(getUser_id(), that.getUser_id()) &&
                Objects.equals(getProfile_name(), that.getProfile_name());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getProfile_name());
    }
	
}