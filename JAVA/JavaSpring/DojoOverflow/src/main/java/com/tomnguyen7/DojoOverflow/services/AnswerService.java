package com.tomnguyen7.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.DojoOverflow.models.Answer;
import com.tomnguyen7.DojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepo;
	
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	public Answer saveAnswer(Answer a) {
		return this.answerRepo.save(a);
	}
	
	public List<Answer> getAllAnswer(){
		return this.answerRepo.findAll();
	}
	public Answer findA(Long id) {
		Optional<Answer> optionalA = answerRepo.findById(id);
		if(optionalA.isPresent()) {
			return optionalA.get();
		}else {
			return null;
		}
	}
}
