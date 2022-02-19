package smart.vas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import smart.vas.model.DetailTirage;
import smart.vas.model.DetailTirageGift;
import smart.vas.model.Gift;
import smart.vas.service.DetailTirageGiftService;
import smart.vas.service.GiftService;

@RequestMapping("/")
@Controller
public class DetailTirageGiftController {
	
	
	
	
	@Autowired
	private DetailTirageGiftService detailgiftserv;
	
	@Autowired
	private GiftService giftserv;
	
	@GetMapping("/listDetailTirageGift")
	public String ShowListMotCle(Model model) {
		model.addAttribute("listDetailTirageGift",detailgiftserv.getAllDetailTirtageGift());
		return "listDetailTirageGift";
	}
	
	
	@GetMapping("/affectGift/{DetailTirageKy}")
	public String AffectGift(@PathVariable ( value= "DetailTirageKy") Long id, Model model) {
		List<Gift> listGift=giftserv.getAllcadeaux();
		model.addAttribute("listGift",listGift);
		model.addAttribute("DetailTirageKy",id);
		DetailTirageGift detailtiragegain=new DetailTirageGift();
		DetailTirage dt = new DetailTirage();
		dt.setDetailTirageKy(id);
		detailtiragegain.setPrntlnDetailTirage(dt);;
		model.addAttribute("detailtiragegift",detailtiragegain);
		return "affectGift";
	}
	
	
	@PostMapping("/saveDetailTirageGift")
	public String SaveAffectGift(@ModelAttribute("detailtiragegift") DetailTirageGift detailTirageGift) {
		detailgiftserv.addDetailTirtageGift(detailTirageGift);
		return "redirect:/listDetailTirage";
		
}

}
