package com.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.model.Person;

 

@Component
public class CallRestService implements CommandLineRunner{
	
	public static void callRestService() {
		RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject("http://localhost:8091/persons/3", Person.class);
		System.out.println("Nombre es: " + person.getFirstName());
	}

	@Override
	public void run(String... args) throws Exception {
		 
		callRestService();
	}

}
