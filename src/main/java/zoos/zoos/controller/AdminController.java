package zoos.zoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import zoos.zoos.model.Zoo;
import zoos.zoos.service.ZooService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

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

	//localhost:2018/admin/zoos
	@PostMapping(value = "/zoos", produces = {"application/json"}, consumes = {"application/json"})
	public ResponseEntity<?> addNewZoo(@Valid @RequestBody Zoo newZoo) throws URISyntaxException
	{
		newZoo = zooService.save(newZoo);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{zooname}").
				buildAndExpand(newZoo.getZooname()).toUri();
		responseHeaders.setLocation(newZooURI);

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	//localhost:2018/admin/zoos/{id}
	@DeleteMapping(value = "/zoos/{zooid}")
	public ResponseEntity<?> deleteZooById(@PathVariable long zooid)
	{
		zooService.delete(zooid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
