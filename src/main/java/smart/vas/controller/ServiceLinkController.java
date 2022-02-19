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

import smart.vas.model.User;
import smart.vas.model.ServiceLink;
import smart.vas.model.Services;
import smart.vas.model.ShortCode;

import smart.vas.service.UserService;
import smart.vas.service.ServiceLinkService;
import smart.vas.service.ServiceService;
import smart.vas.service.ShortCodeServiceImpl;

@RequestMapping("/")
@Controller
public class ServiceLinkController{
	
	

	@Autowired
	ServiceLinkService servicelinkServ;
	
	@Autowired
	UserService userServ;
	
	@Autowired
	ServiceService serviceServ;
	
	@Autowired
	ShortCodeServiceImpl shortcodeServ;
	
	@GetMapping("/listAffect")
	public String ShowListServiceLinkPage(Model model) {
		model.addAttribute("listServiceLink",servicelinkServ.getAllservicelink());
		model.addAttribute("KeywordClass"," active pcoded-trigger");
		   model.addAttribute("ActiveK2","active");
		return "listAffect";
	}
	

	@GetMapping("/affectService")
	public String showAddServiceLinkForm(Model model) {
		List<User>adminlist=userServ.getUserbyRole("ROLE_CLIENT");
		model.addAttribute("listAdmin",adminlist);
		List<Services>servicelist=serviceServ.getAllservices();
		model.addAttribute("listService",servicelist);
		List<ShortCode>shortcodelist=shortcodeServ.getAllShortCode();
		model.addAttribute("listShortCode",shortcodelist);
		ServiceLink servicelink =new ServiceLink ();
		model.addAttribute("servicelink",servicelink);
		model.addAttribute("KeywordClass"," active pcoded-trigger");
		   model.addAttribute("ActiveK1","active");
		return "affectService";	
	}
	
	
	@PostMapping("/saveSrvcLink")
	public String saveServiceLink(@ModelAttribute("servicelink") ServiceLink servicelink) {

		servicelinkServ.addServiceLink(servicelink);
		return "redirect:/listAffect";
	}
	
	@GetMapping("/editServiceLink/{serviceLinkKy}")
	public String showUpdateServiceLinkForm(@PathVariable ( value= "serviceLinkKy") Long serviceLinkKy, Model model) {
		
		List<User>adminlist=userServ.getAllUsers();
		model.addAttribute("listAdmin",adminlist);
		
		List<Services>servicelist=serviceServ.getAllservices();
		model.addAttribute("listService",servicelist);
		
		List<ShortCode>shortcodelist=shortcodeServ.getAllShortCode();
		model.addAttribute("listShortCode",shortcodelist);
		
		ServiceLink servicelink=servicelinkServ.getServiceLinkByID(serviceLinkKy);
		model.addAttribute("servicelink",servicelink);
		
		return"editSrvclink";
	
		}
	
	@GetMapping("/DeleteServiceLink/{serviceLink_id}")
	public String DeleteServiceLink(@PathVariable (value ="serviceLink_id") Long serviceLink_id) {

		this.servicelinkServ.DeleteServiceLinkById(serviceLink_id);
		return "redirect:/";
	}
	
	
	@GetMapping("/loadServiceByClient")
	public @ResponseBody String getServicebyClient(@RequestParam int ClientKy)
	{
		String json = null;
		List<Object[]> list = servicelinkServ.getAllServicesbyClient(ClientKy);
		//List<ShortCode> shortcodelist=shortcodeServ.getAllShortCode();
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
