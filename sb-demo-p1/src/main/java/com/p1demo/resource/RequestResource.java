package com.p1demo.resource;

import java.security.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p1demo.model.Message;
import com.p1demo.service.RequestService;
import com.p1demo.service.RequestServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
//Class for returning messages to the user when they interact with the application
public class RequestResource {
	
	/**private final RequestServiceImpl rserv;
	
	public ResponseEntity<Message> getAllRequests(){
	
		
		return ResponseEntity.ok(
				Message
				
				Message message = new Message();
				message.setTimestamp(LocalDateTime.now());
				message.setMessage("All requests retrieved");
				message.setStatus(HttpStatus.OK);
				message.setStatusCode(HttpStatus.OK.value());
		
	} */


}
