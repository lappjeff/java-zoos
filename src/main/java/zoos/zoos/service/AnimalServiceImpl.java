package zoos.zoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoos.zoos.model.Animal;
import zoos.zoos.repo.AnimalRepository;
import zoos.zoos.view.CountZoosWithAnimals;

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
	public Animal findAnimalByName(String name)
	{
		return null;
	}

	@Override
	public ArrayList<CountZoosWithAnimals> getCountZoosWithAnimals()
	{
		return null;
	}
}
