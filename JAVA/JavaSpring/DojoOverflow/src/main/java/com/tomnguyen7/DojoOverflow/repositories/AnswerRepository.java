package com.tomnguyen7.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomnguyen7.DojoOverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long>{
	List<Answer> findAll();
}
