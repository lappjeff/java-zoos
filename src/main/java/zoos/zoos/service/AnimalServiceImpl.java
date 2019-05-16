package zoos.zoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoos.zoos.model.Animal;
import zoos.zoos.repo.AnimalRepository;
import zoos.zoos.view.CountZoosWithAnimals;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class AnimalServiceImpl implements AnimalService
{
	@Autowired
	private AnimalRepository animalRepository;

	@Override
	public ArrayList<Animal> findAll()
	{
		ArrayList<Animal> animals = new ArrayList<>();
		animalRepository.findAll().iterator().forEachRemaining(animals::add);
		return animals;
	}

	@Override
	public ArrayList<Animal> findAnimalByName(String name) throws EntityNotFoundException
	{
		ArrayList<Animal> animals = animalRepository.getAnimalByAnimaltype(name);

		if (animals.size() == 0)
		{
			throw new EntityNotFoundException("Animal " + name + " not found");
		}

		return animals;
	}

	@Override
	public ArrayList<CountZoosWithAnimals> getCountZoosWithAnimals()
	{
		return animalRepository.getCountZoosWithAnimals();
	}
}
