package com.tomnguyen7.Course.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.tomnguyen7.Course.models.Course;
import com.tomnguyen7.Course.models.User;
import com.tomnguyen7.Course.repositories.CourseRepository;
import com.tomnguyen7.Course.repositories.UserRepository;

@Service
public class MainService {
	private final UserRepository userRepo;
	private final CourseRepository courseRepo;
	
	public MainService(UserRepository userRepo,CourseRepository courseRepo) {
		this.userRepo = userRepo;
		this.courseRepo = courseRepo;
	}
	
	//User Services
	// register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    //find all Users
    public List<User> findAllUser(){
    	return (List<User>) userRepo.findAll();
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    public void updateUser(User user) {
    	userRepo.save(user);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean duplicateUser(String email) {
    	User u = userRepo.findByEmail(email);
    	if(u == null) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    //*******************************////////
    
    // Course Services
    public List<Course> allCourses(){
    	return (List<Course>) courseRepo.findAll();
    }
    public Course addCourse(Course c) {
    	return courseRepo.save(c);
    }
    public void updateCourse(Course c) {
    	courseRepo.save(c);
    }
    public void deleteCourseById(Long id) {
    	courseRepo.deleteById(id);
    }
    public void deleteCourse(Course c) {
    	courseRepo.delete(c);
    }
    public Course findCourseById(Long id) {
    	Optional<Course> optionalC = courseRepo.findById(id);
    	if(optionalC.isPresent()) {
    		return optionalC.get();
    	}else {
    		return null;
    	}
    }
}
