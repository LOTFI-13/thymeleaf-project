package smart.vas.service;

import java.util.List;

import smart.vas.model.ShortCode;



public interface ShortCodeService 
{
	List<ShortCode> getAllShortCode();
	void addShort(ShortCode shortCode) ; 

	ShortCode getShortCodeByID(Long id);
	void DeleteShortCodeById(Long id);
	

}


