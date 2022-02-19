package smart.vas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smart.vas.model.DetailTirage;

@Repository
public interface DetailTirageRepository extends JpaRepository<DetailTirage, Long> 
{

}
