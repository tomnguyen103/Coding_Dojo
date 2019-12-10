package com.tomnguyen7.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

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
	
	public Product saveProduct(Product p) {
		return this.productRepository.save(p);
	}
	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
	}
	
	public Category saveCategory(Category c) {
		return this.categoryRepository.save(c);
	}
	
	public List<Category> getAllCategories(){
		return this.categoryRepository.findAll();
	}
	
	public CategoryProduct createCateProduct(CategoryProduct categoryProduct) {
		return this.categoryProductsRepository.save(categoryProduct);
	}
	public Product getProductById(Long id){
		Optional<Product> optionalProduct = this.productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();			
		}else {
			return null;
		}
	}
	
	public void deleteP(Long id) {
		Optional<Product> optionalP = productRepository.findById(id);
		if(optionalP.isPresent()) {
			productRepository.deleteById(id);
		}
	}
	
	public Category getCategoryById(Long id) {
		Optional<Category> optionalCategory = this.categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public void deleteC(Long id) {
		Optional<Category> optionalC = categoryRepository.findById(id);
		if(optionalC.isPresent()) {
			categoryRepository.deleteById(id);
		}
	}
	
	public CategoryProduct addCatToProd(CategoryProduct catProd) {
		return this.categoryProductsRepository.save(catProd);
	}
	
	public CategoryProduct addProdToCat(CategoryProduct catProd) {
		return this.categoryProductsRepository.save(catProd);
	}
	
	public Iterable<Product> availableProductsForCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	public List<Category> availableCategoriesForProduct(Product product) {
        return categoryRepository.findByProductsNotContains(product);  
    }
}
