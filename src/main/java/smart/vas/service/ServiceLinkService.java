package smart.vas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.ServiceLink;
import smart.vas.repository.ServiceLinkRepository;

@Service
public class ServiceLinkService {
	
	@Autowired 
	ServiceLinkRepository servicelinkRepo;
	
	
	public List<ServiceLink> getAllservicelink() {
		
		return servicelinkRepo.findAll() ;
	}

	
	public void addServiceLink(ServiceLink servicelink) {
		this.servicelinkRepo.save(servicelink);
		
	}
	

	public ServiceLink getServiceLinkByID(Long id) {
		Optional<ServiceLink> optional = servicelinkRepo.findById(id);
		ServiceLink servicelink=null;
		if(optional.isPresent()) {
			servicelink=optional.get();
		}
		else {
			throw new RuntimeException("Pas de service link avec cet id:" +id);
		}
		return servicelink;
	}
	
	public List<Object[]> getAllServicesbyClient(int ClientKy){
		return servicelinkRepo.getServicebyClient(ClientKy);
	}
	
	public List<Object[]> getDetailService(long SrvcLinkKy){
		return servicelinkRepo.getDetailbyService(SrvcLinkKy);
	}
	
	
	public void DeleteServiceLinkById(Long id) {
		this.servicelinkRepo.deleteById(id);
		
	}

	

	


}
