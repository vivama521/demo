package com.gestionebiliardi.service;

import org.springframework.stereotype.Service;

@Service
public class ResultGay {
	
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
			return "Marzio";
		}else{
			return "Tullio";
		}
	}
}
