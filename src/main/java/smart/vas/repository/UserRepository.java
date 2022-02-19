package smart.vas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import smart.vas.model.User;
import smart.vas.model.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	//@Query("SELECT u FROM User u WHERE u.UserEmail=?1")
//	public User findByEmail(String email);
	
	public User findByEmail(String username);
	
	//User findByUsername(String UserName);

	@Query("select u from User u JOIN FETCH u.roles r where r.RoleName = ?1")
	public List<User> findByRole(String role);
	
	
	
}