package zoos.zoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoos.zoos.service.AnimalService;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController
{

	@Autowired
	private AnimalService animalService;

	//localhost:2018/animals/all
	@GetMapping(value = "/all", produces = {"application/json"})
	public ResponseEntity<?> getAllAnimals()
	{
		return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);
	}
}
