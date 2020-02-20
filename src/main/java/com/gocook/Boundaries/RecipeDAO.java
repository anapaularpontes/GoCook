package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Recipe;

@Component
public interface RecipeDAO extends CrudRepository<Recipe, Integer> {

	@Query("SELECT r FROM Recipe r ORDER BY r.title ASC")
	Iterable<Recipe> getAllRecipes();
}
