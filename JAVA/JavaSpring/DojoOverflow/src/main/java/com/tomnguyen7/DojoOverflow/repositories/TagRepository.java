package com.tomnguyen7.DojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.DojoOverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
	Optional<Tag> findById(Long id);
	
	Optional<Tag> findByTagString(String string);
}
