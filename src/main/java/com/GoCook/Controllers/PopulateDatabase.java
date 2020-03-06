package com.GoCook.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GoCook.Boundaries.CategoryDAO;
import com.GoCook.Boundaries.IngredientDAO;
import com.GoCook.Boundaries.QuantityDAO;
import com.GoCook.Boundaries.RecipeDAO;
import com.GoCook.Boundaries.UserDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.Ingredient;
import com.GoCook.Entities.Quantity;
import com.GoCook.Entities.Recipe;
import com.GoCook.Entities.User;

@Controller
public class PopulateDatabase {
	
	@Autowired
	CategoryDAO cDAO;
	
	@Autowired
	IngredientDAO iDAO;
	
	@Autowired
	QuantityDAO qDAO;
	
	@Autowired
	RecipeDAO rDAO;
	
	@Autowired
	UserDAO uDAO;
	
	
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
		// ingredients for Tex-Mex Polenta Bowls
		ingredientsList.add(new Ingredient("dry polenta"));
		ingredientsList.add(new Ingredient("ground cumin"));
		ingredientsList.add(new Ingredient("Sea salt"));
		ingredientsList.add(new Ingredient("can black beans"));
		ingredientsList.add(new Ingredient("purchased pico de gallo"));
		ingredientsList.add(new Ingredient(" small avocado, halved, seeded, peeled, and sliced"));
		ingredientsList.add(new Ingredient("finely chopped fresh cilantro"));
		ingredientsList.add(new Ingredient("fresh jalapeño pepper"));
		
		
		
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
		
		/***************** User ***************/
		ArrayList<User> usersList = new ArrayList<>();
		//usersList.add(new User("firstName", "lastName", "username", "password", "role"));
		usersList.add(new User("Ana Paula", "Pontes", "ana.pontes@gocook.ca", "password123", "admin"));
		usersList.add(new User("Herbert", "Dias", "herbert.dias@gocook.ca", "password123", "admin"));
		usersList.add(new User("Miriam", "Nakiyingi", "miriam.nakiyingi@gmail.com", "password123", "user"));
		usersList.add(new User("Rafael", "Pires", "rafael.pires@gmail.com", "password123", "user"));
		
		for(User u : usersList) {
			uDAO.save(u);
		}
		
		/***************** Recipe ***************/
		
		ArrayList<Recipe> recipesList = new ArrayList<>();
		//Test
		/*recipesList.add(new Recipe("Title",
				new ArrayList<>(Arrays.asList("Instruction 1", "Instruction 2")),
				"Time", "# of servings",
				new ArrayList<>(Arrays.asList(cDAO.findById(id of category).get(), cDAO.findById(id of category).get()), //categories
				Stream.of(new Object[][] { 
				    { qDAO.findById(id of quantity).get(), iDAO.findById(id of ingredient).get() }, // quantities and ingredients
				}).collect(Collectors.toMap(data -> (Quantity) data[0], data -> (Ingredient) data[1])), 
				uDAO.findById(id of user).get() )); */

		/*recipesList.add(new Recipe("Title",
				new ArrayList<>(Arrays.asList("Instruction 1", "Instruction 2")),
				/*1) In a medium saucepan bring 4 cups water to boiling. Gradually whisk in polenta and cumin."
						+ "Reduce heat to low; cook about 20 minutes or until mixture is thick and creamy, stirring occasionally. Remove pan from heat. Season with salt.",
						"2)In a small saucepan warm beans over low heat. Divide polenta among four individual bowls. Top with beans, pico de gallo, avocado, cilantro, and jalapeño (if using).		
				"30 Min", "4",
				new ArrayList<>(Arrays.asList(cDAO.findById(1).get(), cDAO.findById(5).get())), //categories
				Stream.of(new Object[][] { 
				    { qDAO.findById(3).get(), iDAO.findById(3).get() }, 
				    { qDAO.findById(4).get(), iDAO.findById(4).get() }, 
				}).collect(Collectors.toMap(data -> (Quantity) data[0], data -> (Ingredient) data[1])),
				uDAO.findById(1).get() ));*/
		
		for(Recipe r : recipesList) {
			rDAO.save(r);
		}
		
		
		redirAttrs.addFlashAttribute("message", "The database has been populated");
		return "redirect:/";
	}
	
	
	
	

}
