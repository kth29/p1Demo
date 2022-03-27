package com.p1demo.service;

import java.util.List;

import com.p1demo.model.User;

public interface UserService {
	
	//Login method
	public User getUser(String username, String password);
	
	//Fetch specified user by ID
	public User findUser(Integer userId);
	
	//Update any user info
	public User updateUser(User u);
	
	//Fetch a list of all users
	public List<User> findAllUsers();
	
	//Fetch a list of users based on usertype
	public List<User> getAllEmployees();

}
