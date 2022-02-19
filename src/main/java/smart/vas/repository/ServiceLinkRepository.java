package smart.vas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import smart.vas.model.ServiceLink;

@Repository
public interface ServiceLinkRepository extends JpaRepository <ServiceLink, Long>{
	
	
	@Query(nativeQuery = true, value ="SELECT Servicelink_Ky,Servicelink_Name FROM Service_Link WHERE User_Ky= ?1")
	List<Object[]> getServicebyClient(int ClientKy);
	
	@Query(nativeQuery = true, value ="SELECT Servicelink_Datedebut,Servicelink_Datefin,Shortcode_Prix FROM Service_Link S, Shortcode C "
			+ " WHERE S.Shortcode_Ky= C.Shortcode_Ky and S.Servicelink_Ky= ?1")
	List<Object[]> getDetailbyService(long SrvcLinkKy);

}
