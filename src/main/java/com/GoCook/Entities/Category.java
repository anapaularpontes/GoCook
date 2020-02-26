package com.GoCook.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


/**
 * Represents the Category entity
 * @author 300300914
 *
 */
@Entity
@Table(name="categories")
public class Category {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categorie_id")
	private int id = 0;
	private String name = "";
	private boolean active = true;
	
	public Category() { }
	
	public Category(String name) {
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
		return "Categorie [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
