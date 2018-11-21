package com.food.controllers;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.models.User;
import com.food.service.CacheService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private CacheService cacheService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces="application/json")
	public void saveUser(@RequestBody User payload) throws URISyntaxException{
		try {
			cacheService.saveUser(payload);
		}
		 catch(Exception e) {
			 
		 }
	} 

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json")
	public boolean loginUser(@RequestBody User  payload) throws URISyntaxException{
		
			System.out.println("hereelogin");
			return cacheService.login(payload);
		
	} 
	
}
