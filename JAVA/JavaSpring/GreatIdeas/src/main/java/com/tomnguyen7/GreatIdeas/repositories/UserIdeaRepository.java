package com.tomnguyen7.GreatIdeas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.GreatIdeas.models.UserIdea;

@Repository
public interface UserIdeaRepository extends CrudRepository<UserIdea, Long> {

}
