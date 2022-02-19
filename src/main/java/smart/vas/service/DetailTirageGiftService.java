package smart.vas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.DetailTirageGift;
import smart.vas.repository.DetailTirageGiftRepository;

@Service
public class DetailTirageGiftService {


	@Autowired
	DetailTirageGiftRepository Detailtiragerepo;
	


	public List<DetailTirageGift> getAllDetailTirtageGift() {
		return Detailtiragerepo.findAll();
	}

	public void addDetailTirtageGift(DetailTirageGift detailtirtagegift) {
		this.Detailtiragerepo.save(detailtirtagegift);
		
	}
	
	
	
}