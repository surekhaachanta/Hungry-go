package com.food.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	    	return tempItem ;
	    }
		
}
