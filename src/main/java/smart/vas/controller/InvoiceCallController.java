package smart.vas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import smart.vas.model.InvoiceCall;
import smart.vas.model.ShortCode;
import smart.vas.model.User;
import smart.vas.service.InvoiceCallService;
import smart.vas.service.ShortCodeServiceImpl;
import smart.vas.service.UserService;
import smart.vas.service.ServiceService;
import smart.vas.service.ServiceLinkService;
import smart.vas.repository.MsgmvRepository;
import smart.vas.repository.ShortCodeRepository;

@RequestMapping("/")
@Controller
public class InvoiceCallController {
	
	@Autowired
	private InvoiceCallService servInvoiceCall;
	
	@Autowired
	ShortCodeServiceImpl shortcodeServ;
	
	@Autowired
	ServiceService serv;
	
	@Autowired
	MsgmvRepository msgrepositroy;
	
	@Autowired
	ShortCodeRepository shortcodeRepo;
	
	@Autowired
	ServiceLinkService SrvclinkService;
	
	@Autowired
	UserService userServ;
	
	@GetMapping("/listInvoicecall")
	public String ShowListService(Model model) {
		model.addAttribute("listinvoicecall",servInvoiceCall.getAllCallinvoice());
		
		
		model.addAttribute("FactureClass"," active pcoded-trigger");
		model.addAttribute("ActiveAF1","active");
		
		return "listInvoiceCall";
	}

	
	
	@GetMapping("/addInvoiceCall")
	public String ajouterService(Model model) {
		InvoiceCall invCall=new InvoiceCall();
		model.addAttribute("invoiceCall",invCall);
		List<ShortCode>shortcodelist=shortcodeServ.getAllShortCode();
		model.addAttribute("listShortCode",shortcodelist);
		
		model.addAttribute("FactureClass"," active pcoded-trigger");
		model.addAttribute("ActiveAF2","active");
		
		return "addInvoiceCall";
	}
	
	
	
	@PostMapping("/saveInvoiceCall")
	public String addService(@ModelAttribute("invoiceCall") InvoiceCall invCall) {
		String ShortCode=invCall.getShortcode();
		String Operator= invCall.getOperateur();
		String periode = invCall.getPeriod();
		invCall.setNbSms(msgrepositroy.getNBSMSbyShortCode(periode, Operator, ShortCode));
		double prix= shortcodeRepo.getPrixShortCode(ShortCode);
		invCall.setRevenue(prix);
		servInvoiceCall.addinvoiceCall(invCall);
		return "redirect:/listInvoicecall";
	}
	
	@GetMapping("/profitClient")
	public String ShowPartageRevenue(Model model) {
		List<User>clientlist=userServ.getUserbyRole("Client");
		model.addAttribute("listClient",clientlist);
		model.addAttribute("ProfitClass","active pcoded-trigger");
		return "profitClient";
	}
	
	
	
	
	
	@GetMapping("/loadDetailService")
	public @ResponseBody String getDetailService(@RequestParam long SrvcLinkKy)
	{
		String json = null;
		List<Object[]> list = SrvclinkService.getDetailService(SrvcLinkKy);
		
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}

