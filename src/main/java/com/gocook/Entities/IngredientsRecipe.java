package com.GoCook.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ingredients_recipe")
public class IngredientsRecipe {
	
	private int recipeId = 0;
	private int ingredientsId = 0;
	private int quantityId = 0;
	
	public IngredientsRecipe() {	}

	public IngredientsRecipe(int recipeId, int ingredientsId, int quantityId) {
		this.recipeId = recipeId;
		this.ingredientsId = ingredientsId;
		this.quantityId = quantityId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(int ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public int getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(int quantityId) {
		this.quantityId = quantityId;
	}
}
