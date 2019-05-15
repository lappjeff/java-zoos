package zoos.zoos.service;

import zoos.zoos.model.Animal;
import zoos.zoos.view.CountZoosWithAnimals;

import java.util.ArrayList;

public interface AnimalService
{
	ArrayList<Animal> findAll();

	Animal findAnimalByName(String name);

	ArrayList<CountZoosWithAnimals> getCountZoosWithAnimals();
}
