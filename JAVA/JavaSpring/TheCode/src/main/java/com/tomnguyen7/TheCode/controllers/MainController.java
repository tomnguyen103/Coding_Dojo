package com.tomnguyen7.TheCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/submit-form")
	public String submit(@RequestParam("code") String code) {
		String result = "";
		if(code.equals("bushido")) {
			result = "redirect:/result";
		}else {
			result = "redirect:/show-error";
		}
		return result;
	}
	
	@RequestMapping("/result")
	public String display() {
		return "code.jsp";
	}
	
	@RequestMapping("/show-error")
	public String errorMessage(RedirectAttributes redirect) {
		redirect.addFlashAttribute("error", "Try Again!");
		return "redirect:/";
	}
}
