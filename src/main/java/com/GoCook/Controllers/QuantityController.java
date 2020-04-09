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
import com.GoCook.Boundaries.QuantityDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.Quantity;

/**
* Controls the endpoints for the Quantities
* @author 300300914
*
*/
@Controller
public class QuantityController {
	
	@Autowired
	QuantityDAO qDAO;
	
	@Autowired
	CategoryDAO cDAO;
	
	/**
	 * Maps the /quantities (list of all quantities)
	 * @param model Sends the quantity object to the view to fill the html form
	 * @return the view of Quantities (list)
	 */
	
	@GetMapping("/quantities")
	public String ShowAll(Model model) {
		model.addAttribute("categories", cDAO.getCategories());
		model.addAttribute("category", new Category());
		
		model.addAttribute("quantity", new Quantity());
		return "quantities/quantities";
	}
	
	/**
	 * Makes quantities list available in the view
	 * @return List of quantities
	 */
	@ModelAttribute("quantities")
	public Iterable<Quantity> getAll() {
		return qDAO.getQuantities();
	}
	
	/**
	 * Creates a new Quantity
	 * @param quantity The new quantity
	 * @return The view /quantity
	 */
	@PostMapping("/quantities")
	public String createQuantity(@ModelAttribute Quantity quantity) {
		qDAO.save(quantity);
		return "redirect:/quantities";
	}
	
	/**
	 * Update quantity
	 * @param quantity The quantity entity with an existing id
	 * @return The view/quantity
	 */
	@PutMapping("/quantities")
	public String updateQuantity(@ModelAttribute Quantity quantity) {
		Quantity quantity_db = qDAO.findById(quantity.getId()).get();
		quantity_db.setQuantity(quantity.getQuantity());
		qDAO.save(quantity_db);
		return "redirect:/quantities";
	}

	/**
	 * Delete (hide) quantity
	 * @param quantity The quantity entity
	 * @return The view /quantity
	 */
	@DeleteMapping("/quantities")
	public String deleteQuantity(@ModelAttribute Quantity quantity) {
		Quantity quantity_db = qDAO.findById(quantity.getId()).get();
		quantity_db.setActive(false);
		qDAO.save(quantity_db);
		return "redirect:/quantities";
	}

	/**
	 * Return a quantity object from an id
	 * @param id The id of the quantity
	 * @return the JSON object of a quantity
	 */
	@GetMapping("/quantities/{id}")
	@ResponseBody
	public Quantity seekPath(@PathVariable String id) {
		try {
			return qDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Quantity();
		}
	}

}
