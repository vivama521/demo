package com.gestionebiliardi.controller;

import com.gestionebiliardi.entity.Person;
import com.gestionebiliardi.jparepo.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BiliardiController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonRepo personRepo;

	@RequestMapping("/")
	public ModelAndView hello(){
        Map<String, String> messaggi= new HashMap<>() ;
        String message ="";

        message = "Lista clienti ";
        messaggi.put("message1", message);

        message = "Trova cliente by id ";
        messaggi.put("message2", message);

        message = "Aggiorna cliente  ";
        messaggi.put("message3", message);

        message = "Elimina cliente ";
        messaggi.put("message4", message);

        message = "Inserisci cliente ";
        messaggi.put("message5", message);

		return new ModelAndView("hello","messaggi", messaggi);
	}

    @RequestMapping("/getAllCustomers")
    public ModelAndView getAllCustomers(){
        String procedure="getAllCustomers";
        logger.debug("Procedura:" + procedure);
        List<String> listaNomi= new ArrayList<>();
        List<Person> listPerson = new ArrayList<>();
		listPerson=personRepo.getAllCustomers();
        listPerson.forEach(e -> listaNomi.add(e.getName()+" "+e.getSecondName()));
        return new ModelAndView("resultCustomers","listaNomi", listaNomi );
    }

    @RequestMapping("/getCustomerById")
    public ModelAndView getCustomerById(){
	    int id=3;
        Person p=personRepo.getCustomerById(id);
        String nameCustomer=p.getIdPerson()+"-"+p.getName()+" "+p.getSecondName();
        return new ModelAndView("resultCustomer","nameCustomer", nameCustomer);
    }

    @RequestMapping("/jspConForm")
    public ModelAndView jspConForm() {
	    return new ModelAndView("jspConForm", "command", new Person());
    }

    @RequestMapping("/elaboraInfoForm")
    public ModelAndView elaboraInfoForm(@ModelAttribute("InsertPerson") Person person) {
	    logger.debug("Procedura: insertCustomer");
	    personRepo.insertCustomer(person.getName(), person.getSecondName());
	    return this.getAllCustomers();
    }

}

