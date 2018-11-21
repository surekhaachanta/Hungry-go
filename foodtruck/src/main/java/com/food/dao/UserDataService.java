package com.food.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.food.models.User;

public interface UserDataService extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u where u.userName = :userName AND u.password = :password")
	public Optional<User> findByNameAndPassword(@Param("userName") String userName,
			@Param("password") String password);
}
