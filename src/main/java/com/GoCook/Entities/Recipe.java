package com.GoCook.Entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name="recipe")
public class Recipe {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recipe_id")
	private int id = 0;
	private String title = "";
	@Lob
	private String image;
	@ElementCollection
	@CollectionTable(name = "instructions", joinColumns=@JoinColumn(name="recipe_id"))
	private List<String> instructions;
	private String prepTime = "";
	private String cookTime = "";
	private String servingQty = "";
	@ManyToMany
	@JoinTable(name="category_recipe", joinColumns = @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name="category_id"))
	private List<Category> categories;
	@ManyToMany
	@JoinTable(name="ingredient_recipe", joinColumns = @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name="ingredient_id"))
	@MapKeyJoinColumn(name = "quantity_id")
	//private ArrayList<Quantity, Ingredient> qty_ingredients;
	private Map<Ingredient,Quantity> qty_ingredients;
	@OneToOne
	private User user;
	private boolean active = true;
	
	public Recipe() {	}

	public Recipe(String title, String image, List<String> instructions, String prepTime, String cookTime, String servingQty, List<Category> categories,
			Map<Ingredient,Quantity> qty_ingredients, User user) {
		super();
		this.title = title;
		this.image = setImage(image);
		this.instructions = instructions;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.servingQty = servingQty;
		this.categories = categories;
		this.qty_ingredients = qty_ingredients;
		this.user = user;
		this.active = true;
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
	
	public String getImage() {
		return image;
	}

	public String setImage(String image) {
		
		String encodedfile = null;
		if(image.contains("data:image/jpeg;base64")) {
			encodedfile = image;
		} else {
			File file =  new File(image);
	        try {
	            FileInputStream fileInputStreamReader = new FileInputStream(file);
	            byte[] bytes = new byte[(int)file.length()];
	            fileInputStreamReader.read(bytes);
	            encodedfile =  new String(Base64.encodeBase64(bytes), "UTF-8");
	            fileInputStreamReader.close();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}
        return encodedfile;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}
	
	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
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

	public Map<Ingredient,Quantity> getQty_ingredients() {
		return qty_ingredients;
	}

	public void setQty_ingredients(Map<Ingredient,Quantity> qty_ingredients) {
		this.qty_ingredients = qty_ingredients;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", instructions=" + instructions
				+ ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", servingQty=" + servingQty + ", categories="
				+ categories + ", qty_ingredients=" + qty_ingredients + ", user=" + user + "]";
	}
	
}
