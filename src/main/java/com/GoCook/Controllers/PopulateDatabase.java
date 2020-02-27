package com.GoCook.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GoCook.Boundaries.CategoryDAO;
import com.GoCook.Boundaries.IngredientDAO;
import com.GoCook.Boundaries.QuantityDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.Ingredient;
import com.GoCook.Entities.Quantity;

@Controller
public class PopulateDatabase {
	
	@Autowired
	CategoryDAO cDAO;
	
	@Autowired
	IngredientDAO iDAO;
	
	@Autowired
	QuantityDAO qDAO;
	
	
	@GetMapping("/start")
	public String start(RedirectAttributes redirAttrs) {
		
		
		/***************** Categories ***************/
		ArrayList<Category> categoriesList = new ArrayList<>();
		categoriesList.add(new Category("Breakfast")); 	//1
		categoriesList.add(new Category("Lunch"));     	//2
		categoriesList.add(new Category("Dinner")); 	//3
		categoriesList.add(new Category("Dessert")); 	//4
		categoriesList.add(new Category("Healthy")); 	//5
		categoriesList.add(new Category("Meat")); 		//6
		categoriesList.add(new Category("Poultry"));   	//7
		categoriesList.add(new Category("Veggie"));		//8
		
		for(Category c : categoriesList) {
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
		

		
		
		redirAttrs.addFlashAttribute("message", "The database has been populated");
		return "redirect:/";
	}
	
	
	
	

}
