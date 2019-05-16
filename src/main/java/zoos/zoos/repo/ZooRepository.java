package zoos.zoos.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Zoo;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
	Zoo findByZooname(String zooName);

	@Modifying
	@Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
	void deleteZooFromZooAnimals(long zooid);

	@Modifying
	@Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid AND animalid = :animalid", nativeQuery = true)
	void deleteAnimalFromZoo(long zooid, long animalid);
}
