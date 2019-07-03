package com.newrelic.infraplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//Main Spring Boot Application Class
@SpringBootApplication
public class InfraPlatformApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		  return application.sources(InfraPlatformApplication.class);
		 }
	
	public static void main(String[] args) {
		SpringApplication.run(InfraPlatformApplication.class, args); //Entry Point of Application
	}

}
