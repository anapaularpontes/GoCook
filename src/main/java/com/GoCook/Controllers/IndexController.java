package com.GoCook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.GoCook.Boundaries.PopulateDatabase;
import com.GoCook.Boundaries.RecipeDAO;
import com.GoCook.Entities.Recipe;

@Controller
public class IndexController {
	
	@Autowired
	RecipeDAO rDAO;
	
	@Autowired	
	PopulateDatabase populateDatabase;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("recipes", rDAO.getRandomRecipes());
		model.addAttribute("recipe", new Recipe());
		
		return "index/index";	
	}
}
