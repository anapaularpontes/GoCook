package com.GoCook.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredient {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingredient_id")
	private int id = 0;
	private String name = "";
	@OneToOne
	@JoinColumn(name ="foodGroup_id")
	private FoodGroup group;
	private boolean active = true;
	
	public Ingredient() {	}
	
	public Ingredient(String name, FoodGroup group) {
		this.name = name;
		this.group = group;
		this.active = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodGroup getGroup() {
		return group;
	}

	public void setGroup(FoodGroup group) {
		this.group = group;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + "]";
	}
	
	
		
}