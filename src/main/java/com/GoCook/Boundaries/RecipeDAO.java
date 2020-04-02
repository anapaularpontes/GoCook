package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Recipe;

/**
 * Extends CrudRepository for Recipe Entity
 * @author 300300914
 *
 */
@Component
public interface RecipeDAO extends CrudRepository<Recipe, Integer> {

	@Query("SELECT r FROM Recipe r WHERE r.active = true ORDER BY r.title ASC")
	Iterable<Recipe> getAllRecipes();
}
