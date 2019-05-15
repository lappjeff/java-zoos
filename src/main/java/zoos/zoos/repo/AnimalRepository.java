package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{

}
