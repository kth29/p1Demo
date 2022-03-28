package com.p1demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1demo.model.User;
import com.p1demo.model.User.UserType;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User getUser(String username, String password);
	
	public User findUserByType(UserType type);
	
	public User viewUser(String username);
	
	

}
