package com.p1demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1demo.model.User;
import com.p1demo.model.User.UserType;
import com.p1demo.repo.UserRepo;

import lombok.extern.log4j.Log4j;

@Service @Transactional @Log4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	public UserRepo getUserRepo() {
		return userRepo;
	}

	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@Override
	public User getUser(String username, String password) {
		// TODO Add log message!
		return userRepo.getUser(username, password);
	}

	@Override
	public User findUser(Integer userId) {
		// TODO Add log message!
		return userRepo.getById(userId);
	}

	@Override
	public User updateUser(User u) {
		// TODO Add log message!
		return userRepo.save(u);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Add log message!
		return userRepo.findAll();
	}

	@Override
	public List<User> getAllEmployees() {
		// TODO Add log message!
		ArrayList<User> list = new ArrayList<>();
		list.add(userRepo.findUserByType(UserType.EMPLOYEE));
		return list;
	}
	

}
