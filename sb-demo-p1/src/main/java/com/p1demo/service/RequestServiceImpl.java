package com.p1demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.p1demo.model.Request;
import com.p1demo.model.Request.Status;
import com.p1demo.repo.RequestRepo;

import lombok.extern.log4j.Log4j;

@Service @Transactional @Log4j 
public class RequestServiceImpl implements RequestService{

	@Autowired
	private final RequestRepo requestRepo;
	
	public RequestRepo getRequestRepo() {
		return requestRepo;
	}
	

	public RequestServiceImpl(RequestRepo requestRepo) {
		super();
		this.requestRepo = requestRepo;
	}


	@Override
	public Request createRequest(Request r) {
		// TODO Add log message!
		return requestRepo.save(r);
	}


	@Override
	public Request getRequestById(Integer reimbId) {
		// TODO Add log message!
		return requestRepo.getById(reimbId);
	}


	@Override
	public List<Request> getRequestsByStatus(Status status) {
		// TODO Add log message!
		//Collection<Request>
		return null;
	}


	@Override
	public List<Request> getAllRequests() {
		// TODO Add log message!
		return requestRepo.findAll();
	}


	@Override
	public List<Request> findRequestsByUser(Integer auth) {
		// TODO Add log message!
		return null;
	}


	@Override
	public Request updateRequest(Request r) {
		// TODO Add log message!
		return requestRepo.save(r);
	}


	@Override
	public Request approveOrDenyRequest(Request r) {
		/// TODO Add log message!
		return null;
	}


	@Override
	public boolean deleteRequest(Integer reimbId) {
		// TODO Add log message! ("Deleting reimbursement request by ID: {}")
		requestRepo.deleteById(reimbId);
		return true;
	}




}
