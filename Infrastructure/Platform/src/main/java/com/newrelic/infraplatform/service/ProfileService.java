package com.newrelic.infraplatform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.newrelic.infraplatform.dto.ProfileDTO;
import com.newrelic.infraplatform.dto.QueryKeyDTO;
import com.newrelic.infraplatform.dto.QueryKeyNameDTO;
import com.newrelic.infraplatform.dto.SaveProfileDTO;
import com.newrelic.infraplatform.model.Host;
import com.newrelic.infraplatform.model.Integrations;
import com.newrelic.infraplatform.model.Profile;
import com.newrelic.infraplatform.model.ProfileID;
import com.newrelic.infraplatform.repository.IntegrationsRepository;
import com.newrelic.infraplatform.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	IntegrationsRepository integrationsRepository;
	
	public List<ProfileDTO> findAllByUserId(@Valid Long user_id) {
		return profileRepository.findAllByUserId(user_id);
	}

	public Profile getProfileByProfileName(String profile_name,Long user_id) {	
		ProfileID temp = new ProfileID(user_id, profile_name);
		Optional<Profile> op = profileRepository.findById(temp);
		if(op.isPresent()==true) {
			return op.get();
		}else {
			Profile nullProfile = new Profile();
			return nullProfile;
		}
	}

	public List<QueryKeyDTO> findAllKeysByUserId(Long user_id) {
		return profileRepository.findAllKeysByUserId(user_id);
	}

	public List<HostDTO> getHosts(Integer acc_id, String query_key) {
		System.out.println("gethosts called from service");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		

		headers.set("X-Query-Key", query_key);
		headers.set("Accept", "application/json");
		
		HttpEntity<String> entity = new HttpEntity<String> (headers);		 
		String NRQLQuery = "SELECT uniques(fullHostname) FROM SystemSample SINCE 1 minute ago";
		
		String url = "https://insights-api.newrelic.com/v1/accounts/"+acc_id.toString()+"/query?nrql="+NRQLQuery;
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		
		String s = response.getBody();
		System.out.println(" json object received");
			
		return getHostsFromJSON(s);
		
	}

	private List<HostDTO> getHostsFromJSON( String s) {
		List<HostDTO> ans = new ArrayList<HostDTO>();
		try {
		JSONObject jo = new JSONObject(s);
		JSONArray jArray = (JSONArray) jo.get("results");
		JSONObject subjo = (JSONObject)jArray.get(0);
		JSONArray mem = (JSONArray)subjo.get("members");
		System.out.println(mem);
		for(int i = 0 ; i < mem.length() ; i++) {
			String a = (String)mem.get(0);
			HostDTO h = new HostDTO();			
			h.setFullHostname(a);
			ans.add(h);
		}
		}catch(Exception e) {
			System.out.println("JSON exception while processing NewRelic Host List");
		}
		return ans;
	}

	public List<QueryKeyNameDTO> findAllKeyNamesByUserId(Long user_id) {
		return profileRepository.findAllKeyNamesByUserId(user_id);
	}

	public List<HostDTO> setOldKey(String key_title) {
		QueryKeyDTO temp = profileRepository.findKeyByKeyTitle(key_title);
		return getHosts(temp.getAcc_id(), temp.getQuery_key());
	}

	public void saveProfileToDb(Long user_id, @Valid SaveProfileDTO useProfileDTO) {
        
        ProfileID pid = new ProfileID(user_id, useProfileDTO.getProfile_name());
        Optional<Profile> optionalProfile = profileRepository.findById(pid);
        Profile profile = new Profile();
        
        if(optionalProfile.isPresent()==true) {
            System.out.println("Old Profile found complete...");
            profile = optionalProfile.get();
        }
        else {
            System.out.println("New Profile... Being Created");
            //update profile and save to db
            profile.setProfile_id(pid);
            
            if(useProfileDTO.getAcc_id()==-1) {
                QueryKeyDTO oldkeydto = profileRepository.findKeyByKeyTitle(useProfileDTO.getKey_title());
                System.out.println("Old key to be used");
                profile.setAcc_id(oldkeydto.getAcc_id());
                profile.setKey_title(oldkeydto.getKey_title());
                profile.setQuery_key(oldkeydto.getQuery_key());
            }
            else {
                System.out.println("new key to be used");
                profile.setAcc_id(useProfileDTO.getAcc_id());
                profile.setKey_title(useProfileDTO.getKey_title());
                profile.setQuery_key(useProfileDTO.getQuery_key());                
            }
            
            List<HostDTO> hdtolist = useProfileDTO.getHostList();
            List<Host> listHosts = new ArrayList<Host>();
            for(int i = 0 ; i < hdtolist.size(); i++) {
                HostDTO temp = hdtolist.get(i);
                Host host = new Host();
                host.setHost_name(temp.getFullHostname());
                host.setProfile(profile);
                listHosts.add(host);
            }
            profile.setHosts(listHosts);
            profileRepository.save(profile);
        }
        // now add to Integrations table
        Integrations newIntegrations = new Integrations(useProfileDTO.getTest_id(), profile.getProfile_id().getUser_id(), profile.getProfile_id().getProfile_name());
        System.out.println("Integration is now saved or updated");
        integrationsRepository.save(newIntegrations);
        return;
    }

	public void saveOldProfile(Long user_id, @Valid ProfileDTO chosenProfile) {
		Integrations newIntegrations = new Integrations(chosenProfile.getTest_id(),user_id, chosenProfile.getProfile_name());
		integrationsRepository.save(newIntegrations);
	}
	
}