package com.gestionebiliardi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionebiliardi.entity.Person;
import com.gestionebiliardi.jparepo.PersonRepo;
import com.gestionebiliardi.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepo personRepo;

	@Override
	public List<Person> getAllPerson() {
		List<Person> listPerson = new ArrayList<>();
		personRepo.findAll().forEach(e -> listPerson.add(e));
		return listPerson;
	}

	@Override
	public Person getPersonById(long idPerson) {
		Person person = personRepo.findById(idPerson).get();
		return person;
	}

	@Override
	public void updatePerson(Person person) {
		personRepo.save(person);
		
	}

	@Override
	public void deletePerson(int idPerson) {
		personRepo.delete(getPersonById(idPerson));
		
	}

	@Override
	public Person getPersonByName(String name) {
		List<Person> listPerson = getAllPerson();
		for(Person p : listPerson){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

	
}
