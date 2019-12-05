package com.tomnguyen7.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.languages.models.Language;
import com.tomnguyen7.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalL = languageRepository.findById(id);
		if(optionalL.isPresent()) {
			return optionalL.get();
		}else {
			return null;
		}
	}
	
	public Language updateL(Language l) {
		return this.languageRepository.save(l);
	}
	
	public void deleteL(Long id) {
		Optional<Language> optionalL = languageRepository.findById(id);
		if(optionalL.isPresent()) {
			languageRepository.deleteById(id);
		}
	}
	
}
