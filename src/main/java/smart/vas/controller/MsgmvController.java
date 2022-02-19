package smart.vas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import smart.vas.service.MsgmvService;


@RequestMapping("/")
@Controller
public class MsgmvController {

	
	@Autowired
	MsgmvService serviceMsgmv;
	
	@GetMapping("/TraceSMS")
	public String Traces(Model model,
			@Param ("date_min") String date_min, @Param ("date_max") String date_max, @Param ("srvc") String srvc, @Param ("opertaor") String operator) {

		//this.serviceMsgmv.getTraceSMS(date_min, date_max, services, operators);
		
		 
			model.addAttribute("listmsgmv",serviceMsgmv.getTraceSMS(date_min, date_max,srvc,operator));
			model.addAttribute("date_max",date_max);
			model.addAttribute("date_min",date_min);
			
			model.addAttribute("TraceClass","active pcoded-trigger");
			
			return "TraceSMS";
		
	}
	
	@GetMapping("/StatsSMS")
	public String Stats(Model model,
			@Param ("date_min") String date_min, @Param ("date_max") String date_max, @Param ("srvc") String srvc) {

		//this.serviceMsgmv.getTraceSMS(date_min, date_max, services, operators);
		
		 
			model.addAttribute("statsmsgmv",(serviceMsgmv.getStatsSMS(date_min, date_max,srvc)));
			model.addAttribute("date_max",date_max);
			model.addAttribute("date_min",date_min);
			
			model.addAttribute("StatClass"," active pcoded-trigger");
			model.addAttribute("ActiveSts1","active");
			return "StatsSMS";
		
	}
	
	@GetMapping("/StatsSMSMois")
	public String StatsMois(Model model,
			@Param ("date_min") String date_min, @Param ("date_max") String date_max, @Param ("srvc") String srvc) {

		//this.serviceMsgmv.getTraceSMS(date_min, date_max, services, operators);
		
		 
			model.addAttribute("statsmsgmv",(serviceMsgmv.getStatsSMSMois(date_min, date_max,srvc)));
			model.addAttribute("date_max",date_max);
			model.addAttribute("date_min",date_min);
			
			model.addAttribute("StatClass"," active pcoded-trigger");
			model.addAttribute("ActiveSts2","active");
			return "StatsSMSMois";
		
	}
}
