package com.tomnguyen7.dojoninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomnguyen7.dojoninja.models.Dojo;
import com.tomnguyen7.dojoninja.models.Ninja;
import com.tomnguyen7.dojoninja.services.MainService;

@Controller
public class MainController {
	
	private final MainService service;
	public MainController(MainService service) {
		this.service = service;
	}
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		}else {
			Dojo newDojo = this.service.saveDojo(dojo);
			return "redirect:/dojos/new";
		}
		
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja) {
		return "ninja.jsp";
	}
	
	
}
