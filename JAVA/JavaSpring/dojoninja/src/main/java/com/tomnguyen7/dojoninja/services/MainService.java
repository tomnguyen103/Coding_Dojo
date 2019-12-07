package com.tomnguyen7.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.dojoninja.models.Dojo;
import com.tomnguyen7.dojoninja.models.Ninja;
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
	
	public List<Dojo> getAllDojos(){
		return this.dojoRepository.findAll();
	}
	
	public Ninja saveNinja(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
	}
	
	public Dojo getDojoById(Long id) {
		Optional<Dojo> optionalDojo = this.dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
}
