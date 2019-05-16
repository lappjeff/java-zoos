package zoos.zoos.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import zoos.zoos.model.User;

@Service
public interface UserRepository extends CrudRepository<User, Long>
{
	User findByUsername(String username);

	@Modifying
	@Query(value = "DELETE FROM userroles WHERE userid = :userid", nativeQuery = true)
	void deleteUserRole(long userid);

}
