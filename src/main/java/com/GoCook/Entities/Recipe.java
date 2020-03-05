package com.GoCook.Entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recipe_id")
	private int id = 0;
	private String title = "";
	private String instructions = "";
	private String time = "";
	private String servingQty = "";
	@ManyToMany
	@JoinTable(name="categorie_recipe", joinColumns = @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name="categorie_id"))
	private List<Category> categories;
	@OneToMany
	@JoinTable(name="ingredient_recipe", joinColumns = @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name="ingredient_id"))
	@MapKeyJoinColumn(name = "quantity_id")
	private Map<Quantity, Ingredient> qty_ingredients = new HashMap<>();
	@OneToOne
	private User user;
	
	public Recipe() {	}

	public Recipe(String title, String instructions, String time, String servingQty, List<Category> categories,
			Map<Quantity, Ingredient> qty_ingredients, User user) {
		super();
		this.title = title;
		this.instructions = instructions;
		this.time = time;
		this.servingQty = servingQty;
		this.categories = categories;
		this.qty_ingredients = qty_ingredients;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getServingQty() {
		return servingQty;
	}

	public void setServingQty(String servingQty) {
		this.servingQty = servingQty;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Map<Quantity, Ingredient> getQty_ingredients() {
		return qty_ingredients;
	}

	public void setQty_ingredients(Map<Quantity, Ingredient> qty_ingredients) {
		this.qty_ingredients = qty_ingredients;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", instructions=" + instructions + ", time=" + time
				+ ", servingQty=" + servingQty + ", categories=" + categories + ", qty_ingredients=" + qty_ingredients
				+ ", user=" + user + "]";
	}
	
	
	
}
