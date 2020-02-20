package com.GoCook.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.GoCook.Boundaries.CategorieDAO;
import com.GoCook.Boundaries.IngredientDAO;
import com.GoCook.Boundaries.QuantityDAO;
import com.GoCook.Entities.Categorie;
import com.GoCook.Entities.Ingredient;
import com.GoCook.Entities.Quantity;

@Controller
public class PopulateDatabase {
	
	@Autowired
	CategorieDAO cDAO;
	
	@Autowired
	IngredientDAO iDAO;
	
	@Autowired
	QuantityDAO qDAO;
	
	
	@GetMapping("/start")
	@ResponseBody
	public String start() {
		
		
		/***************** Categories ***************/
		ArrayList<Categorie> categoriesList = new ArrayList<>();
		categoriesList.add(new Categorie("Breakfast")); //1
		categoriesList.add(new Categorie("Lunch"));     //2
		categoriesList.add(new Categorie("Dinner")); 	//3
		categoriesList.add(new Categorie("Dessert")); 	//4
		categoriesList.add(new Categorie("Healthy")); 	//5
		categoriesList.add(new Categorie("Meat")); 		//6
		categoriesList.add(new Categorie("Poultry"));   //7
		categoriesList.add(new Categorie("Veggie"));	//8
		
		for(Categorie c : categoriesList) {
			cDAO.save(c);
		}
		
		
		/***************** Ingredients ***************/
		ArrayList<Ingredient> ingredientsList = new ArrayList<>();
		ingredientsList.add(new Ingredient("all-purpose flour"));
		ingredientsList.add(new Ingredient("artificial sweetener"));
		ingredientsList.add(new Ingredient("baking powder"));
		ingredientsList.add(new Ingredient("baking soda"));
		ingredientsList.add(new Ingredient("banana, broken into chunks"));
		ingredientsList.add(new Ingredient("banana, mashed"));
		ingredientsList.add(new Ingredient("blueberries"));
		ingredientsList.add(new Ingredient("butter"));
		ingredientsList.add(new Ingredient(""));
		
		for(Ingredient i : ingredientsList) {
			iDAO.save(i);
		}
		
		
		/***************** Quantity ***************/
		ArrayList<Quantity> quantityList = new ArrayList<>();
		quantityList.add(new Quantity("1/4 cup"));		
		quantityList.add(new Quantity("1/3 cup"));		
		quantityList.add(new Quantity("1/2 cup"));		
		quantityList.add(new Quantity("3/4 cup"));		
		quantityList.add(new Quantity("1 cup"));		
		quantityList.add(new Quantity("1 1/4 cup"));	
		quantityList.add(new Quantity("1 1/3 cup"));	
		quantityList.add(new Quantity("1 1/2 cup"));	
		quantityList.add(new Quantity("1 3/4 cup"));	
		quantityList.add(new Quantity("2 cups"));		
		quantityList.add(new Quantity("2 1/4 cups"));	
		quantityList.add(new Quantity("2 1/2 cups"));	
		quantityList.add(new Quantity("1/4 teaspoon"));
		quantityList.add(new Quantity("1/2 teaspoon"));
		quantityList.add(new Quantity("1 teaspoon"));
		quantityList.add(new Quantity("1 1/2 teaspoon"));
		quantityList.add(new Quantity("2 teaspoons"));
		quantityList.add(new Quantity("1/4 tablespoon"));
		quantityList.add(new Quantity("1/2 tablespoon"));
		quantityList.add(new Quantity("1 tablespoon"));
		quantityList.add(new Quantity("1 1/2 tablespoon"));
		quantityList.add(new Quantity("2 tablespoon"));
		quantityList.add(new Quantity("1"));
		quantityList.add(new Quantity("4"));
		quantityList.add(new Quantity("14"));
		quantityList.add(new Quantity("6 slices"));
		quantityList.add(new Quantity("10 ounces"));
		quantityList.add(new Quantity("16 ounces"));
		
		for(Quantity q : quantityList) {
			qDAO.save(q);
		}
		
		
		/***************** Recipe ***************/
		
		
		
		/***************** User ***************/
		
		ArrayList<Categorie> categorie = (ArrayList<Categorie>) cDAO.getAllCategories();
		String testPrint = "";
		for(Categorie c : categorie) {
			testPrint += c.toString();
		}
		
		return testPrint;
	}
	
	
	
	

}
