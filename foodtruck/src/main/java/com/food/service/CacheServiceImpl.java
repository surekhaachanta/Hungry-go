package com.food.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
	public boolean login(String user) {
		System.out.println(user);
		boolean isValidUser = false;
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
		// for (ListIterator<Order> iter = order.listIterator(); iter.hasNext();) {

		order.setQty(1);
		order.setTitle("Chicken Burger");
		order.setCategory("burger");
		order.setAddress("address 1");
		order.setUserName("myname");
		order.setPhone("7147268016");
		order.setStatus("Pending");
		order.setTotal(30.00);
		orderDataService.save(order);
		// }
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
