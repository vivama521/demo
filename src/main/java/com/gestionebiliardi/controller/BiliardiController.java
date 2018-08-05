package com.gestionebiliardi.controller;

import com.gestionebiliardi.beanutil.ControllerUrlRepo;
import com.gestionebiliardi.entity.Person;
import com.gestionebiliardi.jparepo.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BiliardiController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonRepo personRepo;

    /*
     * Questo serve a far mappare gli attributi String facendo in modo che se l'input della form
     * è vuota o contiene solo spazi bianchi questo venga considerato come 'null'
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

	@RequestMapping("/")
	public ModelAndView hello(){
        Map<String, ControllerUrlRepo> messaggi= new HashMap<>() ;

        messaggi.put("message1", new ControllerUrlRepo("Lista clienti", "/getAllCustomers"));

        messaggi.put("message2", new ControllerUrlRepo("Trova cliente by id", "/getCustomerById"));

        messaggi.put("message3", new ControllerUrlRepo("Aggiorna cliente", ""));

        messaggi.put("message4", new ControllerUrlRepo("Elimina cliente", ""));

        messaggi.put("message5", new ControllerUrlRepo("Inserisci cliente", "/jspConForm"));

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
    public ModelAndView elaboraInfoForm(@ModelAttribute("insertPerson") @Valid Person person, BindingResult binding) {
	    logger.debug("Procedura: insertCustomer");
	    if(!binding.hasErrors()) {
            personRepo.insertCustomer(person.getName(), person.getSecondName());
            return this.getAllCustomers();
        }
        else {
            for(ObjectError e : binding.getAllErrors())
                System.out.println(e.getDefaultMessage());
            ModelAndView model = new ModelAndView("jspConForm", "command", person);
            model.addObject("errors", binding);
            return model;
        }
    }

}

