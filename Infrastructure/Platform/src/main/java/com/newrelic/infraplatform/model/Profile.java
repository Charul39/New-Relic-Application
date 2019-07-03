package com.newrelic.infraplatform.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties
public class Profile {
	
   @EmbeddedId
   private ProfileID profile_id;	  
   
   @NotNull
   private Integer acc_id;

   @NotBlank
   private String query_key;

   @NotBlank
    private String key_title;

   @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JsonBackReference
   private List<Host> hosts;

   public Profile() {
       super();
   }
    	    
   public Profile(ProfileID profile_id, @NotNull Integer acc_id, @NotBlank String query_key,
			@NotBlank String key_title, List<Host> hosts) {
	   super();
	   this.profile_id = profile_id;
	   this.acc_id = acc_id;
	   this.query_key = query_key;
	   this.key_title = key_title;
	   this.hosts = hosts;
   }

   public ProfileID getProfile_id() {
	   return profile_id;
   }

   public void setProfile_id(ProfileID profile_id) {
	   this.profile_id = profile_id;
   }
	
   public Integer getAcc_id() {
	   return acc_id;
   }

   public List<Host> getHosts() {
	   return hosts;
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

   public void setHosts(List<Host> hosts) {
	   this.hosts = hosts;
   }

   public void setKey_title(String key_title) {
	   this.key_title = key_title;
   }

   public void setQuery_key(String query_key) {
	   this.query_key = query_key;
   }

   @Override
   public String toString() {
	   return "Profile [profile_id=" + profile_id + ", acc_id=" + acc_id + ", query_key=" + query_key + ", key_title="
			+ key_title + ", hosts=" + hosts + "]";
   }
   
}