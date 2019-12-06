package com.tomnguyen7.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.driverslicense.models.License;
import com.tomnguyen7.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	public static int licenseNum;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findTopByOrderByNumberDesc();
	}
	
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
		
	public License getLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		}else {
			return null;
		}
	}

	public static int getLicenseNum() {
		return licenseNum;
	}

	public static void setLicenseNum(int licenseNum) {
		LicenseService.licenseNum = licenseNum;
	}
	
	public String licenseToString(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	
	public String generateLicenseNum() {
		if(licenseRepository.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNum += 1;
			return licenseToString(licenseNum);
		}else {
			List<License> top = licenseRepository.findTopByOrderByNumberDesc();
			licenseNum = 1 + (Integer.parseInt(top.get(0).getNumber()));
			return licenseToString(licenseNum);
		}
		
	}
	
	
}
