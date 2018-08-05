package com.gestionebiliardi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_person")
	private int idPerson;

	@Column(name="name")
	@NotNull(message = "NOME è un campo obbligatorio")
	@Size(min = 2, max = 45, message = "NOME è troppo lungo. Max: 45")
	private String name;

	@NotNull(message = "COGNOME è un campo obbligatorio")
	@Size(min = 2, max = 45, message = "COGNOME è troppo lungo. Max: 45")
	@Column(name="second_name")
	private String secondName;

	public Person() {
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

}