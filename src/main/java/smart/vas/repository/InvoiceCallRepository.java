package smart.vas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smart.vas.model.InvoiceCall;


@Repository
public interface InvoiceCallRepository extends JpaRepository<InvoiceCall, Long> {

	
	
	}
