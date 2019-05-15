package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Animal;
import zoos.zoos.model.Zoo;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{

}
