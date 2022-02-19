package smart.vas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import smart.vas.model.ShortCode;
import smart.vas.service.ShortCodeService;

@RequestMapping("/")
@Controller
public class ShortCodeController {

	@Autowired
	private ShortCodeService shortC;
	
	
	@GetMapping("/listCodes")
	public String ShowListShortCode(Model model) {
		model.addAttribute("listShortCodes",shortC.getAllShortCode());
		
		model.addAttribute("CodeClass"," active pcoded-trigger");
		   model.addAttribute("ActiveN1","active");
		
		return "listCodes";
		}
	
	
	@GetMapping("/addShortCode")
	public String ajouterShortCode(Model model) {
		ShortCode shortCode=new ShortCode();
		model.addAttribute("shortCode",shortCode);
		   model.addAttribute("CodeClass"," active pcoded-trigger");
		   model.addAttribute("ActiveN2","active");
		  
		return "addShortCode";
	}
	
	@PostMapping("/addShortCode")
	public String addShort(@ModelAttribute("shortCode") ShortCode shortCode) {
		
		shortC.addShort(shortCode);
		return "redirect:/";
	
}
	
	@PostMapping("/saveShortCode")
	public String saveShortCode(@ModelAttribute("shortCode") ShortCode shortCode) {

		shortC.addShort(shortCode);
		return "redirect:/listCodes";
	}
	
	@GetMapping("/editShortCode/{ShortCodeKy}")
	public String showUpdateShortCodeForm(@PathVariable ( value= "ShortCodeKy") Long id, Model model) {
		ShortCode shortCode=shortC.getShortCodeByID(id);
		model.addAttribute("shortCode",shortCode);
		return"editShortCode";
	
		}
	
	@GetMapping("/deleteShortCode/{ShortCodeKy}")
	public String DeleteShortCode(@PathVariable (value ="ShortCodeKy") Long id) {

		this.shortC.DeleteShortCodeById(id);
		return "redirect:/listCodes";
	}
 
}
