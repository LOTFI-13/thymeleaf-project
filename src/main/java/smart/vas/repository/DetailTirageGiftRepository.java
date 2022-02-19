package smart.vas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smart.vas.model.DetailTirageGift;

@Repository
public interface DetailTirageGiftRepository  extends JpaRepository<DetailTirageGift, Long> {

	

}
