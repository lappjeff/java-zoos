package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Telephone;

public interface TelephoneRepository extends CrudRepository<Telephone, Long>
{
}
