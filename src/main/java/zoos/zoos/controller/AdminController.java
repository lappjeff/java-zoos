package zoos.zoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zoos.zoos.model.Zoo;
import zoos.zoos.service.ZooService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController
{
	@Autowired
	private ZooService zooService;

	//localhost:2018/admin/zoos/zooid
	@PutMapping(value = "/zoos/{zooid}", consumes = {"application/json"})
	public ResponseEntity<?> updateZoo(@RequestBody
											   Zoo updateZoo, @PathVariable long zooid)
	{
		zooService.update(updateZoo, zooid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//localhost:2018/admin/zoos/{id}
	@DeleteMapping(value = "/zoos/{zooid}")
	public ResponseEntity<?> deleteZooById(@PathVariable long zooid)
	{
		zooService.delete(zooid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
