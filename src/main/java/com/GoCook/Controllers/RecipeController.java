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
import org.springframework.web.bind.annotation.ResponseBody;

import com.GoCook.Boundaries.CategoryDAO;
import com.GoCook.Boundaries.RecipeDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.Recipe;

/**
 * 
 * Controls the endpoints for the Recipes
 * @author 300300914
 *
 */
@Controller
public class RecipeController {
	
	@Autowired
	RecipeDAO rDAO;
	
	@Autowired
	CategoryDAO cDAO;
	
	/**
	 * Maps the /recipes (list of all recipes)
	 * @param model Sends the recipe object to the view to fill the html form
	 * @return the view of Recipes (list)
	 */
	
	@GetMapping("/recipes")
	public String ShowAll(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "recipes/recipes";
	}
	
	/**
	 * Makes recipes list available in the view
	 * @return List of recipes
	 */
	@ModelAttribute("recipes")
	public Iterable<Recipe> getAll() {
		return rDAO.getAllRecipes();
	}
	
	/**
	 * Make available the view to submit a new recipe
	 * @param model 
	 * @return The view for submit a recipe
	 */
	@GetMapping("/submit-recipe")
	public String SubmitRecipe(Model model) {
		model.addAttribute("categories", cDAO.getCategories());
		model.addAttribute("category", new Category());
		return "recipes/submit-recipe";
	}
	
	/**
	 * Make available the view to edit an existing recipe
	 * @param model 
	 * @return The view for edit a recipe
	 */
	@GetMapping("/recipe/{id}/edit")
	public String SubmitRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", rDAO.findById(Integer.parseInt(id)).get());
		model.addAttribute("categories", cDAO.getCategories());
		model.addAttribute("category", new Category());
		return "recipes/submit-recipe";
	}
	
	/**
	 * Creates a new Recipe
	 * @param recipe The new recipe
	 * @return The view /recipe
	 */
	@PostMapping("/submit-recipe")
	public String createRecipe(@ModelAttribute Recipe recipe) {
		rDAO.save(recipe);
		return "redirect:/recipes";
	}
	
	/**
	 * Update recipe
	 * @param recipe The recipe entity with an existing id
	 * @return The view/recipe
	 */
	@PutMapping("/recipes")
	public String updateRecipe(@ModelAttribute Recipe recipe) {
		Recipe recipe_db = rDAO.findById(recipe.getId()).get();
		recipe_db.setTitle(recipe.getTitle());
		recipe_db.setImage(recipe.getImage());
		recipe_db.setInstructions(recipe.getInstructions());
		recipe_db.setPrepTime(recipe.getPrepTime());
		recipe_db.setCookTime(recipe.getCookTime());
		recipe_db.setServingQty(recipe.getServingQty());
		recipe_db.setCategories(recipe.getCategories());
		recipe_db.setQty_ingredients(recipe.getQty_ingredients());
		
		rDAO.save(recipe_db);
		return "redirect:/recipes";
	}

	/**
	 * Delete (hide) recipe
	 * @param recipe The recipe entity
	 * @return The view /recipe
	 */
	@DeleteMapping("/recipes")
	public String deleteRecipe(@ModelAttribute Recipe recipe) {
		Recipe recipe_db = rDAO.findById(recipe.getId()).get();
		recipe_db.setActive(false);
		rDAO.save(recipe_db);
		return "redirect:/recipes";
	}
	

	/**
	 * 
	 * @param id The id of the recipe
	 * @param model	The model to be sent to the view
	 * @return the view for a specific recipe
	 */
	@GetMapping("/recipe/{id}/detail")
	public String getRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", rDAO.findById(Integer.parseInt(id)).get());
		return "recipes/recipedetails";
	}
	
	
	/**
	 * Return a recipe object from an id
	 * @param id The id of the recipe
	 * @return the JSON object of a recipe
	 */
	@GetMapping("/recipes/{id}")
	@ResponseBody
	public Recipe getObject(@PathVariable String id) {
		try {
			return rDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Recipe();
		}
	}

}
