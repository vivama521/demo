package com.gestionebiliardi.jparepo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gestionebiliardi.entity.Person;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person, Long>{

    // call store procedure
    @Query(nativeQuery = true,value = "call getAllCustomers")
    List<Person> getAllCustomers();
    //bisogna capire come passare questo numero id dal controller
    @Query(nativeQuery = true,value = "call getCustomerById(:id)")
    Person getCustomerById(@Param("id") int id);

    @Query(nativeQuery = true,value = "call deleteCustomerById")
    List<Person> deleteCustomerById(int id);

    @Query(nativeQuery = true,value = "call updateCustomerById")
    Person updateCustomerById(int id,String name,String secondName);

    @Query(nativeQuery = true,value = "call insertCustomer(:name, :secondName)")
    List<Person>  insertCustomer(@Param("name")String name, @Param("secondName")String secondName);


}
