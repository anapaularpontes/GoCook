package com.GoCook.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categories_recipe")
public class CategoriesRecipe {
	
	private int recipeId = 0;
	private int categoriesId = 0;
	
	public CategoriesRecipe() { }
	
	public CategoriesRecipe(int recipeId, int categoriesId) {
		this.recipeId = recipeId;
		this.categoriesId = categoriesId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(int categoriesId) {
		this.categoriesId = categoriesId;
	}
	
	
	
	
}
