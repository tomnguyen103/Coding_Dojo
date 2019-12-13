package com.tomnguyen7.EventBeltReviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tomnguyen7.EventBeltReviewer.models.User;
import com.tomnguyen7.EventBeltReviewer.services.MainService;
import com.tomnguyen7.EventBeltReviewer.validator.UserValidator;

@Controller
public class MainController {
	private final MainService mainService;
	// NEW
    private final UserValidator userValidator;
    
  
    public MainController(MainService mainService, UserValidator userValidator) {
        this.mainService = mainService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId==null) {
    		return "LoginPage.jsp";    		
    	}else {
    		return "redirect:/events";
    	}
    }
    @RequestMapping("/login")
    public String login(HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "LoginPage.jsp";    		
    	}else {
    		return "redirect:/events";
    	}
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "LoginPage.jsp";
    	}else {
    		User u = mainService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/events";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
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
    
    @RequestMapping("/events")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId==null) {
    		return "redirect:/login";
    	}else {
    		User u = mainService.findUserById(userId);
    		model.addAttribute("user", u);
    		return "homePage.jsp";    		
    	}
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/";
    }
}