package smart.vas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import smart.vas.model.Services;


@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
	
	@Query("SELECT s.ServiceKy, s.ServiceNom FROM Services s")
	List<Object[]> getAllServices();

}
