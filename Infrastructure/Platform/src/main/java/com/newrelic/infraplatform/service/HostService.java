package com.newrelic.infraplatform.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newrelic.infraplatform.dto.HostDTO;
import com.newrelic.infraplatform.dto.QueryKeyDTO;
import com.newrelic.infraplatform.repository.HostRepository;
import com.newrelic.infraplatform.repository.ProfileRepository;

@Service
public class HostService {

	@Autowired
	HostRepository hostRepository;
	@Autowired
	ProfileRepository profileRepository;
	
	//Return List of Hosts corresponding to a User Id and Key Profile
	public List<HostDTO> findHostList(Long user_id , @Valid QueryKeyDTO key_profile){
		
		System.out.println("In findHostList Method");
		String key_title = key_profile.getKey_title();
		System.out.println(key_title);
		
		//Check if Key Profile is already present or not
		Integer check = profileRepository.CheckKeyProfile(user_id, key_title);
		System.out.println("Check if Key Profile is already present or not" + check);
		
		if(check == 0){
			System.out.println("Key Profile Not found");
			Integer account_id = key_profile.getAcc_id();
			String query_key = key_profile.getQuery_key();
			return HostListUtil(account_id, query_key);
		}
		else {
			System.out.println("Key Profile Found");
			QueryKeyDTO queryKeyDTO = profileRepository.findKeysProfile(user_id, key_title);
			Integer account_id = queryKeyDTO.getAcc_id();
			String query_key = queryKeyDTO.getQuery_key();
			return HostListUtil(account_id, query_key);
		}
	}

	//Utility Method for getting List of Hosts
	public List<HostDTO> HostListUtil(Integer account_id, String query_key){
		
		System.out.println("In HostListUtil Method");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		String urlString = "https://insights-api.newrelic.com/v1/accounts/"
				+ account_id.toString()
				+ "/query?nrql=SELECT uniques(fullHostname) FROM SystemSample SINCE 1 minute ago";
		
		System.out.println(urlString);
		headers.set("X-Query-Key", query_key);
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(urlString, HttpMethod.GET, httpEntity, String.class);
		
		String s = responseEntity.getBody();
		
		List<HostDTO> lHostDTOs = new ArrayList<HostDTO>();
		
		// JSON Response Extraction
		try {
				JSONObject joMain = new JSONObject(s);
				JSONArray jaResults = (JSONArray)joMain.get("results");
				JSONObject subjo = (JSONObject)jaResults.get(0);
		        JSONArray mem = (JSONArray)subjo.get("members");
		        System.out.println(mem);
		        for(int j = 0 ; j < mem.length() ; j++) {
		            String a = (String)mem.get(j);
		            HostDTO h = new HostDTO();         
		            h.setFullHostname(a);
		            lHostDTOs.add(h);
		        }
		        System.out.println("Host List Fetched...");    
			}
		catch (Exception e) {
			System.out.println("Error In HostListUtil");
			e.printStackTrace();
		}
		return lHostDTOs;
	}

}
