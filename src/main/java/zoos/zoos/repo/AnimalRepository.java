package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Animal;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
	ArrayList<Animal> getAnimalByAnimaltype(String type);
}
