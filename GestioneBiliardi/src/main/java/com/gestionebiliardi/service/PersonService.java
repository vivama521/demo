package com.gestionebiliardi.service;

import java.util.List;

import com.gestionebiliardi.entity.Person;

public interface PersonService {

	List<Person> getAllPerson();
    Person getPersonById(long idPerson);
    void updatePerson(Person person);
    void deletePersonById(int idPerson);
    Person getPersonByName(String name);
}
