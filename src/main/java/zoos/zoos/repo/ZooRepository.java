package zoos.zoos.repo;

import org.springframework.data.repository.CrudRepository;
import zoos.zoos.model.Zoo;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
}
