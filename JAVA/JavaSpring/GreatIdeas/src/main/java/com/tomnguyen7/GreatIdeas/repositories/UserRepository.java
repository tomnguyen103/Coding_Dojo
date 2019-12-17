package com.tomnguyen7.GreatIdeas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.GreatIdeas.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
