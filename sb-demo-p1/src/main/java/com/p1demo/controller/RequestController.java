package com.p1demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p1demo.model.Request;
import com.p1demo.model.Request.Status;
import com.p1demo.service.RequestService;

@RestController
@RequestMapping("/reimbursements")
public class RequestController {

	@Autowired
	RequestService rserv;

	@PostMapping
    public ResponseEntity<Request> submitRequest(@RequestBody Request r) {
        try {
        	Request newReq = rserv.createRequest(r);
            return new ResponseEntity<>(newReq, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


	@GetMapping("/{status}")
	public ResponseEntity<Request> getRequestByStatus(@PathVariable("status") Status status) {
		try {
			List<Request> list = new ArrayList<>();
			rserv.getRequestsByStatus(status).forEach(list::add);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/{reimbId}")
	public ResponseEntity<Request> getRequestById(@PathVariable("reimbId") int reimbId) {
		Optional<Request> existingOptionalItem = Optional.of(rserv.getRequestById(reimbId));
		
		if (existingOptionalItem.isPresent()) {
			return new ResponseEntity<>(existingOptionalItem.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}


	@GetMapping("/all")
	public ResponseEntity<Request> getAllRequests() {
		try {
			List<Request> list = new ArrayList<Request>();
			rserv.getAllRequests().forEach(list::add);
			
			if(list.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/{auth}/all")
	public ResponseEntity<Request> findRequestsByUser(@PathVariable("auth") int auth) {
		Optional<Request> existingOptionalItem = Optional.of(rserv.getRequestById(auth));
		
		if (existingOptionalItem.isPresent()) {
			return new ResponseEntity<>(existingOptionalItem.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	


	@PutMapping("/{id}/approve")
	public ResponseEntity<Request> approveOrDenyRequest(@PathVariable("reimbId") int reimbId, @RequestBody Status status) {
		Request r = rserv.getRequestById(reimbId);
		r.setStatus(status);
		Optional<Request> updatedReq = Optional.of(r);
	
		if(updatedReq.isPresent()) {
			return new ResponseEntity<>(rserv.updateRequest(r), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@DeleteMapping("/{id}/delete")
	public ResponseEntity<HttpStatus> deleteRequest(@PathVariable("reimbId") int reimbId) {
		rserv.deleteRequest(reimbId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
