package smart.vas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import smart.vas.model.Gift;
import smart.vas.model.ShortCode;
import smart.vas.model.User;
import smart.vas.service.GiftService;
import smart.vas.service.UserService;

@RequestMapping("/")
@Controller
public class GiftController {

	@Autowired
	private GiftService servGift;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/listGift")
	public String ShowListService(Model model) {
		model.addAttribute("listGifts",servGift.getAllcadeaux());
		model.addAttribute("GiftClass"," active pcoded-trigger");
		   model.addAttribute("ActiveG1","active");
		return "listGift";
	}
	
	@GetMapping("/addGift")
	public String ajouterDetailTirage(Model model) {
		Gift gift=new Gift();
		model.addAttribute("gift",gift);
		
		List<User>clientlist=userServ.getUserbyRole("ROLE_CLIENT");
		model.addAttribute("listClient",clientlist);
		model.addAttribute("GiftClass"," active pcoded-trigger");
		   model.addAttribute("ActiveG2","active");
		return "addGift";
	}
	
	@PostMapping("/saveGift")
	public String saveShortCode(@ModelAttribute("gift") Gift gift) {

		servGift.addCadeau(gift);
		return "redirect:/listGift";
	}
	
	
}
