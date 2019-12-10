package com.tomnguyen7.ProductsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.ProductsAndCategories.models.Category;
import com.tomnguyen7.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Optional<Product> findById(Long id);
	Iterable<Product> findByCategoriesNotContains(Category category);
}
