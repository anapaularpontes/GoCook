package com.GoCook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.GoCook.Boundaries.FoodGroupDAO;
import com.GoCook.Boundaries.PopulateDatabase;

@Controller
public class IndexController {
	
	@Autowired
	FoodGroupDAO fgDAO;
	
	@Autowired
	PopulateDatabase populateDatabase;
	
	@GetMapping("/")
	public String home(  ) {
		if(!fgDAO.findById(1).isPresent()) {
			populateDatabase.start();
		}
		return "index/index";
		
	}

}
