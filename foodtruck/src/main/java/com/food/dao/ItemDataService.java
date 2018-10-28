package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.models.Item;

public interface ItemDataService extends JpaRepository<Item, Integer> {

}
