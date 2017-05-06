package loginGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loginGroup.entity.User;
import loginGroup.service.UserService;
import loginGroup.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserServiceImpl userServiceImpl) {
		this.userService = userServiceImpl;
	}
	
	@GetMapping(path="/getuser",produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<User> listUsers() {
		return userService.listAllUser();	
	}
	
	@PostMapping(path="/postuser",consumes=MediaType.APPLICATION_JSON_VALUE)
	void newUser(@RequestBody User newUser) {
		userService.newUser(newUser);
	}
	
	@GetMapping(path="/getoneuser/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	User showOne(@PathVariable long id) {
		return userService.findUser(id);
	}
	
}
