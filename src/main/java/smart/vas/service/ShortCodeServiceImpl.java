package smart.vas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import smart.vas.model.ShortCode;

import smart.vas.repository.ShortCodeRepository;

@Service
public class ShortCodeServiceImpl implements ShortCodeService {

	@Autowired
	private ShortCodeRepository ShortCodeRepo;

	@Override
	public List<ShortCode> getAllShortCode() {
	
		return ShortCodeRepo.findAll();
	}
	
	@Override
	public void addShort(ShortCode shortCode) {
		this.ShortCodeRepo.save(shortCode);
		
	}

		
	
	@Override
	public ShortCode getShortCodeByID(Long id) {
		Optional<ShortCode> optional = ShortCodeRepo.findById(id);
		ShortCode shortCode=null;
		if (optional.isPresent()) {
			shortCode=optional.get();
		}
		else {
			throw new RuntimeException("Pas de numero court avec cet id:" +id);
		}
		return shortCode;
	}

	@Override
	public void DeleteShortCodeById(Long id) {
		this.ShortCodeRepo.deleteById(id);
	}

	
	


}