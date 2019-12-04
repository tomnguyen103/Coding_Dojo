package com.tomnguyen7.mvcdemo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomnguyen7.mvcdemo.models.Movie;
import com.tomnguyen7.mvcdemo.services.MovieService;

@Controller
public class MainController {
	
	private final MovieService service;
	public MainController(MovieService service) {
		this.service = service;
	}
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("newMovie") Movie newMovie) {
		model.addAttribute("movies", service.findAllMovies());
		return "index.jsp";
	}
	@PostMapping("/movies")
	public String makeMovie(@Valid @ModelAttribute("newMovie") Movie newMovie, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			this.service.createMovie(newMovie);
			return "redirect:/";
		}
	}
	@GetMapping("/movie/{id}")
	public String movieDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("movie", this.service.findMovieById(id));
		return "detail.jsp";
	}
}
