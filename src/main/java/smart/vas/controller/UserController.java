package smart.vas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import smart.vas.model.Role;

import smart.vas.model.User;
import smart.vas.service.UserService;

@Controller
public class UserController 
{
	
	 @Autowired
	    private UserService userService;

	    // display list of employees
	 @GetMapping("/index")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listUsers", userService.getAllUsers());
	        model.addAttribute("TablBord","active pcoded-trigger");
	        
	        return "index";
	    }
	 
	 @GetMapping("/login")
	    public String loginPage(Model model) {
	        return "login";
	    }
	 
	 
	 @GetMapping("/listUsers")
	    public String viewUsersList(Model model) {
	        model.addAttribute("listUsers", userService.getAllUsers());
	        model.addAttribute("conditionClass"," active pcoded-trigger");
	        model.addAttribute("ActiveU1","active");
	        
	        
	        return "listUsers";
	    }
	 
	 
	 @GetMapping("/addUser")
		public String showNewEmployeeForm(Model model) {
			// create model attribute to bind form data
			User user = new User();
			model.addAttribute("user", user);
			List<Role> listRoles = userService.getRoles();
			model.addAttribute("listRoles", listRoles);
			 model.addAttribute("conditionClass"," active pcoded-trigger");
			   model.addAttribute("ActiveU2","active");
			return "addUser";
		}
	 
	 @GetMapping("/editUser/{UserKy}")
		public String editUser(@PathVariable("UserKy") int id, Model model) {
			User user = userService.get(id);
			List<Role> listRoles = userService.getRoles();
			
			model.addAttribute("user", user);
			model.addAttribute("listRoles", listRoles);
			
			return"editUser";
		}
	 
	 @GetMapping(path="/deleteUser/{UserKy}")
		public String deleteUserById(@PathVariable("UserKy") int id, Model model){
			
			userService.deleteUserById(id);
			 return "redirect:/listUsers";
			
		}
	 
	 
	 @PostMapping("/saveUser")
	    public String saveUser(@ModelAttribute("user") User user) {
	        // save user to database
		 
		  userService.saveUser(user);
		  
	      return "redirect:/listUsers";
	    }
	 

}
