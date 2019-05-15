package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Zoo;

public interface AnimalRepository extends CrudRepository<Zoo, Long>
{
	Zoo findByZooname(String name);

}
