package com.gestionebiliardi.jparepo;

import org.springframework.data.repository.CrudRepository;

import com.gestionebiliardi.entity.Person;

public interface PersonRepo extends CrudRepository<Person, Long>{

}
