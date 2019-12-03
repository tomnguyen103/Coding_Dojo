package com.tomnguyen7.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}
}
