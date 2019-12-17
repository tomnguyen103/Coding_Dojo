package com.tomnguyen7.GreatIdeas.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.tomnguyen7.GreatIdeas.models.Idea;
import com.tomnguyen7.GreatIdeas.models.User;
import com.tomnguyen7.GreatIdeas.repositories.IdeaRepository;
import com.tomnguyen7.GreatIdeas.repositories.UserIdeaRepository;
import com.tomnguyen7.GreatIdeas.repositories.UserRepository;

@Service
public class MainService {
	private final UserRepository userRepo;
	private final IdeaRepository ideaRepo;
	private final UserIdeaRepository userIdeaRepo;
	
	public MainService(UserRepository userRepo,IdeaRepository ideaRepo, UserIdeaRepository userIdeaRepo) {
		this.userRepo = userRepo;
		this.ideaRepo = ideaRepo;
		this.userIdeaRepo = userIdeaRepo;
	}
	
	// User Services
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
    
    // Idea Services
    public List<Idea> allIdeas(){
    	return (List<Idea>) ideaRepo.findAll();
    }
    
    public Idea addIdea(Idea i) {
    	return ideaRepo.save(i);
    }
    
    public void updateIdea(Idea i) {
    	ideaRepo.save(i);
    }
    
    public void deleteIdea(Long id) {
    	ideaRepo.deleteById(id);
    }
    
    public Idea findIdeaById(Long id) {
    	Optional<Idea> optionalI = ideaRepo.findById(id);
    	if(optionalI.isPresent()) {
    		return optionalI.get();
    	}else {
    		return null;
    	}
    }
}
