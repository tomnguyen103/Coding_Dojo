package com.tomnguyen7.Course.controllers;

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

import com.tomnguyen7.Course.models.Course;
import com.tomnguyen7.Course.models.User;
import com.tomnguyen7.Course.services.MainService;
import com.tomnguyen7.Course.validator.UserValidator;

@Controller
public class MainController {
	public final MainService mainService;
	public final UserValidator userValidator;
	
	public MainController(MainService mainService, UserValidator userValidator) {
		this.mainService = mainService;
		this.userValidator = userValidator;
	}
	
	@GetMapping("")
	public String registerForm(@ModelAttribute("userObj") User user, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "login.jsp";
		}else {
			return "redirect:/courses";
		}
	}
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "login.jsp";
		}else {
			return "redirect:/courses";
		}
	}
	
	@PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("userObj") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "login.jsp";
    	}else {
    		User u = mainService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/courses";
    	}
    }
	
	@PostMapping("/login")
    public String loginUser(@RequestParam("login-email") String email, @RequestParam("login-password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = mainService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = mainService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/courses";
    	}else {
    		model.addAttribute("userObj", new User());
    		model.addAttribute("error", "Invalid Credential. Please Try again!");
    		return "login.jsp";
    	}
    }
    @GetMapping("/courses")
    public String home(@ModelAttribute("course") Course course, HttpSession session, Model model) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}else {
    		User u = mainService.findUserById((Long) session.getAttribute("userId"));
    		model.addAttribute("user",u);
    		List<Course> courses = mainService.allCourses();
    		model.addAttribute("courses", courses);
    		return "dashboard.jsp";
    	}
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/courses/new")
    public String newCourse(@ModelAttribute("course")Course course, Model model, HttpSession session) {
    	if (session.getAttribute("userId") != null) {
			Long userId = (Long) session.getAttribute("userId");
			User u = mainService.findUserById(userId);
			model.addAttribute("user", u);
			return "newCourse.jsp";
		}else {
			return "redirect:/";
		}
	}
    
    @PostMapping("/addCourse")
    public String addCourses(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model, HttpSession session) {
    	if(result.hasErrors()) {
    		return "newCourse.jsp";
    	}else {
    		Long userId = (Long) session.getAttribute("userId");
        	User u = mainService.findUserById(userId);
        	model.addAttribute("user", u);
    		Course c = mainService.addCourse(course);
    		model.addAttribute("course", c);
    		return "redirect:/courses";
    	}
    }
    
    @GetMapping("/courses/{id}/delete")
    public String delete(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Course myCourse = mainService.findCourseById(id);
    	if(myCourse != null) {
    		mainService.deleteCourse(myCourse);
    		return "redirect:/courses";
    	}else {
    		return "redirect:/courses";
    	}
    }
    
    @GetMapping("/courses/{id}")
    public String detail(@PathVariable("id")Long id, Model model, HttpSession session) {
    	Course c = mainService.findCourseById(id);
    	model.addAttribute("course", c);
    	
    	List<User> users = c.getUsers();
    	Long userId = (Long) session.getAttribute("userId");
    	User u = mainService.findUserById(userId);
    	model.addAttribute("currentUser", u);
    	return "singleCourse.jsp";
    }
    
    @GetMapping("/courses/{id}/edit")
    public String edit(@PathVariable("id")Long id, @ModelAttribute("course") Course course, Model model, HttpSession session) {
    	Course myCourse = mainService.findCourseById(id);
    	model.addAttribute("course", myCourse);
    	return "editCourse.jsp";
    }
    @PostMapping("/updateCourse")
    public String update(@Valid @ModelAttribute("course") Course course, BindingResult result) {
    	if(result.hasErrors()) {
    		return "editCourse.jsp";
    	}else {
//    		List<User> students = course.getUsers();
    		mainService.updateCourse(course);
    		return "redirect:/courses";
    	}
    }
    
    @GetMapping("/courses/add/{id}")
    public String addUserToCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	User u = mainService.findUserById(userId);
    	Course c = mainService.findCourseById(id);
    	
    	u.getCourses().add(c);
    	mainService.updateUser(u);
    	return "redirect:/courses";
    }
}
