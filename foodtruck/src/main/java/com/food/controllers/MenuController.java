package com.food.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.models.Cart;
import com.food.models.Item;
import com.food.models.Order;
import com.food.service.CacheService;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private CacheService cacheService;

	@RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
	public List<Item> getAllMenuItems() {
		return cacheService.getAllItems();
	}

		@RequestMapping(value = "/order", method = RequestMethod.POST)
	public void Order(@RequestBody List<Order> order) throws URISyntaxException {
		cacheService.order(order);
	}
	
	
}
