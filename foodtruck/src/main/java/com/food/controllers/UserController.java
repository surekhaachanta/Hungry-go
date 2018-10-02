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
	    
	    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
	    public  void sendMail() {
	    	System.out.println("mail");
	    	 Properties props = new Properties();
	    	   props.put("mail.smtp.com" , "smtp.gmail.com");
	    	   Session session  = Session.getDefaultInstance( props , null);
	    	   String to = "999surru@gmail.com";
	    	   String from = "achantasurekha@gmail.com";
	    	   String subject = "Feedback From Hungry Go...";
	    	   Message msg = new MimeMessage(session);
	    	    try {
	    	      msg.setFrom(new InternetAddress(from));
	    	      msg.setRecipient(Message.RecipientType.TO , new InternetAddress(to));
	    	      msg.setSubject(subject);
	    	      msg.setText("Working fine..!");
	    	    }  catch(Exception exc) {
	    	      System.out.println(exc.getMessage());   
	    	    }
	    	 }
   
}
