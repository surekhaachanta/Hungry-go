package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.food.models.Order;

@Transactional
public interface OrderDataService extends JpaRepository<Order, Integer> {
	
	@Modifying
	@Query("UPDATE Order d SET d.status= :status where d.id = :id")
	public int changeOrderStatus(@Param("id") int id, @Param("status") String status);
	
	@Modifying
	@Query("UPDATE Order d SET d.truck= :truck where d.id = :id")
	public int changeOrderTruck(@Param("id") int id, @Param("truck") String truck);
	
	
}
