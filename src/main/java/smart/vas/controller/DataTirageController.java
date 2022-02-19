package smart.vas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import smart.vas.model.DataTirage;
import smart.vas.model.Gift;
import smart.vas.model.User;
import smart.vas.service.DataTirageService;
import smart.vas.service.GiftService;


@RequestMapping("/")
@Controller
public class DataTirageController {

	@Autowired
	private DataTirageService servDataTirage;
	
	@Autowired
	private GiftService servGift;
	
	@GetMapping("/listParticipants")
	public String ShowListParticipant(Model model) {
		model.addAttribute("listDataTirage",servDataTirage.getAllDataTirage());
		
		model.addAttribute("ParticipantClass","active pcoded-trigger");
		
		
		return "listParticipants";
	}
	
	
	@GetMapping("/listWinners")
	public String ShowListWinner(Model model) {
		model.addAttribute("listDataTirage",servDataTirage.getAllDataTirage());
		model.addAttribute("GagnantClass","active pcoded-trigger");
		return "listWinners";
	}
	

	@GetMapping("/addWinner")
	public String ajouterWinner(Model model) {
		DataTirage datatirage=new DataTirage();
		model.addAttribute("datatirage",datatirage);
		
		Object bj= new Object();
		List<Gift>listgift=servGift.getAllcadeaux();
		model.addAttribute("listgift",listgift);
		return "addWinner";
	}
	
	
	@GetMapping("/Tirage")
	public String Tirage(Model model) {
		DataTirage datatirage=new DataTirage();
		Object ob=servDataTirage.getDetailTirageparHuissier(7);
		model.addAttribute("dateDeb","2017-06-01T08:31");
		model.addAttribute("forTirage",ob);		
		model.addAttribute("TirageClass","active pcoded-trigger");
		
		return "Tirage";
	}
	

	
}
