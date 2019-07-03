package com.newrelic.infraplatform.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer host_id;
    
    
    private String host_name;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
       @JoinColumn(
           name = "fk_user_id",
           referencedColumnName = "user_id"),
       @JoinColumn(
           name = "fk_profile_name",
           referencedColumnName = "profile_name")
   })
   @JsonManagedReference
   private Profile profile;

   public Host() {
       super();
   }

   
   
	public Host(Integer host_id, String host_name, Profile profile) {
	super();
	this.host_id = host_id;
	this.host_name = host_name;
	this.profile = profile;
}



	public Integer getHost_id() {
		return host_id;
	}
	
	public void setHost_id(Integer host_id) {
		this.host_id = host_id;
	}
	
	public String getHost_name() {
		return host_name;
	}
	
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	   
	   
	   
}