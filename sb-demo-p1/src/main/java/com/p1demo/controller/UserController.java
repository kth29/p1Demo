package com.p1demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p1demo.model.User;
import com.p1demo.service.UserService;

@RestController
public class UserController {
//holds method handlers

	@Autowired
	UserService userv;
	
	@GetMapping("/users/login")
	public User getUser(@PathVariable String username, @PathVariable String password) {
		return userv.getUser(username, password);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getById(@PathVariable("userId") int userId) {
		Optional<User> existingItemOptional = Optional.of(userv.findUser(userId));
		
		if (existingItemOptional.isPresent()) {
			return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<User> update(@PathVariable("userId") int userId, @RequestBody User item) {
		Optional<User> existingItemOptional = Optional.of(userv.findUser(userId));
		if (existingItemOptional.isPresent()) {
			User existingitem = existingItemOptional.get();
			System.out.println("Developer Message: Update logic is unique to entity. Implement manually.");
			return new ResponseEntity<>(userv.updateUser(existingitem), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		try {
			List<User> items = new ArrayList<User>();
			userv.findAllUsers().forEach(items::add);
			
			if(items.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/employees")
	public ResponseEntity<User> getAllEmployees() {
		try {
				List<User> list = new ArrayList<User>();
				userv.getAllEmployees().forEach(list::add);
				
				if(list.isEmpty())
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/index")
	public User logout() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/users/{username}")
	public User viewUser(@PathVariable("username") String username) {
		// TODO Auto-generated method stub
		return userv.viewUser(username);
	}

	// display Employee homepage

//	public String viewEmpHomePage() {
//		return null;
//	}
//
//	// display
//	public String viewManHomePage() {
//		return null;
//	}

}
