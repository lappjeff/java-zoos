package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import zoos.zoos.model.User;

@Service
public interface UserRepository extends CrudRepository<User, Long>
{
	User findByUsername(String username);

}
