package zoos.zoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoos.zoos.model.Zoo;
import zoos.zoos.repo.ZooRepository;

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
	public Zoo findZooByname(String name)
	{
		return null;
	}

	@Override
	public void delete(long id)
	{

	}

	@Override
	public Zoo update(Zoo zoo, long id)
	{
		return null;
	}

	@Override
	public Zoo save(Zoo zoo)
	{
		return null;
	}
}