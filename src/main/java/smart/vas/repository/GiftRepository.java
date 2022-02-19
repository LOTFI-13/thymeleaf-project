package smart.vas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smart.vas.model.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

}
