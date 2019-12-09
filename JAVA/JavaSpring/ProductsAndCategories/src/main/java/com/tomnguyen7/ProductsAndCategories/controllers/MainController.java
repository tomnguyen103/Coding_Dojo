package com.tomnguyen7.ProductsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomnguyen7.ProductsAndCategories.models.Category;
import com.tomnguyen7.ProductsAndCategories.models.Product;
import com.tomnguyen7.ProductsAndCategories.services.MainService;

@Controller
public class MainController {
	private final MainService service;
	public MainController(MainService service) {
		this.service = service;
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/products")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		else {
			Product newProduct = this.service.saveProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.service.getProductById(id);
		model.addAttribute("product", product);
		return "singleProduct.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategories(@ModelAttribute("category") Category category) {
		return "newCategories.jsp";
	}
	@PostMapping("/categories")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newCategories.jsp";
		}else {
			Category newCategory = this.service.saveCategory(category);
			return "redirect:/categories/new";
		}
	}
}
