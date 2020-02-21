package com.GoCook.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.GoCook.Entities.Categorie;

@Component
public interface CategorieDAO extends CrudRepository<Categorie, Integer> {
	
	@Query("SELECT c FROM Categorie c")
	Iterable<Categorie> getAllCategories();
}
