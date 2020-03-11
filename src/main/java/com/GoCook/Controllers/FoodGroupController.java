package com.GoCook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.GoCook.Boundaries.FoodGroupDAO;
import com.GoCook.Entities.FoodGroup;

@Controller
public class FoodGroupController {
	
	@Autowired
	FoodGroupDAO fgDAO;
	
	/**
	 * Makes food group list available in the view
	 * @return List of food groups
	 */
	@ModelAttribute("foodGroups")
	public Iterable<FoodGroup> getAll() {
		return fgDAO.getAllFoodGroups();
	}
}
