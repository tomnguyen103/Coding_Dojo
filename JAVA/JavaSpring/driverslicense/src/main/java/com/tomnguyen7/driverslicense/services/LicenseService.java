package com.tomnguyen7.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tomnguyen7.driverslicense.models.License;
import com.tomnguyen7.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
}
