package zoos.zoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoos.zoos.model.Animal;
import zoos.zoos.model.Telephone;
import zoos.zoos.model.Zoo;
import zoos.zoos.repo.ZooRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
	@Autowired
	private ZooRepository zoorepos;


	@Override
	public ArrayList<Zoo> findAll()
	{
		ArrayList<Zoo> list = new ArrayList<>();
		zoorepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Zoo findZooByname(String name) throws EntityNotFoundException
	{
		Zoo zoo = zoorepos.findByZooname(name);

		if(zoo == null)
		{
			throw new EntityNotFoundException("Zoo " + name + " not found");
		}

		return zoo;
	}

	@Transactional
	@Override
	public void delete(long id) throws EntityNotFoundException
	{
		if (zoorepos.findById(id).isPresent())
		{
			zoorepos.deleteZooFromZooAnimals(id);
			zoorepos.deleteById(id);
		} else {
			throw new EntityNotFoundException(Long.toString(id));
		}
	}

	@Override
	public void deleteAnimal(long zooid, long animalid)
	{

	}

	@Transactional
	@Override
	public Zoo update(Zoo zoo, long id)
	{
		Zoo currentZoo = zoorepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
		if (zoo.getZooname() != null)
		{
			currentZoo.setZooname(zoo.getZooname());
		}

		if (zoo.getAnimals().size() > 0)
		{
			for (Animal a : zoo.getAnimals())
			{
				currentZoo.getAnimals().add(new Animal(a.getAnimaltype()));
			}
		}

		return zoorepos.save(currentZoo);
	}

	@Transactional
	@Override
	public Zoo save(Zoo zoo)
	{
		Zoo newZoo = new Zoo();

		newZoo.setZooname(zoo.getZooname());

		for (Animal a : zoo.getAnimals())
		{
			newZoo.getAnimals().add(new Animal(a.getAnimaltype()));
		}

		for (Telephone t : zoo.getTelephones())
		{
			newZoo.getTelephones().add(new Telephone(t.getPhonetype(), t.getPhonenumber()));
		}

		return zoorepos.save(newZoo);
	}
}