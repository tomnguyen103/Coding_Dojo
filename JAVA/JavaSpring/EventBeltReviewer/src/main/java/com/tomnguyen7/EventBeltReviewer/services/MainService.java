package com.tomnguyen7.EventBeltReviewer.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.tomnguyen7.EventBeltReviewer.models.Event;
import com.tomnguyen7.EventBeltReviewer.models.Message;
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
	
	// User Services
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
    
    // Event Services
    
    public List<Event> allEvents(){
    	return (List<Event>) eventRepo.findAll();
    }
    
    public Event addEvent(Event e) {
    	return eventRepo.save(e);
    }
    
    public void updateEvent(Event e) {
    	eventRepo.save(e);
    }
    
    public void deleteEvent(Long id) {
    	eventRepo.deleteById(id);
    }
    
    public Event findEventById(Long id) {
    	Optional<Event> optionalE = eventRepo.findById(id);
    	if(optionalE.isPresent()) {
    		return optionalE.get();
    	}else {
    		return null;    		
    	}
    }
    
    // Message Services
    public Message addMessage(Message m) {
    	return messageRepo.save(m);
    }
    public List<Message> allMessages(){
    	return (List<Message>) messageRepo.findAll();
    }
    
    public void updateMessage(Message m) {
    	messageRepo.save(m);
    }
    
    public void deleteMessage(Long id) {
    	messageRepo.deleteById(id);
    }
    
    public Message findMessageById(Long id) {
    	Optional<Message> e = messageRepo.findById(id);
    	if(e.isPresent()) {
    		return e.get();
    	}else {
    		return null;
    	}
    }
}
