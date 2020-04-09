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
import com.GoCook.Boundaries.FoodGroupDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.FoodGroup;	
	
@Controller
public class FoodGroupController {
	
	@Autowired
	FoodGroupDAO fgDAO;
	
	@Autowired
	CategoryDAO cDAO;
	
	/**
	 * Maps the /ingredients (list of all food Groups)
	 * @param model Sends the view to fill the html form
	 * @return the view 
	 */
	@GetMapping("/foodgroups")
	public String showAll(Model model) {
		model.addAttribute("categories", cDAO.getCategories());
		model.addAttribute("category", new Category());
		
		model.addAttribute("foodgroup", new FoodGroup());
		return "foodgroups/foodgroups";
	}
	
	/**
	 * Makes foodgroup list available in the view
	 * @return List of foodgroups
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
	public String updateFoodGroups(@ModelAttribute FoodGroup fg) {
		FoodGroup foodGroup_db = fgDAO.findById(fg.getId()).get();
		foodGroup_db.setName(fg.getName());
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
	 * @param foodGroups The foodgroup entity
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
	 * @param id The id of the foodgroup
	 * @return the JSON object of a foodgroup
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
