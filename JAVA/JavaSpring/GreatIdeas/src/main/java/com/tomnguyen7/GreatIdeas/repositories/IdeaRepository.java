package com.tomnguyen7.GreatIdeas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.GreatIdeas.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
}
