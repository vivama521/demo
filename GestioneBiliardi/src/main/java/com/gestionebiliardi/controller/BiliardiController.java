package com.gestionebiliardi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BiliardiController {
	
	@RequestMapping("/")
	public ModelAndView hello(){
		String message = "Chi è piu' gay tra Valerio e Vittorio?";
		return new ModelAndView("hello","message", message);
		
	}

}
