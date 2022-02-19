package smart.vas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.DataTirage;
import smart.vas.repository.DataTirageRepository;

@Service
public class DataTirageService {

	
	@Autowired
	DataTirageRepository Datatiragerepo;


	public List<DataTirage> getAllDataTirage() {
		return Datatiragerepo.findAll();
	}

	public void addDataTirage(DataTirage datatirtage) {
		this.Datatiragerepo.save(datatirtage);
		
	}
	
	 public Object getDetailTirageparHuissier(long HuissierKy) {
	  		
	  		return this.Datatiragerepo.getDetailTirageparHuissier(HuissierKy) ;
	  	}
		
}
