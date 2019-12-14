package com.tomnguyen7.EventBeltReviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="First Name must not be blank!")
    @Size(min=2,max=10, message="Please enter your First Name!")
    private String firstName;
    
    @NotBlank(message="Last Name must not be blank!")
    @Size(min=2,max=10, message="Please enter your Last Name!")
    private String lastName;
    
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message="Invalid email pattern")
	@Email(message="Email must be valid")
    private String email;
    
    @NotBlank(message="Location must not be blank!")
	@Size(min=2, max=60, message="Location must be more than 2 characters!")
    private String location;
    
    private String state;
    
    @NotBlank(message="Password cannot be blank!")
	@Size(min=5, message="Password must be greater than 5 characters")
    private String password;
	
    @Transient
    @NotBlank(message="Confirmation password cannot be blank!")
    private String passwordConfirmation;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public User() {
    }
    
    public User(String firstName, String lastName, String email, String location, String state, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
	}
    
    //Relationships
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "users_events",
    	joinColumns = @JoinColumn(name = "user_id"),
    	inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> joinedevents;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Event> events;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Message> messages;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Event> getJoinedevents() {
		return joinedevents;
	}

	public void setJoinedevents(List<Event> joinedevents) {
		this.joinedevents = joinedevents;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}