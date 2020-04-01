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

import com.GoCook.Boundaries.FoodGroupDAO;
import com.GoCook.Entities.FoodGroup;	
	
@Controller
public class FoodGroupController {
	
	@Autowired
	FoodGroupDAO fgDAO;
	
	
	
	/**
	 * Maps the /ingredients (list of all food Groups)
	 * @param model Sends the view to fill the html form
	 * @return the view 
	 */
	@GetMapping("/foodgroups")
	public String showAll(Model model) {
		model.addAttribute("foodgroup", new FoodGroup());
		return "foodgroups/foodgroups";
	}
	
	/**
	 * Makes food group list available in the view
	 * @return List of food groups
	 */
	@ModelAttribute("foodgroups")
	public Iterable<FoodGroup> getAll() {
		return fgDAO.getAllFoodGroups();
	}
	
	/**
	 * Update foodGroups
	 * @param category The foodGroups entity with an existing id
	 * @return The view/foodGroups
	 */
	@PutMapping("/foodgroups")
	public String updateFoodGroups(@ModelAttribute FoodGroup foodgroups) {
		FoodGroup foodGroup_db = fgDAO.findById(foodgroups.getId()).get();
		foodGroup_db.setFoodGroup(foodgroups.getFoodGroup());
		fgDAO.save(foodGroup_db);
		return "redirect:/foodgroups";
	}
	
	/**
	 * Creates a new foodgroup
	 * @param group The new foodgroup
	 * @return The view /foodgroups
	 */
	@PostMapping("/foodgroups")
	public String createFoodGroup(@ModelAttribute FoodGroup foodgroup) {
		fgDAO.save(foodgroup);
		return "redirect:/foodgroups";
	}
	
	

	/**
	 * Delete (hide) category
	 * @param foodGroups The category entity
	 * @return The view /foodGroups
	 */
	@DeleteMapping("/foodgroups")
	public String deleteFoodGroup(@ModelAttribute FoodGroup foodgroups) {
		FoodGroup foodGroup_db = fgDAO.findById(foodgroups.getId()).get();
		foodGroup_db.setActive(false);
		fgDAO.save(foodGroup_db);
		return "redirect:/foodgroups";
	}

	/**
	 * Return a foodGroups object from an id
	 * @param id The id of the category
	 * @return the JSON object of a category
	 */
	@GetMapping("/foodgroups/{id}")
	@ResponseBody
	public FoodGroup seekPath(@PathVariable String id) {
		try {
			return fgDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new FoodGroup();
		}
	}
}