package com.tomnguyen7.UserController1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tomnguyen7.UserController1.models.User;
import com.tomnguyen7.UserController1.services.UserService;
import com.tomnguyen7.UserController1.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	// NEW
    private final UserValidator userValidator;
    
  
    public MainController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId==null) {
    		return "registrationPage.jsp";    		
    	}else {
    		return "redirect:/home";
    	}
    }
    @RequestMapping("/login")
    public String login(HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "loginPage.jsp";    		
    	}else {
    		return "redirect:/home";
    	}
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}else {
    		model.addAttribute("error", "Invalid Credential. Please Try again!");
    		return "loginPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId==null) {
    		return "redirect:/login";
    	}else {
    		User u = userService.findUserById(userId);
    		model.addAttribute("user", u);
    		return "homePage.jsp";    		
    	}
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }
}
