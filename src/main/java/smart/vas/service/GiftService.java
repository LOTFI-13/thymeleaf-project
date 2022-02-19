package smart.vas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.Gift;
import smart.vas.repository.GiftRepository;


@Service
public class GiftService{
	
	@Autowired 
	private GiftRepository cadeauRepo;
	
	
	
	public List<Gift> getAllcadeaux() {
		return cadeauRepo.findAll();
	}



	public void addCadeau(Gift cadeau) {
		this.cadeauRepo.save(cadeau);
		
	}

	
	public Gift getCadeauByID(Long id) {
		Optional<Gift> optional = cadeauRepo.findById(id);
		Gift cadeau=null;
		if(optional.isPresent()) {
			cadeau=optional.get();
		}
		else {
			throw new RuntimeException("Pas de cadeau avec cet id:" +id);
		}
		return cadeau;
	}

	public void DeleteCadeauById(Long id) {
		this.cadeauRepo.deleteById(id);
	}


}


