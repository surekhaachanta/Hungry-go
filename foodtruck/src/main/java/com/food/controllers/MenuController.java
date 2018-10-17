package com.food.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.models.Item;
import com.food.service.CacheService;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private CacheService cacheService;
	
	@RequestMapping(value = "/items", method = RequestMethod.GET, produces="application/json")
	public List<Item> getAllMenuItems(){
		return cacheService.getAllItems();
	} 

	
}
