package com.tomnguyen7.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		model.addAttribute("inputtedName", session.getAttribute("name"));
		model.addAttribute("inputtedColor", session.getAttribute("color"));
		return "index.jsp";
	}
	
	@PostMapping("/submit-form")
	public String submit(@RequestParam("name") String name, @RequestParam("color") String color, HttpSession session ) {
		session.setAttribute("name", name);
		session.setAttribute("color", color);
		return "redirect:/";
	}
}
