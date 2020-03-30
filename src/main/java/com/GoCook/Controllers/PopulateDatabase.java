package com.GoCook.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GoCook.Boundaries.CategoryDAO;
import com.GoCook.Boundaries.FoodGroupDAO;
import com.GoCook.Boundaries.IngredientDAO;
import com.GoCook.Boundaries.QuantityDAO;
import com.GoCook.Boundaries.RecipeDAO;
import com.GoCook.Boundaries.UserDAO;
import com.GoCook.Entities.Category;
import com.GoCook.Entities.FoodGroup;
import com.GoCook.Entities.Ingredient;
import com.GoCook.Entities.Quantity;
import com.GoCook.Entities.Recipe;
import com.GoCook.Entities.User;

@Controller
public class PopulateDatabase {
	
	@Autowired
	CategoryDAO cDAO;
	
	@Autowired
	FoodGroupDAO fgDAO;
	
	@Autowired
	IngredientDAO iDAO;
	
	@Autowired
	QuantityDAO qDAO;
	
	@Autowired
	RecipeDAO rDAO;
	
	@Autowired
	UserDAO uDAO;
	
	
	@GetMapping("/start")
	public String start(RedirectAttributes redirAttrs) {
		
		
		/***************** Categories ***************/
		ArrayList<Category> categoriesList = new ArrayList<>();
		categoriesList.add(new Category("Breakfast")); 	//ID: 1
		categoriesList.add(new Category("Lunch"));     	//ID: 2
		categoriesList.add(new Category("Dinner")); 	//ID: 3
		categoriesList.add(new Category("Dessert")); 	//ID: 4
		categoriesList.add(new Category("Healthy")); 	//ID: 5
		categoriesList.add(new Category("Meat")); 		//ID: 6
		categoriesList.add(new Category("Poultry"));   	//ID: 7
		categoriesList.add(new Category("Veggie"));		//ID: 8
		categoriesList.add(new Category("Seafood"));	//ID: 9
		
		for(Category c : categoriesList) {
			cDAO.save(c);
		}
		
		/***************** Food Group ***************/
		ArrayList<FoodGroup> groupList = new ArrayList<>();
		groupList.add(new FoodGroup("Dairy"));				//ID: 1
		groupList.add(new FoodGroup("Vegetables"));			//ID: 2
		groupList.add(new FoodGroup("Fruits"));				//ID: 3
		groupList.add(new FoodGroup("Baking & Grains"));	//ID: 4
		groupList.add(new FoodGroup("Sweeteners"));			//ID: 5
		groupList.add(new FoodGroup("Spices"));				//ID: 6
		groupList.add(new FoodGroup("Meats"));				//ID: 7
		groupList.add(new FoodGroup("Fish"));				//ID: 8
		groupList.add(new FoodGroup("Seafood"));			//ID: 9
		groupList.add(new FoodGroup("Condiments"));			//ID: 10
		groupList.add(new FoodGroup("Oils"));				//ID: 11
		groupList.add(new FoodGroup("Seasonings"));			//ID: 12
		groupList.add(new FoodGroup("Sauces"));				//ID: 13
		groupList.add(new FoodGroup("Legumes"));			//ID: 14
		groupList.add(new FoodGroup("Alcohol"));			//ID: 15
		groupList.add(new FoodGroup("Soup"));				//ID: 16
		groupList.add(new FoodGroup("Nuts"));				//ID: 17
		groupList.add(new FoodGroup("Dairy Alternatives"));	//ID: 18
		groupList.add(new FoodGroup("Desserts & Snacks"));	//ID: 19
		groupList.add(new FoodGroup("Beverages"));			//ID: 20
		groupList.add(new FoodGroup("Pasta"));			    //ID: 21
		
		for(FoodGroup fg : groupList) {
			fgDAO.save(fg);
		}
		
		
		/***************** Ingredients ***************/
		ArrayList<Ingredient> ingredientsList = new ArrayList<>();
		ingredientsList.add(new Ingredient("all-purpose flour", fgDAO.findById(4).get()));					//ID: 1
		ingredientsList.add(new Ingredient("almond butter", fgDAO.findById(17).get()));						//ID: 2
		ingredientsList.add(new Ingredient("almond flour", fgDAO.findById(4).get()));						//ID: 3
		ingredientsList.add(new Ingredient("ancho chile powder", fgDAO.findById(12).get()));				//ID: 4
		ingredientsList.add(new Ingredient("apple cider vinegar", fgDAO.findById(10).get()));				//ID: 5
		ingredientsList.add(new Ingredient("arugula", fgDAO.findById(2).get()));							//ID: 6
		ingredientsList.add(new Ingredient("asparagus spears", fgDAO.findById(2).get()));					//ID: 7
		ingredientsList.add(new Ingredient("avocado", fgDAO.findById(3).get()));							//ID: 8
		ingredientsList.add(new Ingredient("avocado oil", fgDAO.findById(11).get()));						//ID: 9
		ingredientsList.add(new Ingredient("baking powder", fgDAO.findById(4).get()));						//ID: 10
		ingredientsList.add(new Ingredient("baking soda", fgDAO.findById(4).get()));						//ID: 11
		ingredientsList.add(new Ingredient("banana", fgDAO.findById(3).get()));								//ID: 12
		ingredientsList.add(new Ingredient("banana, broken chunks", fgDAO.findById(3).get()));				//ID: 13
		ingredientsList.add(new Ingredient("barbecue sauce", fgDAO.findById(13).get()));					//ID: 14
		ingredientsList.add(new Ingredient("bay leaf", fgDAO.findById(6).get()));							//ID: 15
		ingredientsList.add(new Ingredient("beef broth", fgDAO.findById(16).get()));						//ID: 16
		ingredientsList.add(new Ingredient("beef cube steaks", fgDAO.findById(7).get()));					//ID: 17
		ingredientsList.add(new Ingredient("beef stock cube", fgDAO.findById(10).get()));					//ID: 18
		ingredientsList.add(new Ingredient("bell peppers", fgDAO.findById(3).get()));						//ID: 19
		ingredientsList.add(new Ingredient("blade steak trimmed", fgDAO.findById(7).get()));				//ID: 20
		ingredientsList.add(new Ingredient("blueberries", fgDAO.findById(3).get()));						//ID: 21
		ingredientsList.add(new Ingredient("bok choy", fgDAO.findById(2).get()));							//ID: 22
		ingredientsList.add(new Ingredient("boneless chicken thighs, cut into bite-sized pieces", fgDAO.findById(7).get()));	//ID: 23
		ingredientsList.add(new Ingredient("bread crumbs, seasoned", fgDAO.findById(4).get()));				//ID: 24
 		ingredientsList.add(new Ingredient("bread flour", fgDAO.findById(4).get()));						//ID: 25
		ingredientsList.add(new Ingredient("broccoli", fgDAO.findById(2).get()));							//ID: 26
		ingredientsList.add(new Ingredient("brown rice flour", fgDAO.findById(4).get()));					//ID: 27
		ingredientsList.add(new Ingredient("brown sugar", fgDAO.findById(5).get()));						//ID: 28
		ingredientsList.add(new Ingredient("butter", fgDAO.findById(1).get()));								//ID: 29
		ingredientsList.add(new Ingredient("butter, melted", fgDAO.findById(1).get()));						//ID: 30
		ingredientsList.add(new Ingredient("butter, softened", fgDAO.findById(1).get()));					//ID: 31
		ingredientsList.add(new Ingredient("cabbage", fgDAO.findById(2).get()));							//ID: 32
		ingredientsList.add(new Ingredient("cane sugar", fgDAO.findById(12).get()));						//ID: 33
		ingredientsList.add(new Ingredient("canned black beans", fgDAO.findById(14).get()));				//ID: 34
		ingredientsList.add(new Ingredient("canned pumpkin", fgDAO.findById(14).get()));					//ID: 35
		ingredientsList.add(new Ingredient("canola oil", fgDAO.findById(11).get()));						//ID: 36
		ingredientsList.add(new Ingredient("carrot, diced", fgDAO.findById(2).get()));						//ID: 37
		ingredientsList.add(new Ingredient("carrot, sliced", fgDAO.findById(2).get()));						//ID: 38
		ingredientsList.add(new Ingredient("carrots, chopped", fgDAO.findById(2).get()));					//ID: 39
		ingredientsList.add(new Ingredient("cauliflower florets", fgDAO.findById(2).get()));				//ID: 40
		ingredientsList.add(new Ingredient("cayenne pepper", fgDAO.findById(6).get()));						//ID: 41
		ingredientsList.add(new Ingredient("cheddar cheese, shredded", fgDAO.findById(1).get()));			//ID: 42
		ingredientsList.add(new Ingredient("chicken broth", fgDAO.findById(16).get()));						//ID: 43
		ingredientsList.add(new Ingredient("chicken thighs, skin on, bone-in", fgDAO.findById(7).get()));	//ID: 44
		ingredientsList.add(new Ingredient("chicken thighs, skinless", fgDAO.findById(7).get()));			//ID: 45
		ingredientsList.add(new Ingredient("chives, freshly chopped", fgDAO.findById(2).get()));			//ID: 46
		ingredientsList.add(new Ingredient("chocolate cookie crumbs", fgDAO.findById(4).get()));			//ID: 47
		ingredientsList.add(new Ingredient("chocolate cookies crushed", fgDAO.findById(19).get()));			//ID: 48
		ingredientsList.add(new Ingredient("chocolate, melted", fgDAO.findById(19).get()));					//ID: 49
		ingredientsList.add(new Ingredient("chopped cilantro", fgDAO.findById(12).get()));					//ID: 50
		ingredientsList.add(new Ingredient("chopped almonds", fgDAO.findById(17).get()));					//ID: 51
		ingredientsList.add(new Ingredient("chopped celery", fgDAO.findById(2).get()));						//ID: 52
		ingredientsList.add(new Ingredient("chopped fresh rosemary", fgDAO.findById(6).get()));				//ID: 53
		ingredientsList.add(new Ingredient("chopped fresh sage", fgDAO.findById(6).get()));					//ID: 54
		ingredientsList.add(new Ingredient("chopped kale", fgDAO.findById(2).get()));						//ID: 55
		ingredientsList.add(new Ingredient("chopped onion", fgDAO.findById(2).get()));						//ID: 56
		ingredientsList.add(new Ingredient("chopped pecans", fgDAO.findById(17).get()));					//ID: 57
		ingredientsList.add(new Ingredient("chopped red bell pepper", fgDAO.findById(2).get()));			//ID: 58
		ingredientsList.add(new Ingredient("chopped walnuts", fgDAO.findById(17).get()));					//ID: 59
		ingredientsList.add(new Ingredient("cider vinegar", fgDAO.findById(10).get()));						//ID: 60
		ingredientsList.add(new Ingredient("clove garlic, minced", fgDAO.findById(6).get()));				//ID: 61
		ingredientsList.add(new Ingredient("cocoa powder", fgDAO.findById(10).get()));						//ID: 62
		ingredientsList.add(new Ingredient("coconut sugar", fgDAO.findById(5).get()));						//ID: 63
		ingredientsList.add(new Ingredient("cooked black beans", fgDAO.findById(14).get()));				//ID: 64
		
		
		// Herbert: 65 - 130
		
		// Miriam: 131 - 196
		
		// Rafael: 197 - 262
		
		ingredientsList.add(new Ingredient("rolled oats", fgDAO.findById(4).get()));				            //ID: 197
		ingredientsList.add(new Ingredient("Roma tomatoes", fgDAO.findById(2).get()));				            //ID: 198
		ingredientsList.add(new Ingredient("rosemary, dried", fgDAO.findById(2).get()));			            //ID: 199
		ingredientsList.add(new Ingredient("russet potatoes, peeled and quartered", fgDAO.findById(2).get()));  //ID: 200
		ingredientsList.add(new Ingredient("russet potatoes, wedges", fgDAO.findById(2).get()));	            //ID: 201
		ingredientsList.add(new Ingredient("sake", fgDAO.findById(15).get()));				                    //ID: 202
		ingredientsList.add(new Ingredient("salmon fillet", fgDAO.findById(8).get()));				            //ID: 203
		ingredientsList.add(new Ingredient("salt", fgDAO.findById(12).get()));				                    //ID: 204
		ingredientsList.add(new Ingredient("salt and pepper to taste", fgDAO.findById(12).get()));				//ID: 205
		ingredientsList.add(new Ingredient("salt to taste", fgDAO.findById(12).get()));				            //ID: 206
		ingredientsList.add(new Ingredient("scallops", fgDAO.findById(9).get()));				                //ID: 207
		ingredientsList.add(new Ingredient("sea salt", fgDAO.findById(12).get()));				                //ID: 208
		ingredientsList.add(new Ingredient("seedless Grapes", fgDAO.findById(3).get()));				        //ID: 209
		ingredientsList.add(new Ingredient("semisweet chocolate chips", fgDAO.findById(19).get()));				//ID: 210
		ingredientsList.add(new Ingredient("sesame oil", fgDAO.findById(11).get()));				            //ID: 211
		ingredientsList.add(new Ingredient("sesame seeds ", fgDAO.findById(17).get()));				            //ID: 212
		ingredientsList.add(new Ingredient("shell pasta", fgDAO.findById(21).get()));				            //ID: 213
		ingredientsList.add(new Ingredient("shrimp ", fgDAO.findById(9).get()));				                //ID: 214
		ingredientsList.add(new Ingredient("skim milk", fgDAO.findById(1).get()));				                //ID: 215
		ingredientsList.add(new Ingredient("sliced almonds", fgDAO.findById(17).get()));				        //ID: 216
		ingredientsList.add(new Ingredient("sliced cremini mushrooms", fgDAO.findById(2).get()));				//ID: 217
		ingredientsList.add(new Ingredient("slices of bacon", fgDAO.findById(7).get()));				        //ID: 218
		ingredientsList.add(new Ingredient("smoked paprika", fgDAO.findById(6).get()));				            //ID: 219
		ingredientsList.add(new Ingredient("soy milk", fgDAO.findById(18).get()));				                //ID: 220
		ingredientsList.add(new Ingredient("soy sauce", fgDAO.findById(13).get()));				                //ID: 221
		ingredientsList.add(new Ingredient("sriracha", fgDAO.findById(13).get()));				                //ID: 222
		ingredientsList.add(new Ingredient("sriracha sauce", fgDAO.findById(10).get()));				        //ID: 223
		ingredientsList.add(new Ingredient("stalks scallions sliced", fgDAO.findById(2).get()));				//ID: 224
		ingredientsList.add(new Ingredient("strawberry, frozen", fgDAO.findById(3).get()));				        //ID: 225
		ingredientsList.add(new Ingredient("strongly brewed black coffee", fgDAO.findById(20).get()));		    //ID: 226
		ingredientsList.add(new Ingredient("sweet paprika", fgDAO.findById(12).get()));				            //ID: 227
		ingredientsList.add(new Ingredient("sweet smoked Spanish paprika", fgDAO.findById(12).get()));			//ID: 228
		ingredientsList.add(new Ingredient("sweetened condensed milk", fgDAO.findById(1).get()));				//ID: 229
		ingredientsList.add(new Ingredient("tahini", fgDAO.findById(10).get()));				                //ID: 230
		ingredientsList.add(new Ingredient("thyme, dried", fgDAO.findById(6).get()));				            //ID: 231
		ingredientsList.add(new Ingredient("tomato paste", fgDAO.findById(13).get()));				            //ID: 232
		ingredientsList.add(new Ingredient("tomatoes, chopped", fgDAO.findById(2).get()));				        //ID: 233
		ingredientsList.add(new Ingredient("tomatoes, sliced", fgDAO.findById(2).get()));						//ID: 234
		ingredientsList.add(new Ingredient("turmeric powder", fgDAO.findById(12).get()));						//ID: 235
		ingredientsList.add(new Ingredient("uncooked Arborio rice", fgDAO.findById(4).get()));					//ID: 236
		ingredientsList.add(new Ingredient("unflavored plant milk", fgDAO.findById(20).get()));					//ID: 237
		ingredientsList.add(new Ingredient("unflavored plant-based milk", fgDAO.findById(20).get()));			//ID: 238
		ingredientsList.add(new Ingredient("unsalted butter", fgDAO.findById(1).get()));						//ID: 239
		ingredientsList.add(new Ingredient("unsalted cashews", fgDAO.findById(17).get()));						//ID: 240
		ingredientsList.add(new Ingredient("unsalted raw cashews", fgDAO.findById(17).get()));					//ID: 241
		ingredientsList.add(new Ingredient("vanilla extract", fgDAO.findById(6).get()));						//ID: 242
		ingredientsList.add(new Ingredient("vegan vegetable stock", fgDAO.findById(10).get()));					//ID: 243
		ingredientsList.add(new Ingredient("vegetable oil", fgDAO.findById(11).get()));							//ID: 244
		ingredientsList.add(new Ingredient("walnuts, chopped", fgDAO.findById(17).get()));						//ID: 245
		ingredientsList.add(new Ingredient("water", fgDAO.findById(20).get()));									//ID: 246
		ingredientsList.add(new Ingredient("water, cold", fgDAO.findById(20).get()));							//ID: 247
		ingredientsList.add(new Ingredient("water, warm", fgDAO.findById(20).get()));							//ID: 248
		ingredientsList.add(new Ingredient("whipping cream", fgDAO.findById(1).get()));							//ID: 249
		ingredientsList.add(new Ingredient("white albacore tuna, drained", fgDAO.findById(8).get()));			//ID: 250
		ingredientsList.add(new Ingredient("white chocolate chips", fgDAO.findById(19).get()));					//ID: 251
		ingredientsList.add(new Ingredient("white kidney beans", fgDAO.findById(14).get()));					//ID: 252
		ingredientsList.add(new Ingredient("white onions", fgDAO.findById(2).get()));							//ID: 253
		ingredientsList.add(new Ingredient("white sugar", fgDAO.findById(5).get()));							//ID: 254
		ingredientsList.add(new Ingredient("white vinegar", fgDAO.findById(10).get()));							//ID: 255
		ingredientsList.add(new Ingredient("whole pitted dates, chopped", fgDAO.findById(3).get()));			//ID: 256
		ingredientsList.add(new Ingredient("whole wheat tortillas", fgDAO.findById(4).get()));					//ID: 257
		ingredientsList.add(new Ingredient("Worcestershire sauce", fgDAO.findById(13).get()));					//ID: 258
		ingredientsList.add(new Ingredient("yellow onion diced", fgDAO.findById(2).get()));						//ID: 259
		ingredientsList.add(new Ingredient("yuca flour", fgDAO.findById(4).get()));								//ID: 260
		ingredientsList.add(new Ingredient("yuca, peeled  in piece", fgDAO.findById(14).get()));				//ID: 261
		ingredientsList.add(new Ingredient("zucchini sliced", fgDAO.findById(2).get()));						//ID: 262
		
		
		
		for(Ingredient i : ingredientsList) {
			iDAO.save(i);
		}
		
		
		/***************** Quantity ***************/
		ArrayList<Quantity> quantityList = new ArrayList<>();
		quantityList.add(new Quantity("1"));				//ID: 1
		quantityList.add(new Quantity("4"));				//ID: 5
		quantityList.add(new Quantity("14"));				//ID: 8
		quantityList.add(new Quantity("1/4 cup"));			//ID: 11
		quantityList.add(new Quantity("1/3 cup"));			//ID: 12
		quantityList.add(new Quantity("1/2 cup"));			//ID: 13
		quantityList.add(new Quantity("3/4 cup"));			//ID: 15
		quantityList.add(new Quantity("1 cup"));			//ID: 16
		quantityList.add(new Quantity("1 1/4 cups"));		//ID: 17
		quantityList.add(new Quantity("1 1/3 cups"));		//ID: 18
		quantityList.add(new Quantity("1 1/2 cups"));		//ID: 19
		quantityList.add(new Quantity("1 3/4 cups"));		//ID: 20
		quantityList.add(new Quantity("2 cups"));			//ID: 21
		quantityList.add(new Quantity("2 1/4 cups"));		//ID: 22
		quantityList.add(new Quantity("2 1/2 cups"));		//ID: 23
		quantityList.add(new Quantity("1/4 teaspoon"));		//ID: 31
		quantityList.add(new Quantity("1/2 teaspoon"));		//ID: 32
		quantityList.add(new Quantity("1 teaspoon"));		//ID: 34
		quantityList.add(new Quantity("1 1/2 teaspoons"));	//ID: 36
		quantityList.add(new Quantity("2 teaspoons"));		//ID: 37
		quantityList.add(new Quantity("6 slices"));			//ID: 40
		quantityList.add(new Quantity("1/4 tablespoon"));	//ID: 42
		quantityList.add(new Quantity("1/2 tablespoon"));	//ID: 44
		quantityList.add(new Quantity("1 tablespoon"));		//ID: 45
		quantityList.add(new Quantity("1 1/2 tablespoons"));//ID: 46
		quantityList.add(new Quantity("2 tablespoons"));	//ID: 47
		quantityList.add(new Quantity("10 ounces"));		//ID: 57
		quantityList.add(new Quantity("16 ounces"));		//ID: 59
		
		for(Quantity q : quantityList) {
			qDAO.save(q);
		}
		
		/***************** User ***************/
		ArrayList<User> usersList = new ArrayList<>();
		//usersList.add(new User("firstName", "lastName", "email", "password", "role"));
		usersList.add(new User("Ana Paula", "Pontes", "ana.pontes@gocook.ca", "password123", "admin"));			//ID: 1
		usersList.add(new User("Herbert", "Dias", "herbert.dias@gocook.ca", "password123", "admin"));			//ID: 2
		usersList.add(new User("Miriam", "Nakiyingi", "miriam.nakiyingi@gmail.com", "password123", "user"));	//ID: 3
		usersList.add(new User("Rafael", "Pires", "rafael.pires@gmail.com", "password123", "user"));			//ID: 4
		
		for(User u : usersList) {
			uDAO.save(u);
		}
		
		/***************** Recipe ***************/
		
		ArrayList<Recipe> recipesList = new ArrayList<>();
		//Test
		/*recipesList.add(new Recipe("Title",
				new ArrayList<>(Arrays.asList("Instruction 1", "Instruction 2")),
				"Time", "# of servings",
				new ArrayList<>(Arrays.asList(cDAO.findById(id of category).get(), cDAO.findById(id of category).get()), //categories
				Stream.of(new Object[][] { 
				    { qDAO.findById(id of quantity).get(), iDAO.findById(id of ingredient).get() }, // quantities and ingredients
				}).collect(Collectors.toMap(data -> (Quantity) data[0], data -> (Ingredient) data[1])), 
				uDAO.findById(id of user).get() ));*/

		recipesList.add(new Recipe("Title",
				new ArrayList<>(Arrays.asList("1) In a medium saucepan bring 4 cups water to boiling. Gradually whisk in polenta and cumin."
						+ "Reduce heat to low; cook about 20 minutes or until mixture is thick and creamy, stirring occasionally. Remove pan from heat. Season with salt.",
						"2) In a small saucepan warm beans over low heat. Divide polenta among four individual bowls. Top with beans, pico de gallo, avocado, cilantro, and jalapeño (if using).")),
				"30 Min", "4",
				new ArrayList<>(Arrays.asList(cDAO.findById(1).get(), cDAO.findById(5).get())), //categories
				Stream.of(new Object[][] { 
				    { qDAO.findById(3).get(), iDAO.findById(3).get() }, 
				    { qDAO.findById(4).get(), iDAO.findById(4).get() }, 
				}).collect(Collectors.toMap(data -> (Quantity) data[0], data -> (Ingredient) data[1])),
				uDAO.findById(1).get() ));
		
		for(Recipe r : recipesList) {
			rDAO.save(r);
		}
		
		
		redirAttrs.addFlashAttribute("message", "The database has been populated");
		return "redirect:/";
	}
	
	
	
	

}
