package zoos.zoos.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Animal;
import zoos.zoos.view.CountZoosWithAnimals;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
	ArrayList<Animal> getAnimalByAnimaltype(String type);

	@Query(value = "SELECT za.animalid, animaltype, count(zooid) as countzoos FROM zooanimals za INNER JOIN  animal a" +
			" " +
			"on za.animalid=a.animalid GROUP BY za.animalid, animaltype",
		   nativeQuery = true)
	ArrayList<CountZoosWithAnimals> getCountZoosWithAnimals();
}
