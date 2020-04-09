package com.GoCook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.GoCook.Boundaries.FoodGroupDAO;
import com.GoCook.Boundaries.IngredientDAO;
import com.GoCook.Boundaries.RecipeDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.FoodGroup;
import com.GoCook.Entities.Ingredient;
import com.GoCook.Entities.Recipe;


/**
 * Controls the endpoints for Ingredients
 * @author 300300914
 *
 */
@Controller
public class IngredientController {
	
	@Autowired
	IngredientDAO iDAO;
	
	@Autowired
	FoodGroupDAO fgDAO;
	
	@Autowired
	RecipeDAO rDAO;
	
	/**
	 * Maps the /ingredients (list of all ingredients)
	 * @param model Sends the ingredient object to the view to fill the html form
	 * @return the view of Ingredients (list)
	 */
	@GetMapping("/ingredients")
	public String ShowAll(Model model) {
		model.addAttribute("ingredient", new Ingredient());
		return "ingredients/ingredients";
	}
	
	/**
	 * Makes ingredients list available in the view
	 * @return List of ingredients
	 */
	@ModelAttribute("ingredients")
	public Iterable<Ingredient> getAll() {
		return iDAO.getAllIngredients();
	}
	
	/**
	 * Creates a new ingredient
	 * @param ingredient The new ingredient
	 * @return The view /ingredient
	 */
	@PostMapping("/ingredients")
	public String createIngredient(@ModelAttribute Ingredient ingredient) {
		iDAO.save(ingredient);
		return "redirect:/ingredients";
	}
	
	/**
	 * Update ingredient
	 * @param ingredient The ingredient entity with an existing id
	 * @return The view/ingredient
	 */
	@PutMapping("/ingredients")
	public String updateIngredient(@ModelAttribute Ingredient ingredient) {
		Ingredient ingredient_db = iDAO.findById(ingredient.getId()).get();
		ingredient_db.setName(ingredient.getName());
		iDAO.save(ingredient_db);
		return "redirect:/ingredients";
	}

	/**
	 * Delete (hide) ingredient
	 * @param ingredient The ingredient entity
	 * @return The view /ingredient
	 */
	@DeleteMapping("/ingredients")
	public String deleteIngredient(@ModelAttribute Ingredient ingredient) {
		Ingredient ingredient_db = iDAO.findById(ingredient.getId()).get();
		ingredient_db.setActive(false);
		iDAO.save(ingredient_db);
		return "redirect:/ingredients";
	}
	

	/**
	 * Return a ingredient object from an id
	 * @param id The id of the ingredient
	 * @return the JSON object of a ingredient
	 */
	@GetMapping("/ingredients/{id}")
	@ResponseBody
	public Ingredient seekPath(@PathVariable String id) {
		try {
			return iDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Ingredient();
		}
	}
	
	/**
	 * Makes food group list available in the view
	 * @return List of food groups
	 */
	@ModelAttribute("foodGroups")
	public Iterable<FoodGroup> getGroups() {
		return fgDAO.getAllFoodGroups();
	}

}
