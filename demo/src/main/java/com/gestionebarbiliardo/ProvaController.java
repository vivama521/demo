package com.gestionebarbiliardo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProvaController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
