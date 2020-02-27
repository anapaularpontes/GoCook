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
import com.GoCook.Entities.Category;


/**
 * Controls the endpoints for the Categories
 * @author 300300914
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO cDAO;
	
	/**
	 * Maps the /categories (list of all categories)
	 * @param model Sends the category object to the view to fill the html form
	 * @return the view of Categories (list)
	 */
	
	@GetMapping("/categories")
	public String ShowAll(Model model) {
		model.addAttribute("category", new Category());
		return "categories/categories";
	}
	
	/**
	 * Makes categories list available in the view
	 * @return List of categories
	 */
	@ModelAttribute("categories")
	public Iterable<Category> getAll() {
		return cDAO.getCategories();
	}
	
	/**
	 * Creates a new Category
	 * @param category The new category
	 * @return The view /category
	 */
	@PostMapping("/categories")
	public String createCategory(@ModelAttribute Category category) {
		cDAO.save(category);
		return "redirect:/categories";
	}
	
	/**
	 * Update category
	 * @param category The category entity with an existing id
	 * @return The view/category
	 */
	@PutMapping("/categories")
	public String updateCategory(@ModelAttribute Category category) {
		Category category_db = cDAO.findById(category.getId()).get();
		category_db.setName(category.getName());
		cDAO.save(category_db);
		return "redirect:/categories";
	}

	/**
	 * Delete (hide) category
	 * @param category The category entity
	 * @return The view /category
	 */
	@DeleteMapping("/categories")
	public String deleteCategory(@ModelAttribute Category category) {
		Category category_db = cDAO.findById(category.getId()).get();
		category_db.setActive(false);
		cDAO.save(category_db);
		return "redirect:/categories";
	}

	/**
	 * Return a category object from an id
	 * @param id The id of the category
	 * @return the JSON object of a category
	 */
	@GetMapping("/categories/{id}")
	@ResponseBody
	public Category seekPath(@PathVariable String id) {
		try {
			return cDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Category();
		}
	}

}
