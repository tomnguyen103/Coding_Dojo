package com.tomnguyen7.EventBeltReviewer.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.tomnguyen7.EventBeltReviewer.models.User;
import com.tomnguyen7.EventBeltReviewer.repositories.EventRepository;
import com.tomnguyen7.EventBeltReviewer.repositories.MessageRepository;
import com.tomnguyen7.EventBeltReviewer.repositories.UserEventRepository;
import com.tomnguyen7.EventBeltReviewer.repositories.UserRepository;

@Service
public class MainService {
	private final UserRepository userRepo;
	private final EventRepository eventRepo;
	private final MessageRepository messageRepo;
	private final UserEventRepository userEventRepo;
	
	public MainService(UserRepository userRepo, EventRepository eventRepo, MessageRepository messageRepo, UserEventRepository userEventRepo) {
		this.userRepo = userRepo;
		this.eventRepo = eventRepo;
		this.messageRepo = messageRepo;
		this.userEventRepo = userEventRepo;
	}
	
	// register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
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
}
