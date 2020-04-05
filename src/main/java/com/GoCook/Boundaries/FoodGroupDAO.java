package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.FoodGroup;



/**
 * Extends CrudRepository for FoodGroup Entity
 * @author 300300914
 *
 */
@Component
public interface FoodGroupDAO extends CrudRepository<FoodGroup, Integer> {
	
	@Query("SELECT fg FROM FoodGroup fg WHERE fg.active = true ORDER BY fg.name ASC")
	Iterable<FoodGroup> getAllFoodGroups();
}
