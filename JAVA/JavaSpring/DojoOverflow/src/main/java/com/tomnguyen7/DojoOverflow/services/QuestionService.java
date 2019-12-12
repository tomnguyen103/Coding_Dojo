package com.tomnguyen7.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.DojoOverflow.models.Question;
import com.tomnguyen7.DojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public Question saveQuestion(Question q) {
		return this.questionRepository.save(q);
	}
	
	public List<Question> getAllQuestions(){
		return this.questionRepository.findAll();
	}
	
	public Question findById(Long id) {
		Optional<Question> optionalQ = questionRepository.findById(id);
		if(optionalQ.isPresent()) {
			return optionalQ.get();
		}else {
			return null;
		}
	}
	
	public Question findOne(String string) {
		Optional<Question> optionalQ = questionRepository.findByQuestion(string);
		if(optionalQ.isPresent()) {
			return optionalQ.get();
		}else {
			return null;
		}
	}
	public void updateQuestion(Question question) {
		questionRepository.save(question);
	}
}
