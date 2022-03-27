package com.p1demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p1demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
//holds method handlers

	@Autowired
	UserService userv;

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
