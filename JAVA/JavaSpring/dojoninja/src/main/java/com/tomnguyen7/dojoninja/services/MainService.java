package com.tomnguyen7.dojoninja.services;

import org.springframework.stereotype.Service;

import com.tomnguyen7.dojoninja.models.Dojo;
import com.tomnguyen7.dojoninja.repositories.DojoRepository;
import com.tomnguyen7.dojoninja.repositories.NinjaRepository;

@Service
public class MainService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public MainService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}	
	public Dojo saveDojo(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
	
	
}
