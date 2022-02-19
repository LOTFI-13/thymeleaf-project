package smart.vas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import smart.vas.model.DataTirage;

@Repository
public interface DataTirageRepository extends JpaRepository<DataTirage, Long> {

	
	
	
	@Query(nativeQuery = true, value ="SELECT servicelink_name,detailtirage_date,detailtirage_hour,"
			+ " detailtirage_keyword,detailtirage_begindate,detailtirage_enddate,detailtirage_huissier "
			+ " FROM detailtirage, service_link WHERE "
			+ " detailtirage_prntsrvclink = servicelink_ky and detailtirage_huissier=?1 and servicelink_ky = 4 limit 1")
	Object getDetailTirageparHuissier(long HuissierKy);

	
	
	
}
