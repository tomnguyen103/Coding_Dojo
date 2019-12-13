package com.tomnguyen7.EventBeltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.EventBeltReviewer.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long>{
	
}
