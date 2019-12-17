package com.tomnguyen7.GreatIdeas.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tomnguyen7.GreatIdeas.models.Idea;
import com.tomnguyen7.GreatIdeas.models.User;
import com.tomnguyen7.GreatIdeas.services.MainService;
import com.tomnguyen7.GreatIdeas.validator.UserValidator;


@Controller
public class MainController {
	private final MainService mainService;
    private final UserValidator userValidator;
    
  
    public MainController(MainService mainService, UserValidator userValidator) {
        this.mainService = mainService;
        this.userValidator = userValidator;
    }
    
    @GetMapping("")
    public String registerForm(@ModelAttribute("userObj") User user, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId==null) {
    		return "login.jsp";    		
    	}else {
    		return "redirect:/ideas";
    	}
    }
    @GetMapping("/login")
    public String login(HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "login.jsp";    		
    	}else {
    		return "redirect:/ideas";
    	}
    }
    
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("userObj") User user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "login.jsp";
    	}else {
    		User u = mainService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/ideas";
    	}
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam("login-email") String email, @RequestParam("login-password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = mainService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = mainService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/ideas";
    	}else {
    		model.addAttribute("error", "Invalid Credential. Please Try again!");
    		return "login.jsp";
    	}
    }
    
    @GetMapping("/ideas")
    public String home(@ModelAttribute("idea") Idea idea, HttpSession session, Model model) {
    	
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	
    	else {
    		User u = mainService.findUserById((Long) session.getAttribute("userId"));
    		model.addAttribute("user", u);
    		List<Idea> ideas = mainService.allIdeas();
    		model.addAttribute("ideas", ideas);
    		return "dashboard.jsp";
    	}  	
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/ideas/new")
    public String newIdea (@ModelAttribute("idea") Idea idea, Model model, HttpSession session) {
    	if (session.getAttribute("userId") != null) {
			
			Long userId = (Long) session.getAttribute("userId");
			User u = mainService.findUserById(userId);
			model.addAttribute("user", u);
			return "newIdea.jsp";
    	}else {
    		return "redirect:/";
    	}
    }
    @PostMapping("/addIdea")
    public String addIdeas(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session) {
    	
    	if(result.hasErrors()) {
    		return "newIdea.jsp";
    	}else {
    		Long userId = (Long) session.getAttribute("userId");
        	User u = mainService.findUserById(userId);
        	model.addAttribute("user", u);
    		Idea i = mainService.addIdea(idea);
    		model.addAttribute("idea", i);
    		return "redirect:/ideas";
    	}
    }
    
    @GetMapping("/ideas/{id}/delete")
    public String delete(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Long userId = (Long) session.getAttribute("userId");
		User u = mainService.findUserById(userId);
		
		if(mainService.findIdeaById(id).getUser().getId() == u.getId()) {
			model.addAttribute("idea", mainService.findIdeaById(id));
			mainService.deleteIdea(id);
			
		}else {
			return "redirect:/";			
		}
    	return "redirect:/ideas";
    }
    @GetMapping("/ideas/{id}")
    public String getIdea(@PathVariable("id")Long id, @ModelAttribute("idea") Idea idea, Model model, HttpSession session) {
    	Idea i = mainService.findIdeaById(id);
    	model.addAttribute("idea", i);
    	Long userId = (Long) session.getAttribute("userId");
    	User u = mainService.findUserById(userId);
    	model.addAttribute("user", u.getId());
    	
    	return "singleIdea.jsp";
    }
    @GetMapping("/ideas/{id}/edit")
    public String editForm(@PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, Model model, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		Long userId = (Long) session.getAttribute("userId");
		User u = mainService.findUserById(userId);
		
		if(mainService.findIdeaById(id).getUser().getId() == u.getId()) {
			model.addAttribute("idea", mainService.findIdeaById(id));
			return "edit.jsp";
		}else {
			return "redirect:/";			
		}
    }

    @PutMapping("/ideas/{id}/edit")
    public String update(@Valid @PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session) {
    	User user = mainService.findUserById((Long)session.getAttribute("userID"));
    	if(mainService.findIdeaById(id).getUser().getId() == user.getId()) {
    		if(result.hasErrors()) {
    			model.addAttribute("idea", mainService.findIdeaById(id));
    			return "edit.jsp";    			
    		}else {
    			Idea idea2 = mainService.findIdeaById(id);
        		model.addAttribute("idea", idea2);
        		model.addAttribute("user", user);
        		idea.setUser(user);
        		
        		mainService.updateIdea(idea);
        		return "redirect:/ideas";
    		}
    	}else {
    		return "redirect:/";
    	}
    }
}

