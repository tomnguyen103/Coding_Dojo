package com.tomnguyen7.driverslicense.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tomnguyen7.driverslicense.models.Person;
import com.tomnguyen7.driverslicense.services.PersonService;

@Controller
public class PersonsController {
	private final PersonService personService;
	
	public PersonsController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/")
	public String homePage() {
		return "redirect:/persons/new";
	}
	
	@GetMapping("/persons/new")
	public String personNew(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("person", persons);
		return "newPerson.jsp";
	}
}
