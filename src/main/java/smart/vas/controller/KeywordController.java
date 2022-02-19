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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import smart.vas.model.Keyword;
import smart.vas.model.ServiceLink;

import smart.vas.service.ServiceLinkService;
import smart.vas.service.KeywordService;

@RequestMapping("/")
@Controller
public class KeywordController {
	
	@Autowired
	private KeywordService motCleServ;
	
	@Autowired
	private ServiceLinkService serviceLinkServ;
	
	@GetMapping("/listKeywords")
	public String ShowListMotCle(Model model) {
		model.addAttribute("listMotCle",motCleServ.getAllmotCle());
		
		model.addAttribute("KeywordClass"," active pcoded-trigger");
		   model.addAttribute("ActiveK3","active");
		return "listKeywords";
		
		
	}

	
	@GetMapping("/addKeyword/{ServiceLinkKy}")
	public String ajouterMotCle(@PathVariable ( value= "ServiceLinkKy") Long id, Model model) {
		List<ServiceLink>servicelinklist=serviceLinkServ.getAllservicelink();
		model.addAttribute("ServiceLinkKy",id);
		Keyword keyword=new Keyword();
		ServiceLink sl = new ServiceLink();
		sl.setServiceLinkKy(id);
		keyword.setPrtlnSrvcLink(sl);
		model.addAttribute("keyword",keyword);
		return "addKeyword";
	}
	
	
	@PostMapping("/saveKeyword")
	public String saveMotcle(@ModelAttribute("keyword") Keyword keyword) {
		motCleServ.addMotCle(keyword);
		return "redirect:/listKeywords";
		
}
	
	@GetMapping("/editKeyword/{KeywordKy}")
	public String showUpdateKeyWordForm(@PathVariable ( value= "KeywordKy") Long KeywordKy, Model model) {
		
		Keyword keyword=motCleServ.getKeyWordByID(KeywordKy);
		model.addAttribute("keyword",keyword);
		
		return"editKeyword";
	
		}
	
	@GetMapping("/DeleteMotCle/{keyWord_id}")
	public String DeleteKeyWord(@PathVariable (value ="keyWord_id") Long keyWord_id) {

		this.motCleServ.DeleteKeyWordById(keyWord_id);
		return "redirect:/listKeywords";
	
}
	
	
	@GetMapping("/KeywordbyService")
	public @ResponseBody String getListKeywordbyService(@RequestParam long SrvcLinkKy)
	{
		String json = null;
		List<Object[]> list = motCleServ.getmotClebyService(SrvcLinkKy);
		
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
