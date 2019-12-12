package com.tomnguyen7.DojoOverflow.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tomnguyen7.DojoOverflow.models.Question;
import com.tomnguyen7.DojoOverflow.models.Tag;
import com.tomnguyen7.DojoOverflow.services.QuestionService;
import com.tomnguyen7.DojoOverflow.services.TagService;


@Controller
public class MainController {
	private final QuestionService questionService;
	private final TagService tagService;
//	private final AnswerService answerService;
	
	
	public MainController(QuestionService questionService, TagService tagService) {
		this.questionService=questionService;
		this.tagService = tagService;
//		this.answerService = answerService;
	}
	
//	@GetMapping("/dashboard")
//	public String questionDashboard(Model model) {
////		model.addAttribute("questions", this.questionService.getAllQuestions());
//		return "questionDasboard.jsp";
//	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@Valid @ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	@PostMapping("/addQuestion")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, @RequestParam("myTag") String myTag,  BindingResult result, RedirectAttributes flash) {
	
		int numComma = myTag.replaceAll("[^,]", "").length();
		if(numComma>2) {
			flash.addFlashAttribute("errors", "You can only add 3 tags at the most!");
		}
		
		if (!myTag.equals(myTag.toLowerCase())) {
			flash.addFlashAttribute("errors", "Must be lowercase!");
		}
		
		if(result.hasErrors() || (flash.getFlashAttributes().size()>0)) {
			return "newQuestion.jsp";
		}else {
			Question myQ = this.questionService.findOne(question.getQuestion());
			if(myQ==null) {
				questionService.saveQuestion(question);
				myQ = this.questionService.findOne(question.getQuestion());
			}
			
			ArrayList<String> splitTags = new ArrayList<String>(Arrays.asList(myTag.toLowerCase().split(",")));
			
			List<Tag> findTag = myQ.getTags();
			
			for(int i=0;i <splitTags.size();i++) {
				String myString = splitTags.get(i);
				Tag myTag1 = tagService.findOne(myString);
				if(myTag1 == null) {
					myTag1 = new Tag(myString);
					tagService.createTag(myTag1);
				}
				if(!myQ.getTags().contains(myTag1)) {
					findTag.add(myTag1);
				}
				myQ.setTags(findTag);
				questionService.updateQuestion(myQ);
			}
			
			return "redirect:/questions/new";
			
		}
	}
	
//	@GetMapping("/questions/{id}")
//	public String showDetail(@ModelAttribute("ans") Answer answer, @PathVariable("id") Long id, Model model) {
//		model.addAttribute("myQuestion", this.questionService.findQ(id));
//		model.addAttribute("myTags", this.questionService.findQ(id).getTags());
//		model.addAttribute("myAnswer", this.questionService.findQ(id).getAnswers());
//		return "questionDetail.jsp";
//	}
	
//	@PostMapping("/addAnswer")
//	public String addAnswer(@Valid @ModelAttribute("ans") Answer answer, BindingResult result) {
//		if(result.hasErrors()) {
//			return "redirect:/questions/" + answer.getQuestion().getId();
//		}else {
//			answerService.saveAnswer(answer);
//			
//			return "redirect:/questions/" + answer.getQuestion().getId();
//		}
//	}
}
