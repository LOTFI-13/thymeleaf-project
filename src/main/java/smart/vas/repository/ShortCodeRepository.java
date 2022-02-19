package smart.vas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import smart.vas.model.ShortCode;

@Repository
public interface ShortCodeRepository extends JpaRepository<ShortCode, Long>{
	
	@Query(nativeQuery = true, value ="SELECT Shortcode_Prix \r\n" + 
			"		    			FROM Shortcode where Shortcode_Value = ?1")
	double getPrixShortCode(String shortCode);

	
}