package com.newrelic.infraplatform.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newrelic.infraplatform.dto.DataDTO;
import com.newrelic.infraplatform.dto.HostDTO;
import com.newrelic.infraplatform.dto.ProfileDTO;
import com.newrelic.infraplatform.dto.QueryKeyDTO;
import com.newrelic.infraplatform.dto.QueryKeyNameDTO;
import com.newrelic.infraplatform.dto.SaveProfileDTO;
import com.newrelic.infraplatform.dto.StatusDTO;
import com.newrelic.infraplatform.service.HostService;
import com.newrelic.infraplatform.service.IntegrationsService;
import com.newrelic.infraplatform.service.MetricsService;
import com.newrelic.infraplatform.service.ProfileService;

@RestController
@RequestMapping("/infra") 
@CrossOrigin
public class InfraController {	// Main Controller Class
	
	@Autowired
	ProfileService profileService;    
	@Autowired
	HostService hostService;
	@Autowired
	IntegrationsService integrationsService;
	@Autowired
	MetricsService metricsService;
    
	// 0. Fetch Profile Name corresponding to a Test Id and User Id - From DB
	@RequestMapping(value = "/{test_id}/{user_id}/getProfilesByTest", produces = "application/json")//, produces = "application/json"
    public List<String> getProfilesByTest(@PathVariable("user_id") Long user_id, @PathVariable("test_id") Long test_id){
		return integrationsService.FindProfilesByTest(test_id, user_id);
    }
	
    // 1. Returns list of existing Profile Names - From DB
    @RequestMapping(value = "/{user_id}/getProfiles", produces = "application/json")
    public List<ProfileDTO> getProfiles(@PathVariable("user_id") Long user_id){
    	return profileService.findAllByUserId(user_id);
    }
    
    //2. Get List of Key Titles - From DB
    @GetMapping(value = "/{user_id}/getKeyProfiles")
    public List<QueryKeyNameDTO> getQueryKeys(@PathVariable("user_id") Long user_id){    	
    	return profileService.findAllKeyNamesByUserId(user_id);
    }
    
    //3. Fetch List of Hosts - From New Relic
    @RequestMapping(value = "/{user_id}/getHosts", produces = MediaType.APPLICATION_JSON_VALUE) //---------------NEW
    public List<HostDTO> getHostList(@PathVariable("user_id") Long user_id, @Valid @RequestBody QueryKeyDTO key_profile){
    	return hostService.findHostList(user_id, key_profile);
    }
    
    //4. Save Profile + Test Table Entry - To DB
    @PostMapping(value="/{user_id}/saveProfile")
    public StatusDTO saveProfile(@Valid @RequestBody SaveProfileDTO useProfile, @PathVariable("user_id") Long user_id) {
    	profileService.saveProfileToDb(user_id,useProfile);
    	return new StatusDTO("Success");
    }
    
    //6. Fetch Data for specific graphs - From DB
    @RequestMapping(value = "/{test_run_id}/{parameter}/getData")
    public DataDTO getData(@PathVariable("test_run_id") Integer test_run_id, @PathVariable("parameter") String parameter){
    	return metricsService.getData(test_run_id, parameter);
    }
}  