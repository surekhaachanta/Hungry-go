package com.food.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.food.dao.CrewDataService;
import com.food.dao.ItemDataService;
import com.food.dao.OrderDataService;
import com.food.dao.UserDataService;
import com.food.models.Crew;
import com.food.models.Item;
import com.food.models.Order;
import com.food.models.User;

@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private ItemDataService itemDataService;

	@Autowired
	private OrderDataService orderDataService;

	@Autowired
	private UserDataService userDataService;

	@Autowired
	private CrewDataService crewDataService;

	@Override
	@Cacheable("menuItems")
	public List<Item> getAllItems() {
		System.out.println("Iniside getAllItems");
		List<Item> itemList = new ArrayList<>();
		itemDataService.findAll().forEach(itemList::add);
		return itemList;
	}

	@CacheEvict("menuItems")
	@Override
	public void evictMenuItems() {
	}

	@Override
	@Cacheable("userDetails")
	public void saveUser(User user) {
		System.out.println("Iniside save uSer");
		userDataService.save(user);
	}

	@Override
	public boolean login(User user) {
		System.out.println(user);
		boolean isValidUser = false;
		try {
			Optional<User> userObj = userDataService.findByNameAndPassword(user.getUserName(), user.getPassword());
			System.out.println(userObj);
			if (userObj.get().getEmail() != null) {
				isValidUser = true;
				System.out.println("inside after finding user");
			}

		} catch (Exception e) {
			isValidUser = false;
			System.out.println("inside exception");
			System.out.println(e.getMessage());
		}

		return isValidUser;
	}

	@Override
	public void order(Order order) {
		System.out.println(order);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		order.setTime(time);
		orderDataService.save(order);
		sendGmailOrderPlaced(order.getUserName(),order.getEmail());
	}

	

	@Override
	public List<Order> getAllorders() {
		System.out.println("Iniside getAllOrders");
		List<Order> orderList = new ArrayList<>();
		orderDataService.findAll().forEach(orderList::add);
		System.out.println("time " + orderList.get(0).getTime());
		return orderList;
	}

	@Override
	public int changeStatus(Order order) {
		System.out.println("Iniside status");
		int changed = 0;
		int id = order.getId();
		String status = order.getStatus();
		changed = orderDataService.changeOrderStatus(id, status);
		return changed;
	}

	@Override
	public int changeTruck(Order order) {
		System.out.println("Iniside truck");
		int changed = 0;
		int id = order.getId();
		String truck = order.getTruck();
		changed = orderDataService.changeOrderTruck(id, truck);
		return changed;
	}

	@Override
	public List<Crew> getAllCrews() {
		System.out.println("Iniside getAllOrders");
		List<Crew> crewList = new ArrayList<>();
		crewDataService.findAll().forEach(crewList::add);
		return crewList;
	}

	@Override
	public int changeCrew(Crew crew) {
		System.out.println("Iniside crew truck");
		int changed = 0;
		String name = crew.getName();
		System.out.println("check here" + name);
		String truck = crew.getTruck();
		System.out.println("check here" + truck);
		sendFromGMailCrewChange(truck,crew.getEmail());
		changed = crewDataService.changeCrewTruck(name, truck);
		return changed;
	}

	private void sendFromGMailCrewChange(String truck, String email) {
		System.out.println("entered mail");
		String from = "hungrygo2@gmail.com";
		String pass = "codevelop";
		// Recipient's email ID needs to be mentioned.
		String to = email;

		String host = "smtp.gmail.com";
		
		 // Get system properties
		   Properties properties = System.getProperties();
		   // Setup mail server
		   properties.put("mail.smtp.starttls.enable", "true");
		   properties.put("mail.smtp.host", host);
		   properties.put("mail.smtp.user", from);
		   properties.put("mail.smtp.password", pass);
		   properties.put("mail.smtp.port", "587");
		   properties.put("mail.smtp.auth", "true");
		// Get the default Session object.
		   Session session = Session.getDefaultInstance(properties);

		   try{
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(session);

		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));

		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));

		      // Set Subject: header field
		      message.setSubject("Truck Change!!");

		      // Now set the actual message
		      message.setText("Your new Truck: "+truck);

		      // Send message
		      Transport transport = session.getTransport("smtp");
		      transport.connect(host, from, pass);
		      transport.sendMessage(message, message.getAllRecipients());
		      transport.close();
		      System.out.println("Sent message successfully....");
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		   }
	}
	
	private void sendGmailOrderPlaced(String userName, String email) {
		System.out.println("entered mail");
		String from = "hungrygo2@gmail.com";
		String pass = "codevelop";
		// Recipient's email ID needs to be mentioned.
		String to = email;

		String host = "smtp.gmail.com";
		
		 // Get system properties
		   Properties properties = System.getProperties();
		   // Setup mail server
		   properties.put("mail.smtp.starttls.enable", "true");
		   properties.put("mail.smtp.host", host);
		   properties.put("mail.smtp.user", from);
		   properties.put("mail.smtp.password", pass);
		   properties.put("mail.smtp.port", "587");
		   properties.put("mail.smtp.auth", "true");
		// Get the default Session object.
		   Session session = Session.getDefaultInstance(properties);

		   try{
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(session);

		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));

		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));

		      // Set Subject: header field
		      message.setSubject("Order Placed!!");

		      // Now set the actual message
		      message.setText("Hi "+userName+"\n Your Order is placed."+"\n Current Wait time is 30mins");
		      // Send message
		      Transport transport = session.getTransport("smtp");
		      transport.connect(host, from, pass);
		      transport.sendMessage(message, message.getAllRecipients());
		      transport.close();
		      System.out.println("Sent message successfully....");
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		   }
	}

}
