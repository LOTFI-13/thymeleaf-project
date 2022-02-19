package smart.vas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import smart.vas.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query("SELECT r FROM Role r WHERE r.RoleName=?1")
	public Role findByName(String name);
}
