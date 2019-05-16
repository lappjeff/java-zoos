package zoos.zoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zoos.zoos.model.User;
import zoos.zoos.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController
{
	@Autowired
	private UserService userService;

	//localhost:2018/users/add
	@PostMapping(value = "/add",
				 consumes = {"application/json"},
				 produces = {"application/json"})
	public ResponseEntity<?> addUser(@Valid @RequestBody User newUser)
	{
		newUser = userService.save(newUser);

		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	//localhost:2018/users/viewall
	@GetMapping(value = "/viewall", produces = {"application/json"})
	public ResponseEntity<?> listAllUsers()
	{
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	//localhost:2018/users/delete/userid
	@DeleteMapping(value = "/delete/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable long userid)
	{
		userService.delete(userid);

		return new ResponseEntity<>(HttpStatus.OK);
	}



}
