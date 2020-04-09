package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Ingredient;
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
	
	@Query(value="SELECT * FROM Recipe ORDER BY rand() LIMIT 9", nativeQuery = true)
	Iterable<Recipe> getRandomRecipes();
	
	@Query("SELECT r FROM Recipe r JOIN r.categories c WHERE " +
			"c.id = :catId ORDER BY r.title ASC")
	Iterable<Recipe> findByCategory(@Param("catId") int catId);
	
	/*@Query("SELECT r FROM Recipe r"
			+ " JOIN r.qty_ingredients qi"
			+ " JOIN qi.ingredient i"
			+ " WHERE i.name LIKE %:ingrSearch%"
			+ " ORDER BY r.title ASC")
	Iterable<Recipe> findByIngredient(@Param("ingrSearch") String ingrSearch);*/
	
	@Query("Select r from Recipe r JOIN r.qty_ingredients i WHERE :ingrSearch in (KEY(i)) ")
	Iterable<Recipe> findByIngredient(@Param("ingrSearch") Ingredient ingrSearch);
	
	
	/*@Query(value="SELECT * FROM Recipe r"
			+ " JOIN ingredient_recipe ir ON r.recipe_id=ir.recipe_id"
			+ " JOIN ingredients i ON i.ingredient_id=ir.ingredient_id"
			+ " WHERE i.ingredient_name LIKE '%:ingrSearch%'"
			+ " ORDER BY title ASC", nativeQuery = true)
	Iterable<Recipe> findByIngredient(@Param("ingrSearch") String ingrSearch);*/

    
}
