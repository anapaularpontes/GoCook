package com.GoCook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.GoCook.Boundaries.CategoryDAO;
import com.GoCook.Boundaries.RecipeDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.Recipe;

@Controller
public class IndexController {
	
	@Autowired
	CategoryDAO cDAO;
	
	@Autowired
	RecipeDAO rDAO;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("categories", cDAO.getCategories());
		model.addAttribute("category", new Category());
		
		model.addAttribute("recipes", rDAO.getRandomRecipes());
		model.addAttribute("recipe", new Recipe());
		
		return "index/index";	
	}
}
