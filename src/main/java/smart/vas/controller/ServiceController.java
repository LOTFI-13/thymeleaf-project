package smart.vas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import smart.vas.model.Services;
import smart.vas.service.ServiceService;



@RequestMapping("/")
@Controller
public class ServiceController {
	
	@Autowired
	private ServiceService serv;
	
	
	
	
	@GetMapping("/listServices")
	public String ShowListService(Model model) {
		model.addAttribute("listService",serv.getAllservices());
		model.addAttribute("ServiceClass"," active pcoded-trigger");
        model.addAttribute("ActiveSr1","active");
		return "listServices";
	}

	
	
	@GetMapping("/addService")
	public String ajouterService(Model model) {
		Services service=new Services();
		model.addAttribute("service",service);
		model.addAttribute("ServiceClass"," active pcoded-trigger");
        model.addAttribute("ActiveSr2","active");
		return "addService";
	}
	
	
	
	@PostMapping("/addService")
	public String addService(@ModelAttribute("service") Services service) {
		serv.saveService(service);
		return "redirect:/";
	}
	
		
	@PostMapping("/saveService")
	public String saveService(@ModelAttribute("service") Services service) {
	
		serv.addService(service);
		return "redirect:/listServices";
	}
	
	@GetMapping("/editService/{ServiceKy}")
	public String showUpdateServiceForm(@PathVariable ( value= "ServiceKy") Long id, Model model) {
		Services service=serv.getServiceByID(id);
		model.addAttribute("service",service);
		return"editService";
	
		}
	
	@GetMapping("/deleteService/{ServiceKy}")
	public String DeleteService(@PathVariable (value ="ServiceKy") Long id) {

		this.serv.DeleteServiceById(id);
		return "redirect:/listServices";
	}

}
