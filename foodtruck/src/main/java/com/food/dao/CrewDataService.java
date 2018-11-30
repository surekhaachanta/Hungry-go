package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.food.models.Crew;
@Transactional
public interface CrewDataService extends JpaRepository<Crew, String> {

	
	@Modifying
	@Query("UPDATE Crew d SET d.truck= :truck where d.name = :name")
	public int changeCrewTruck(@Param("name")String name, @Param("truck") String truck);

}
