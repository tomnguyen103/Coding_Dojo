package com.tomnguyen7.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tomnguyen7.driverslicense.models.Person;
import com.tomnguyen7.driverslicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
}
