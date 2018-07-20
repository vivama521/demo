package com.gestionebiliardi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gestionebiliardi.service.PersonService;

@Service
@PropertySource("classpath:application.properties")
public class ResultGay {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	Environment env;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGayOfTheMoment(){
		
		int result = (int) (Math.random()*10);
		if(result <= 5){
			name = env.getProperty("valerio.gay");
		}else{
			name = env.getProperty("vittorio.gay");
		}
		return personService.getPersonByName(name).getName();
	}
}

