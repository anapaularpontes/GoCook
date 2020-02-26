package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Category;


/**
 * Extends CrudRepository for Category Entity
 * @author 300300914
 *
 */
@Component
public interface CategoryDAO extends CrudRepository<Category, Integer> {
	
	@Query("SELECT c FROM Category c WHERE c.active = true")
	Iterable<Category> getCategories();
}
