package com.gestionebiliardi.controller;

import com.gestionebiliardi.entity.Person;
import com.gestionebiliardi.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestionebiliardi.serviceimpl.ResultGay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BiliardiController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonService personService;
	
	@Autowired
	private ResultGay resultGay;


	@RequestMapping("/")
	public ModelAndView hello(){
		String message = "Chi è piu' gay tra Valerio , Vittorio e Marzio?";
        String message2 = "Prova estrazione di tutti i dati nel db";
        Map<String, String> messaggi= new HashMap<>() ;
        messaggi.put("message", message);
        messaggi.put("message2", message2);
        logger.debug("Message: " + message);
        logger.debug("Message: " + message2);
		return new ModelAndView("hello","messaggi", messaggi);
		
	}

	@RequestMapping("/linkGay")
	public ModelAndView gayResponse(){
		String name = resultGay.getGayOfTheMoment();
		return new ModelAndView("resultGay","name", name);
		
	}

    @RequestMapping("/provaFindAll")
    public ModelAndView provaFindAll(){
        List<String> listaNomi= new ArrayList<>();
        List<Person> listPerson = new ArrayList<>();
        listPerson = personService.getAllPerson();
        listPerson.forEach(e -> listaNomi.add(e.getName()+" "+e.getSecondName()));
        return new ModelAndView("listaNomi","listaNomi", listaNomi);

    }
}
