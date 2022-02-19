package smart.vas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import smart.vas.model.DetailTirage;
import smart.vas.model.Gift;
import smart.vas.model.User;
import smart.vas.service.DetailTirageService;
import smart.vas.service.UserService;

@RequestMapping("/")
@Controller
public class DetailTirageController {

	@Autowired
	private DetailTirageService servDetailTirage;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/listDetailTirage")
	public String ShowListService(Model model) {
		model.addAttribute("listDetailTirage",servDetailTirage.getAllDetailTirage());
		
		model.addAttribute("DetailClass"," active pcoded-trigger");
		model.addAttribute("ActiveDT1","active");
		
		return "listDetailTirage";
	}
	
	@GetMapping("/addDetailTirage")
	public String ajouterDetailTirage(Model model) {
		DetailTirage detailTirage=new DetailTirage();
		model.addAttribute("detailTirage",detailTirage);
		
		List<User>clientlist=userServ.getUserbyRole("ROLE_CLIENT");
		model.addAttribute("listClient",clientlist);
		
		List<User>huissierlist=userServ.getUserbyRole("ROLE_HUISSIER");
		model.addAttribute("listHuissier",huissierlist);
		
		model.addAttribute("DetailClass"," active pcoded-trigger");
		   model.addAttribute("ActiveDT2","active");
		
		return "addDetailTirage";
	}
	
	
	@PostMapping("/saveDetailTirage")
	public String saveShortCode(@ModelAttribute("detailTirage") DetailTirage detailtirage) {
         
		servDetailTirage.addDetailTirage(detailtirage);
		return "redirect:/listDetailTirage";
	}
	
}
