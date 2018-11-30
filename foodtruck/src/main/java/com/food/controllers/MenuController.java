package com.food.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.ItemDataService;
import com.food.models.Crew;
import com.food.models.Item;
import com.food.models.Order;
import com.food.service.CacheService;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private CacheService cacheService;

	@Autowired
	private ItemDataService itemDataService;

	@RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
	public List<Item> getAllMenuItems() {
		return cacheService.getAllItems();
	}

	@RequestMapping(value = "/item", method = RequestMethod.PUT, produces = "application/json")
	public boolean addItem(@RequestBody Item newItem) {
		try{
			itemDataService.save(newItem);

			cacheService.evictMenuItems();
		} catch (Exception e){
			e.getStackTrace();
		}

		return false;
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public boolean deleteMenuItem(@PathVariable("id") int ItemId) {
		try{
			Item item = itemDataService.findOne(ItemId);
			itemDataService.delete(item);

			cacheService.evictMenuItems();
		} catch (Exception e){
			e.getStackTrace();
		}

		return false;
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> getAllOrders() {
		return cacheService.getAllorders();
	}
	
	@RequestMapping(value = "/getCrews", method = RequestMethod.GET)
	public List<Crew> getAllCrews() {
		return cacheService.getAllCrews();
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public int changeStatus(@RequestBody Order order) throws URISyntaxException {
		return cacheService.changeStatus(order);
	}


	@RequestMapping(value = "/changeTruck", method = RequestMethod.POST)
	public int changeTruck(@RequestBody Order order) throws URISyntaxException {
		return cacheService.changeTruck(order);
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public void Order(@RequestBody Order order) throws URISyntaxException {
		System.out.println(order);
		cacheService.order(order);
	}

	@RequestMapping(value = "/changeCrew", method = RequestMethod.POST)
	public int changeCrew(@RequestBody Crew crew) throws URISyntaxException {
		return cacheService.changeCrew(crew);
	}

}
