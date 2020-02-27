package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Ingredient;

@Component
public interface IngredientDAO extends CrudRepository<Ingredient, Integer> {

	@Query("SELECT i FROM Ingredient i WHERE i.active = true ORDER BY i.name ASC")
	Iterable<Ingredient> getAllIngredients();
}
