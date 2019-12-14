package com.tomnguyen7.EventBeltReviewer.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tomnguyen7.EventBeltReviewer.models.Event;
import com.tomnguyen7.EventBeltReviewer.models.Message;
import com.tomnguyen7.EventBeltReviewer.models.User;
import com.tomnguyen7.EventBeltReviewer.services.MainService;
import com.tomnguyen7.EventBeltReviewer.validator.UserValidator;

@Controller
public class MainController {
	private final MainService mainService;
    private final UserValidator userValidator;
    
  
    public MainController(MainService mainService, UserValidator userValidator) {
        this.mainService = mainService;
        this.userValidator = userValidator;
    }
    
    ArrayList<String> states = new ArrayList<String>(Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
			"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
			"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
    
    @GetMapping("")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId==null) {
    		model.addAttribute("states", states);
    		return "LoginPage.jsp";    		
    	}else {
    		return "redirect:/events";
    	}
    }
    @GetMapping("/login")
    public String login(HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "LoginPage.jsp";    		
    	}else {
    		return "redirect:/events";
    	}
    }
    
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		model.addAttribute("states", states);
    		return "LoginPage.jsp";
    	}else {
    		User u = mainService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/events";
    	}
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = mainService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = mainService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/events";
    	}else {
    		model.addAttribute("error", "Invalid Credential. Please Try again!");
    		return "LoginPage.jsp";
    	}
    }
    
    @GetMapping("/events")
    public String home(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
    	
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	
    	User u = mainService.findUserById((Long) session.getAttribute("userId"));
    	model.addAttribute("user", u);
    	session.setAttribute("states", states);
    	List<Event> events = mainService.allEvents();
    	List<Event> inState = new ArrayList<Event>();
    	List<Event> outOfState= new ArrayList<Event>();
    	
    	for(Event origin: events) {
    		if(origin.getState().equals(u.getState())) {
    			inState.add(origin);
    		}else {
    			outOfState.add(origin);
    		}
    	}
    	model.addAttribute("inState", inState);
    	model.addAttribute("outOfState", outOfState);
    	
    	return "homePage.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/events/{id}")
    public String viewEvent(@PathVariable("id") Long id, @Valid @ModelAttribute("message") Message message, BindingResult result, Model model, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}else {
    		User user = mainService.findUserById((Long) session.getAttribute("userId"));
    		Event event = mainService.findEventById(id);
    		List<Message> messages = event.getMessages();
    		Collections.reverse(messages);
    		
    		model.addAttribute("event", event);
    		model.addAttribute("messages", messages);
    		model.addAttribute("user", user);
    		model.addAttribute("attendees", event.getJoinedUsers());
    		return "viewEvent.jsp";
    	}
    	
    }
    
    @PostMapping("/addEvent")
    public String addEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "viewEvent.jsp";
    	}else {
    		mainService.addEvent(event);
    		return "redirect:/events";
    	}
    }
    
}