package com.food.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.food.dao.CartDataService;
import com.food.dao.ItemDataService;
import com.food.dao.OrderDataService;
import com.food.dao.UserDataService;
import com.food.models.Cart;
import com.food.models.Item;
import com.food.models.Order;
import com.food.models.User;

@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private ItemDataService itemDataService;

	@Autowired
	private CartDataService cartDataService;

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
	public void saveCart(List<Cart> cart) {
		System.out.println("inside cart");
		for (ListIterator<Cart> iter = cart.listIterator(); iter.hasNext();) {
			Cart element = iter.next();

			element.setAddress("address 1");
			element.setUserName("myname");
			element.setPhone("7147268016");
			cartDataService.save(element);
		}
	}

	@Override
	public void order(Order order) {
		System.out.println(order);
		orderDataService.save(order);
	}

	@Override
	@Cacheable("cartItems")
	public List<Cart> getAllCartItems() {
		System.out.println("Iniside getAllItems");
		List<Cart> cartList = new ArrayList<>();
		cartDataService.findAll().forEach(cartList::add);
		return cartList;
	}

}
