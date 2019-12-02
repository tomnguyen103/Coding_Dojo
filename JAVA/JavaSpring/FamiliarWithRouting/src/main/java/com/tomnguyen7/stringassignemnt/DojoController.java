package com.tomnguyen7.stringassignemnt;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{dojo}")
	public String Dojo(@PathVariable("dojo") String dojo) {
		
		if(dojo.equals("dojo")) {
			return "The dojo is awesome";			
		}
		else if(dojo.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		else if(dojo.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		return dojo;
	}
	
}
