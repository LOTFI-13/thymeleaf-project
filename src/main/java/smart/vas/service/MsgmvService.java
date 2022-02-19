package smart.vas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.vas.model.Msgmv;
import smart.vas.repository.MsgmvRepository;

@Service
public class MsgmvService 
{

	
	@Autowired
	MsgmvRepository msgrepositroy;
	
	
    public List<Msgmv> getAllMsgmv() {
		
		return msgrepositroy.findAll() ;
	}

     public List<Msgmv> getTraceSMS(String date_min, String date_max, String services, String operators) {
		
		return this.msgrepositroy.listMsgmvTraceSMS(date_min, date_max, services, operators) ;
	}
     
     public List<Object[]> getStatsSMS(String date_min, String date_max, String services) {
 		
 		return this.msgrepositroy.StatsSMS(date_min, date_max, services) ;
 	}
     
     public List<Object[]> getStatsSMSMois(String date_min, String date_max, String services) {
  		
  		return this.msgrepositroy.StatsSMSMois(date_min, date_max, services) ;
  	}
	
}
