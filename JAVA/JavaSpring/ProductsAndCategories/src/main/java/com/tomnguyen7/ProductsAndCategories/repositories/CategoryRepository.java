package com.tomnguyen7.ProductsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.ProductsAndCategories.models.Category;
import com.tomnguyen7.ProductsAndCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	Optional<Category> findById(Long id);
	List<Category> findByProductsNotContains(Product product);
}
