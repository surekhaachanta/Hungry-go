package com.food.service;

import com.food.dao.ItemDataService;
import com.food.dao.OrderDataService;
import com.food.dao.UserDataService;
import com.food.models.Item;
import com.food.models.Order;
import com.food.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private ItemDataService itemDataService;

	@Autowired
	private OrderDataService orderDataService;

	@Autowired
	private UserDataService userDataService;

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
	}

	@Override
	public List<Order> getAllorders() {
		System.out.println("Iniside getAllOrders");
		List<Order> orderList = new ArrayList<>();
		orderDataService.findAll().forEach(orderList::add);
		System.out.println("time "+orderList.get(0).getTime());
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

}
