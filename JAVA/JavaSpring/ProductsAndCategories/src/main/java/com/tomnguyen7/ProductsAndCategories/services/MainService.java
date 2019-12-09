package com.tomnguyen7.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tomnguyen7.ProductsAndCategories.models.Category;
import com.tomnguyen7.ProductsAndCategories.models.CategoryProduct;
import com.tomnguyen7.ProductsAndCategories.models.Product;
import com.tomnguyen7.ProductsAndCategories.repositories.CategoryProductsRepository;
import com.tomnguyen7.ProductsAndCategories.repositories.CategoryRepository;
import com.tomnguyen7.ProductsAndCategories.repositories.ProductRepository;

@Service
public class MainService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final CategoryProductsRepository categoryProductsRepository;
	
	public MainService(CategoryRepository categoryRepository, ProductRepository productRepository, CategoryProductsRepository categoryProductsRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.categoryProductsRepository = categoryProductsRepository;
	}
	
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
	}
	
	public Category saveCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories(){
		return this.categoryRepository.findAll();
	}
	
	public CategoryProduct createCateProduct(CategoryProduct categoryProduct) {
		return this.categoryProductsRepository.save(categoryProduct);
	}
	
}
