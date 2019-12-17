package com.tomnguyen7.GreatIdeas.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="ideas")
public class Idea {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="Idea must not be blank!")
    @Size(min=2,max=20, message="Please enter at least 2 characters!")
    private String content;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
//    	@ManyToMany(fetch = FetchType.LAZY)
//		@JoinTable(
//		name = "users_likes",
//		joinColumns = @JoinColumn(name = "like_id"),
//		inverseJoinColumns = @JoinColumn(name = "user_id")
//	)
//	private List<User> likeUsers;
    
    public Idea() {
    	
    }
    public Idea(User user, String content) {
    	this.user = user;
    	this.content = content;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<User> getLikeUsers() {
//		return likeUsers;
//	}
//
//	public void setLikeUsers(List<User> likeUsers) {
//		this.likeUsers = likeUsers;
//	}
    
	
    
}
