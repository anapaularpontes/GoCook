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
	private String prepTime = "";
	private String totalTime = "";
	private String servingQty = "";
	@ManyToMany
	@JoinTable(name="categories_recipe", joinColumns = @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name="categorie_id"))
	private List<Categories> categories;
	@OneToMany
	@JoinTable(name="ingredient_recipe", joinColumns = @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name="ingredient_id"))
	@MapKeyJoinColumn(name = "quantity_id")
	private Map<Quantity, Ingredients> _eventToWorkAndInstrumentationMappers = new HashMap<>();
	
	public Recipe() {	}
	
	public Recipe(int id, String title, String instructions, String prepTime, String totalTime, String servingQty) {
		this.id = id;
		this.title = title;
		this.instructions = instructions;
		this.prepTime = prepTime;
		this.totalTime = totalTime;
		this.servingQty = servingQty;
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

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getServingQty() {
		return servingQty;
	}

	public void setServingQty(String servingQty) {
		this.servingQty = servingQty;
	}
	
}
