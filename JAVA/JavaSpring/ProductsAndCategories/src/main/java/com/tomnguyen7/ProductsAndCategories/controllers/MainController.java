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
import com.tomnguyen7.ProductsAndCategories.models.CategoryProduct;
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
	
	@GetMapping("/categories/new")
	public String newCategories(@ModelAttribute("category") Category category) {
		return "newCategories.jsp";
	}
	
	@PostMapping("/addproduct")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		else {
			Product newProduct = this.service.saveProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@PostMapping("/addcategory")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newCategories.jsp";
		}else {
			Category newCategory = this.service.saveCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@GetMapping("/products/{prodId}")
	public String showProduct(@PathVariable("prodId") Long prodId, @ModelAttribute("cateProdObj") CategoryProduct categoryProduct, Model model) {
		Product product = this.service.getProductById(prodId);
		model.addAttribute("product", product);
		model.addAttribute("categories", this.service.availableCategoriesForProduct(product));
		return "singleProduct.jsp";
	}

	@GetMapping("/categories/{catId}")
	public String showCategory(@PathVariable("catId") Long catId,@ModelAttribute("cateProdObj") CategoryProduct categoryProduct, Model model) {
		Category category = this.service.getCategoryById(catId);
		model.addAttribute("category", category);
		model.addAttribute("products", this.service.availableProductsForCategory(category));
		return "singleCategory.jsp";
	}
	
	
	
	
	@PostMapping("/addcategorytoproduct")
	public String addCatToProd(@Valid @ModelAttribute("cateProdObj") CategoryProduct catProd, BindingResult result, Model model){
		if(result.hasErrors()) {
			return "singleCategory.jsp";
		}else {
			CategoryProduct categoryProduct = this.service.addCatToProd(catProd);
//			model.addAttribute("CagetoryObj", categoryProduct);
			return "redirect:/products/" +  categoryProduct.getProduct().getId();
		}
	}
	
	@PostMapping("/addproducttocategory")
	public String addProdToCat(@Valid @ModelAttribute("cateProdObj") CategoryProduct catProd, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "singleProduct.jsp";
		}else {
			CategoryProduct categoryProduct = this.service.addProdToCat(catProd);
//			model.addAttribute("CategoryObj", cat);
			return "redirect:/categories/" + categoryProduct.getCategory().getId();
		}
	}
	
}
