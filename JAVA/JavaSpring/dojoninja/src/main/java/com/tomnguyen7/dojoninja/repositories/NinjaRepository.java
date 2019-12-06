package com.tomnguyen7.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tomnguyen7.dojoninja.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
