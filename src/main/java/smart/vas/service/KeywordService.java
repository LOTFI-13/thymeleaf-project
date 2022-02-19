package smart.vas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.Keyword;
import smart.vas.repository.KeywordRepository;

@Service
public class KeywordService{
	
	@Autowired
	KeywordRepository motCleRepo;


	public List<Keyword> getAllmotCle() {
		return motCleRepo.findAll();
	}

	

	public void addMotCle(Keyword keyword) {
		this.motCleRepo.save(keyword);
		
	}
	
	public Keyword getKeyWordByID(Long id) {
		Optional<Keyword> optional = motCleRepo.findById(id);
		Keyword keyword=null;
		if(optional.isPresent()) {
			keyword=optional.get();
		}
		else {
			throw new RuntimeException("Pas de mot cle avec cet id:" +id);
		}
		return keyword;
	}

	public void DeleteKeyWordById(Long id) {
		this.motCleRepo.deleteById(id);
		
	}
	

	public List<Object[]> getmotClebyService(long SrvcLinkKy)
	{
		return motCleRepo.getmotClebyService(SrvcLinkKy);
	}
	
	
		
	}
	


