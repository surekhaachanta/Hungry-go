package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.models.Cart;

public interface CartDataService extends JpaRepository<Cart, Integer> {

}

