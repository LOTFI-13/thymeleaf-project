package smart.vas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import smart.vas.model.Msgmv;

@Repository
public interface MsgmvRepository extends JpaRepository<Msgmv, Long> {

	

	@Query(nativeQuery = true, value ="select MSGMV_MSISDN, MSGMV_SERVICEIDENTIFIER,MSGMV_MESSAGE_IN, MSGMV_MESSAGE_OUT,MSGMV_OPERATOR, Date_Format(MSGMV_TIMESTAMP_IN,'%Y-%m-%d %H:%i:%s') \r\n"+
			" from MSGMV \r\n"+
			" where Date_Format(MSGMV_TIMESTAMP_IN,'%Y-%m-%d') between ?1 and ?2 \r\n" +
			" and MSGMV_SERVICEIDENTIFIER in (?3) +\r\n" + 
			" and MSGMV_OPERATOR in (?4) \r\n"+ 
			" order by Date_Format(MSGMV_TIMESTAMP_IN,'%Y-%m-%d %H:%i:%s') desc")
	List<Msgmv> listTraceSMS(String date_min, String date_max, String services, String Operator);
	
	
	@Query("select m from Msgmv m where ( m.TIMESTAMP_IN between ?1 and ?2) and m.Keyword_Alias=?3 and m.OPERATOR=?4")
	List<Msgmv> listMsgmvTraceSMS(String date_min, String date_max, String services, String Operator);
	
	@Query(nativeQuery = true, value ="SELECT Date_Format(Msgmv_Tsin,'%Y-%m-%d') as Date, +\r\n" + 
			"                       sum(CASE WHEN Msgmv_Operator in ('TT') and Msgmv_Keyword in ('JAeTech') THEN 1 ELSE 0 END) AS NBR_SMS1, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('OTT') and Msgmv_Keyword in ('JAeTech') THEN 1 ELSE 0 END) AS NBR_SMS2, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('ORG') and Msgmv_Keyword in ('JAeTech') THEN 1 ELSE 0 END) AS NBR_SMS3, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('TT')  and Msgmv_Keyword in ('SR') THEN 1 ELSE 0 END) AS NBR_SMS4, \r\n" + 
			"		    		    sum(CASE WHEN Msgmv_Operator in ('OTT') and Msgmv_Keyword in ('SR') THEN 1 ELSE 0 END) AS NBR_SMS5, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('ORG') and Msgmv_Keyword in ('SR') THEN 1 ELSE 0 END) AS NBR_SMS6  \r\n" + 
			"		    			FROM Msgmv where Date_Format(Msgmv_Tsin,'%Y-%m-%d') BETWEEN ?1 AND ?2 \r\n" + 
			"		    			GROUP BY Date_Format(Msgmv_Tsin,'%Y-%m-%d') order by Date_Format(Msgmv_Tsin,'%Y-%m-%d') asc")
	List<Object[]> StatsSMS(String date_min, String date_max, String services);
	
	@Query(nativeQuery = true, value ="SELECT Date_Format(Msgmv_Tsin,'%Y-%m') as Date, +\r\n" + 
			"                       sum(CASE WHEN Msgmv_Operator in ('TT') and Msgmv_Keyword in ('JAeTech') THEN 1 ELSE 0 END) AS NBR_SMS1, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('OTT') and Msgmv_Keyword in ('JAeTech') THEN 1 ELSE 0 END) AS NBR_SMS2, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('ORG') and Msgmv_Keyword in ('JAeTech') THEN 1 ELSE 0 END) AS NBR_SMS3, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('TT')  and Msgmv_Keyword in ('SR') THEN 1 ELSE 0 END) AS NBR_SMS4, \r\n" + 
			"		    		    sum(CASE WHEN Msgmv_Operator in ('OTT') and Msgmv_Keyword in ('SR') THEN 1 ELSE 0 END) AS NBR_SMS5, \r\n" + 
			"		    			sum(CASE WHEN Msgmv_Operator in ('ORG') and Msgmv_Keyword in ('SR') THEN 1 ELSE 0 END) AS NBR_SMS6  \r\n" + 
			"		    			FROM Msgmv where Date_Format(Msgmv_Tsin,'%Y-%m') BETWEEN ?1 AND ?2 \r\n" + 
			"		    			GROUP BY Date_Format(Msgmv_Tsin,'%Y-%m') order by Date_Format(Msgmv_Tsin,'%Y-%M') asc")
	List<Object[]> StatsSMSMois(String date_min, String date_max, String services);
	
	
	@Query(nativeQuery = true, value ="SELECT count(*) as NbSMS \r\n" + 
			"		    			FROM Msgmv where Date_Format(Msgmv_Tsin,'%Y-%m')= ?1 and Msgmv_Operator= ?2 \r\n" + 
			"		    			and Msgmv_Shortcodein = ?3")
	long getNBSMSbyShortCode(String Month, String Opertaor, String shortCode);
	
	
	@Query(nativeQuery = true, value ="SELECT count(*) as NbSMS \r\n" + 
			"		    			FROM Msgmv where Date_Format(Msgmv_Tsin,'%Y-%m') between ?1 and ?2 \r\n" + 
			"		    			and Msgmv_Srvclink = ?3")
	long getNBSMSbySrvcLink(String dateDebut, String dateFin, long Srvclink);
	
	
	/*public interface Stats{
	    String getDate();
	    int getNBR_SMS1();
	    int getNBR_SMS2();
	    int getNBR_SMS3();
	    int getNBR_SMS4();
	    int getNBR_SMS5();
	    int getNBR_SMS6();

	}*/
	
}
