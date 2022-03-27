package com.p1demo.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.experimental.SuperBuilder;


@SuperBuilder
@JsonInclude(Include.NON_NULL)
public class Message {
	
	protected LocalDateTime timestamp;
	
	protected int statusCode;
	
	protected HttpStatus status;
	
	//Null in the case of successful HTTP status. Non-null in case of error.
	protected String reason;
	
	protected String message;
	
	//Null in the case of successful HTTP status. Non-null in case of error.
	protected String devMessage;
	
	
	

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Message(LocalDateTime timestamp, int statusCode, HttpStatus status, String reason, String message,
			String devMessage, Map<?, ?> data) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.status = status;
		this.reason = reason;
		this.message = message;
		this.devMessage = devMessage;
	}



	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}



	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}



	public void setStatus(HttpStatus status) {
		this.status = status;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setDevMessage(String devMessage) {
		this.devMessage = devMessage;
	}



	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

	public String getMessage() {
		return message;
	}

	public String getDevMessage() {
		return devMessage;
	}


	@Override
	public String toString() {
		return "Message [timestamp=" + timestamp + ", statusCode=" + statusCode + ", status=" + status + ", reason="
				+ reason + ", message=" + message + ", devMessage=" + devMessage + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(devMessage, message, reason, status, statusCode, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(devMessage, other.devMessage)
				&& Objects.equals(message, other.message) && Objects.equals(reason, other.reason)
				&& status == other.status && statusCode == other.statusCode
				&& Objects.equals(timestamp, other.timestamp);
	}
	
	

}
