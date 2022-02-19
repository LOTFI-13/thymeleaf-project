package smart.vas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.Services;

import smart.vas.repository.ServiceRepository;


@Service
public class ServiceService{

	@Autowired
	private ServiceRepository ServiceRepo;
	

	public List<Services> getAllservices() {
		return ServiceRepo.findAll();
	}

	
	public List<Object[]> getAllCountries(){
		return ServiceRepo.getAllServices();
	}

public void saveService (Services service) {
		this.ServiceRepo.save(service);
		
	}


public Services getServiceByID(Long id) {
	Optional<Services> optional = ServiceRepo.findById(id);
	Services service=null;
	if(optional.isPresent()) {
		service=optional.get();
	}
	else {
		throw new RuntimeException("Pas de service avec cet id:" +id);
	}
	return service;
}

	public void DeleteServiceById(Long id) {
		this.ServiceRepo.deleteById(id);
	}

	
	public void addService(Services service) {
		this.ServiceRepo.save(service);
		
	}

	
}
	


