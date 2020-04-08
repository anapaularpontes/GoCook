package com.GoCook.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.GoCook.Boundaries.UserDAO;
import com.GoCook.Entities.User;

@Controller
public class LoginController {
	
	@Autowired
	UserDAO uDAO;
	
	@ModelAttribute("user")
	public User userForm() {
		return new User();
	}

	/**
	 * Method to show the initial HTML form
	
	 */
	
	/*@GetMapping("/login")
	public String login(Model model) {
	    User user = (User) model.addAttribute("user");
	    if(user!= null) {
	    	return "login-success";
	    }
	    return "login";
	}*/
	
	@GetMapping("/login")
	public String login(HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    if(user != null) {
	    	return "login-success";
	    }
	    return "login/login";
	}
	
	@PostMapping("/login") 
	public String login(@ModelAttribute("user") User user){
		System.out.println("User before => " + user.getEmailAddress());
		Iterable<User> userList = uDAO.findByEmailAddress(user.getEmailAddress());
		user = userList.iterator().next();
		System.out.println("User after => " + user);
		if(user==null) {
			System.out.println("Login Fail");
		}

		if(user != null && user.getHashPassword().equals(uDAO.getUsers())) {
			
			System.out.println("Login Successful");
			return "index/index";
		}
		return "login/login";
	}
	
}
