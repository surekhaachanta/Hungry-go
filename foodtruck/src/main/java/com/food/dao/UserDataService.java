package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.models.User;

public interface UserDataService extends JpaRepository<User, Integer>{


}
