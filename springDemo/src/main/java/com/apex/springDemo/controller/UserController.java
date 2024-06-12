
package com.apex.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apex.springDemo.beans.User;
import com.apex.springDemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("UserController loaded");
	}

	@GetMapping("/message")
	public String getDemo() {
		return "Welcome to SpringBoot Demo";
	}

	@GetMapping("/user")
	public User getUser(@RequestParam("id") int id) {
		return userService.getUser(id);
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		System.out.println(user);
		// Updating
		return user;
	}

	@DeleteMapping
	public String deleteUser(@RequestParam("id") int id) {
		return userService.deleteUser(id);
	}
}
