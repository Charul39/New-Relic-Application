package com.newrelic.infraplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newrelic.infraplatform.repository.IntegrationsRepository;

@Service
public class IntegrationsService {

	@Autowired
	IntegrationsRepository integrationsRepository;
	
	public List<String> FindProfilesByTest(Long test_id, Long user_id){
		System.out.println("In Integrations Service");
		return integrationsRepository.findProfilesByTest(test_id, user_id);
	}
}
