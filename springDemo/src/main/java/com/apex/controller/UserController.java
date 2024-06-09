
package com.apex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apex.beans.User;

@RestController
@RequestMapping("/user")
public class UserController {

	public UserController() {
		System.out.println("UserController loaded");
	}

	@GetMapping("/message")
	public String getDemo() {
		return "Welcome to SpringBoot Demo";
	}

	@GetMapping
	public List<User> getUser() {
		User user1 = new User();
		user1.setName("Ram");
		user1.setAge(30);
		user1.setAddress("CA");

		User user2 = new User();
		user2.setName("hello");
		user2.setAge(35);
		user2.setAddress("SF");

		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		return users;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		System.out.println(user);
		return user;
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		System.out.println(user);
		return user;
	}

	@DeleteMapping
	public User deleteUser(@RequestParam("id") String id) {
		System.out.println("Delete ID: " + id);
		return new User();
	}
}
