package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import zoos.zoos.model.Role;

@Service
public interface RoleRepository extends CrudRepository<Role, Long>
{
}
