package com.gestionebiliardi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestionebiliardi.serviceimpl.ResultGay;

@Controller
public class BiliardiController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResultGay resultGay;
	
	@RequestMapping("/")
	public ModelAndView hello(){
		String message = "Chi è piu' gay tra Valerio e Vittorio?";
		logger.debug("Message: " + message);
		return new ModelAndView("hello","message", message);
		
	}

	@RequestMapping("/linkGay")
	public ModelAndView gayResponse(){
		String name = resultGay.getGayOfTheMoment();
		return new ModelAndView("resultGay","name", name);
		
	}
}
