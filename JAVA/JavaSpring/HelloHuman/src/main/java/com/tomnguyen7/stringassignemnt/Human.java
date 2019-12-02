package com.tomnguyen7.stringassignemnt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Human {
	@RequestMapping("/")
	public String index(@RequestParam(value= "name", defaultValue="Human") String searchQuery) {
		return "Hello " +searchQuery+ "! \n Welcome to SpringBoot!";
	}
}
