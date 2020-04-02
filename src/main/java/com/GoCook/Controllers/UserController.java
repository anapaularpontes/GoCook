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

import com.GoCook.Boundaries.UserDAO;
import com.GoCook.Entities.User;

		
		/**
		 * Controls the endpoints for the Users
		 * @author 300286075
		 *
		 */
		
@Controller
public class UserController {
	
	@Autowired
	UserDAO uDAO;
	
		
	/**
	 * Maps the /Users (list of all Users)
	 * @param model Sends the users object to the view to fill the html form
	 * @return the view of Categories (list)
	 */
	@GetMapping("/users")
	public String ShowAll(Model model) {
		model.addAttribute("user", new User());
		return "users/users";
	}
	
	/**
	 * Makes categories list available in the view
	 * @return List of users
	 * 
	 */
	
	@ModelAttribute("users")
	public Iterable<User> getAll() {
		return uDAO.getUsers();
	}
	
	/**
	 * Creates a new User
	 * @param category The new User
	 * @return The view /user
	 */
	
	
	@PostMapping("/users")
	public String createUser(@ModelAttribute User users) {
		uDAO.save(users);
		return "redirect:/users";
	}
	
	/**
	 * Update user
	 * @param users The users entity with an existing id
	 * @return The view/users
	 */
	
	@PutMapping("/users")
	public String updateUser(@ModelAttribute User users) {
		User users_db = uDAO.findById(users.getId()).get();
		users_db.setFirstName(users.getFirstName());
		users_db.setLastName(users.getLastName());
		users_db.setRole(users.getRole());
		users_db.setEmailAddress(users.getEmailAddress());
		uDAO.save(users_db);
		return "redirect:/users";
	}
	
	
	/**
	 * Delete (hide) users
	 * @param user The User entity
	 * @return The view /users
	 */
	
	@DeleteMapping("/users")
	public String deleteUser(@ModelAttribute User users) {
		User users_db = uDAO.findById(users.getId()).get();
		users_db.setActive(false);
		uDAO.save(users_db);
		return "redirect:/users";
	}
	
	/**
	 * Return a user object from an id
	 * @param id The id of the User
	 * @return the JSON object of a users
	 */
	
	
	@GetMapping("/users/{id}")
	@ResponseBody
	public User seekPath(@PathVariable String id) {
		try {
			return uDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new User();
		}
	}
	
}

		








