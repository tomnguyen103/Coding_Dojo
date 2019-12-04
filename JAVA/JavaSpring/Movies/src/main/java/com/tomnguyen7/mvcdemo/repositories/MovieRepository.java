package com.tomnguyen7.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.mvcdemo.models.Movie;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	List<Movie> findAll();
}
