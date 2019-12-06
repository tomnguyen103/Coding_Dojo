package com.tomnguyen7.driverslicense.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomnguyen7.driverslicense.models.License;
import com.tomnguyen7.driverslicense.models.Person;
import com.tomnguyen7.driverslicense.services.LicenseService;
import com.tomnguyen7.driverslicense.services.PersonService;

@Controller
public class LicensesController {
	private final LicenseService licenseService;
	
	@Autowired
	private PersonService personService;
	
	public LicensesController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	
	@GetMapping("/licenses/new")
	public String showLicenseForm(@ModelAttribute("license") License license, Model model) {
		List<Person> personList =  personService.allPersons();
		model.addAttribute("personList", personList);
		ArrayList<String> states = new ArrayList<String>(Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
				"Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
				"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
				"Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
				"Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"));
		model.addAttribute("states", states);
		
		return "newLicense.jsp";
	}
	
	@PostMapping("/add-license")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		}else {
			String number = licenseService.generateLicenseNum();
			license.setNumber(number);
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getId();
		}
	}
}
