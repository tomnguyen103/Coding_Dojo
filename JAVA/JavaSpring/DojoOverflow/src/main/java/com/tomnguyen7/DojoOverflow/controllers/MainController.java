package com.tomnguyen7.DojoOverflow.controllers;


import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tomnguyen7.DojoOverflow.models.Answer;
import com.tomnguyen7.DojoOverflow.models.Question;
import com.tomnguyen7.DojoOverflow.models.Tag;
import com.tomnguyen7.DojoOverflow.services.AnswerService;
import com.tomnguyen7.DojoOverflow.services.QuestionService;
import com.tomnguyen7.DojoOverflow.services.TagService;

import antlr.collections.List;

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
	public String createQuestion(@Valid @ModelAttribute("addQuestion") Question question, BindingResult result, @RequestParam("myTag") String myTag, RedirectAttributes flash) {
		
		//check how many comma
		int numComma = myTag.replaceAll("[^,]", "").length();
		if(numComma>2) {
			flash.addFlashAttribute("errors", "You can only add 3 tags at the most!");
		}
		
		//check if uppercase
		if (!myTag.equals(myTag.toLowerCase())) {
			flash.addFlashAttribute("errors", "Must be lowercase!");
		}
		
		
		
		if(result.hasErrors() || (flash.getFlashAttributes().size()>0)) {
			return "redirect:/questions/new";
		}else {
			// create a question in database
			Question myQ = questionService.saveQuestion(question);
			
			List<String> items = (List<String>)Arrays.asList(myTag.trim().split("\\s*,\\s*"));
			ArrayList<Tag> tags = new ArrayList<Tag>();
			
			for(int i = 0; i<items.size();i++) {
				tags.add(tagService.createTag(items.get(i)));
			}
			
			this.questionService.saveQuestion(question);
			return "newQuestion.jsp";
		}
	}
	
	@GetMapping("/questions/{id}")
	public String showDetail(@ModelAttribute("ans") Answer answer, @PathVariable("id") Long id, Model model) {
		model.addAttribute("myQuestion", this.questionService.findQ(id));
		model.addAttribute("myTags", this.questionService.findQ(id).getTags());
		model.addAttribute("myAnswer", this.questionService.findQ(id).getAnswers());
		return "questionDetail.jsp";
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("ans") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/questions/" + answer.getQuestion().getId();
		}else {
			answerService.saveAnswer(answer);
			
			return "redirect:/questions/" + answer.getQuestion().getId();
		}
	}
}
