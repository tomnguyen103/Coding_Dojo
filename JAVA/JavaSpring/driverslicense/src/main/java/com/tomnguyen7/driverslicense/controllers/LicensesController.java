package com.tomnguyen7.driverslicense.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tomnguyen7.driverslicense.models.License;
import com.tomnguyen7.driverslicense.services.LicenseService;

@Controller
public class LicensesController {
	private final LicenseService licenseService;
	
	public LicensesController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@GetMapping("/licenses/new")
	public String licenseNew(Model model) {
		List<License> licenses = licenseService.allLicenses();
		model.addAttribute("person", licenses);
		return "newLicense.jsp";
	}
	
}
