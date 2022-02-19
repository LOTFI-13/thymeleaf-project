package smart.vas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.InvoiceCall;
import smart.vas.repository.InvoiceCallRepository;

@Service
public class InvoiceCallService {

	
	@Autowired
	InvoiceCallRepository invoicecallrepo;


	public List<InvoiceCall> getAllCallinvoice() {
		return invoicecallrepo.findAll();
	}

	public void addinvoiceCall(InvoiceCall invoicecall) {
		this.invoicecallrepo.save(invoicecall);
		
	}
}
