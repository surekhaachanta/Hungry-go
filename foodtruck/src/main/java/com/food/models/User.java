package com.food.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String userName;	
	@NotNull
	private String email;
	 @NotNull
	private String password;
	 
	
	 public User() {
	    }

	    public User(String userName) {
	        this.userName = userName;
	    }

	    public User(String userName, String password, String email) {
	        this.userName = userName;
	        this.password = password;
	        this.email = email;
	        
	    }

	    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	 @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("User{");
	        sb.append("userName='").append(userName).append('\'');
	        sb.append(", password='").append(password).append('\'');
	        sb.append(", email=").append(email);
	        sb.append('}');
	        return sb.toString();
	    }
}
