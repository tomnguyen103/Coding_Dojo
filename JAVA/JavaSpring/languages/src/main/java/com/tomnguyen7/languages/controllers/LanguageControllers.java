package com.tomnguyen7.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomnguyen7.languages.models.Language;
import com.tomnguyen7.languages.services.LanguageService;

@Controller
public class LanguageControllers {
	private final LanguageService languageService;

	public LanguageControllers(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> langs = languageService.allLanguages();
		model.addAttribute("languages", langs);
		return "index.jsp";
	}
	
	@GetMapping("/languages/new")
	public String newLang(@ModelAttribute("language") Language language) {
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("lang", this.languageService.findLanguage(id));
		return "showLang.jsp";
	}
	
	@GetMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteL(id);
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findLanguage(id);
		model.addAttribute("language", lang);
		return "edit.jsp";
	}
	
	@PostMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageService.updateL(language);
			return "redirect:/languages";
		}
	}
	
	
	
}
