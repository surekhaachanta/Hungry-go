package com.food.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.ItemDao;
import com.food.models.Item;

@RestController
public class UserController {

	  @Autowired
	    private ItemDao itemDao;
	    
	    @RequestMapping(value = "/items", method = RequestMethod.GET)
	    public  List<Item> getItems() {
	    	List<Item> tempItem = new LinkedList<Item>();
	    	tempItem = itemDao.findAllItems();
	    	System.out.println(tempItem);
	    	return tempItem ;
	    }
   
   
}
