package com.tomnguyen7.driverslicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomnguyen7.driverslicense.models.Person;
import com.tomnguyen7.driverslicense.services.LicenseService;
import com.tomnguyen7.driverslicense.services.PersonService;

@Controller
public class PersonsController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonsController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@GetMapping("/")
	public String homePage() {
		return "redirect:/persons/new";
	}
	
	@GetMapping("/persons/new")
	public String showPersonForm(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}else {
			personService.createPerson(person);
			return "redirect:/profile";
		}
	}
}
