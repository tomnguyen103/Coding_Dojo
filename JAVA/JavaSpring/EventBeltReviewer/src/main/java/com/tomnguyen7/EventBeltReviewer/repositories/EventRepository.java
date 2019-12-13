package com.tomnguyen7.EventBeltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.EventBeltReviewer.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
	
}
