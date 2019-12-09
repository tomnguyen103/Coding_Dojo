package com.tomnguyen7.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.ProductsAndCategories.models.CategoryProduct;

@Repository
public interface CategoryProductsRepository extends CrudRepository<CategoryProduct, Long> {
	List<CategoryProduct> findAll();
}
