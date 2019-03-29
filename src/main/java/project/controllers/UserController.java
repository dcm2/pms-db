package project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project.service.UserService;
import project.entities.User;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

	protected static final String BASE_URL = "/pms_db/user";
	private UserService userService;
	
	//constructor for this controller class
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{userName}")
	public User findUserByName(@PathVariable String userName) {
		return userService.findByName(userName);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
}
