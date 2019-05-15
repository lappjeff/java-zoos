package zoos.zoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoos.zoos.service.ZooService;

@RestController
@RequestMapping(value = "/home")
public class ZooController
{
	@Autowired
	private ZooService zooService;

	//localhost:2018/home/zoos/all
	@GetMapping(value = "/zoos/all",
				produces = {"application/json"})
	public ResponseEntity<?> listAllZoos()
	{
		return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
	}
}