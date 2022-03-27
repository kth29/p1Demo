package com.p1demo.service;

import java.util.List;

import com.p1demo.model.Request;
import com.p1demo.model.Request.Status;

public interface RequestService {
	
	//submit new request
	public Request createRequest(Request r);
	
	//Fetch request by ID
	public Request getRequestById(Integer reimbId);
	
	//Fetch requests by status. Add an if/else to filter by user ID?
	public List<Request> getRequestsByStatus (Status status);
	
	//Fetch all requests
	public List<Request> getAllRequests();
	
	//Fetch requests made by a specific user
	public List<Request> findRequestsByUser(Integer auth);
	
	//Update any request info and save
	public Request updateRequest(Request r);
	
	//for Managers to change a request's status
	public Request approveOrDenyRequest(Request r);
	
	/**
	 * ADDITIONAL FUNCTIONALITY!! For users, mainly employees, to delete any submitted requests
	 * @param r
	 * @return
	 */
	public boolean deleteRequest(Integer reimbId);

}
