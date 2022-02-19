package smart.vas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import smart.vas.model.Keyword;


@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
	
	
	@Query(nativeQuery = true, value ="SELECT Keyword_Ky, Keyword_Alias, Keyword_Value  FROM Keyword K"
			+ " WHERE K.Servicelink_Ky= ?1")
	List<Object[]> getmotClebyService(long SrvcLinkKy);

}
