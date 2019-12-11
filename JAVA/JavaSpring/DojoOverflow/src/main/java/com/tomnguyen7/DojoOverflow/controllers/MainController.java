package com.tomnguyen7.DojoOverflow.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomnguyen7.DojoOverflow.models.Question;
import com.tomnguyen7.DojoOverflow.services.AnswerService;
import com.tomnguyen7.DojoOverflow.services.QuestionService;
import com.tomnguyen7.DojoOverflow.services.TagService;

@Controller
public class MainController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	
	public MainController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService=questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}
	
	@GetMapping("/dashboard")
	public String questionDashboard(Model model) {
//		model.addAttribute("questions", this.questionService.getAllQuestions());
		return "questionDasboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	@PostMapping("/addQuestion")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}else {
			this.questionService.saveQuestion(question);
			return "newQuestion.jsp";
		}
	}
}
