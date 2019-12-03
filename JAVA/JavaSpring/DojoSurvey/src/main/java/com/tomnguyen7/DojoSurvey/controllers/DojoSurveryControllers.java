package com.tomnguyen7.DojoSurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveryControllers {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/submit-form")
	public String theForm(HttpSession session, @RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("language") String language, @RequestParam("comment") String comment) {
		
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", "null");
		if(comment != null) {
			session.setAttribute("comment", comment);
		}
		return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String result(HttpSession session, Model model) {
		String inputtedName = (String) session.getAttribute("name");
		String inputtedLocation = (String) session.getAttribute("location");
		String inputtedLanguage = (String) session.getAttribute("language");
		String inputtedComment = (String) session.getAttribute("comment");
		model.addAttribute("inputtedName", inputtedName);
		model.addAttribute("inputtedLocation", inputtedLocation);
		model.addAttribute("inputtedLanguage", inputtedLanguage);
		model.addAttribute("inputtedComment", inputtedComment);
		return "result.jsp";
	}
}
