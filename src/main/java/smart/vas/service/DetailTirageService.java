package smart.vas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.DetailTirage;
import smart.vas.repository.DetailTirageRepository;

@Service
public class DetailTirageService {

	
	@Autowired
	DetailTirageRepository Detailtiragerepo;


	public List<DetailTirage> getAllDetailTirage() {
		return Detailtiragerepo.findAll();
	}

	public void addDetailTirage(DetailTirage detailtirage) {
		System.out.println(detailtirage.getDetailTirageBeginDate());
		System.out.println(detailtirage.getDetailTirageEndDate());
		System.out.println(detailtirage.getDetailTirageDate());
		System.out.println(detailtirage.getDetailTirageHour());
		this.Detailtiragerepo.save(detailtirage);
		
		
		
	}
}