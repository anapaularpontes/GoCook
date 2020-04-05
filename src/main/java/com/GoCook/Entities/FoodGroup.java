package com.GoCook.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="food_group")
public class FoodGroup {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="foodGroup_id")
	private int id = 0;
	
	@Column(name="foodGroup")
	private String name = "";
	private boolean active = true;
	
	public FoodGroup() {	}
	
	public FoodGroup(String name) {
		this.name = name;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "foodGroup[id=" + id + ", name=" + name + "]";
	}
	
}

