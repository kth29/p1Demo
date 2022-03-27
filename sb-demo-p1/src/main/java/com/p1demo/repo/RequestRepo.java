package com.p1demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1demo.model.Request;

public interface RequestRepo extends JpaRepository<Request, Integer>{
	
	

}
