package com.tomnguyen7.dojoninja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tomnguyen7.dojoninja.models.Dojo;

@Controller
public class MainController {
	@GetMapping("/")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
}
