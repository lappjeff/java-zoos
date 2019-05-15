package zoos.zoos.service;

import zoos.zoos.model.Zoo;

import java.util.ArrayList;

public interface ZooService
{
	ArrayList<Zoo> findAll();


	Zoo findZooByname(String name);

	void delete(long id);

	Zoo update(Zoo zoo, long id);

	Zoo save(Zoo zoo);
}
