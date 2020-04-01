package com.GoCook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.GoCook.Boundaries.RecipeDAO;
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
