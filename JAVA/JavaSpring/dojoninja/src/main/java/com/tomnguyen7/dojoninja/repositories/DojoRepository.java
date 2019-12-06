package com.tomnguyen7.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tomnguyen7.dojoninja.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
