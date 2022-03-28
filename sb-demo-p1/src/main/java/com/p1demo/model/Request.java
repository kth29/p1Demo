package com.p1demo.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	
	public enum Status {
		PENDING, APPROVED, DENIED
	}
	
	public enum Type {
		LODGING, TRVALE, FOOD, OTHER
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(unique=true)
	private int reimbId;
	
	@Column
	private Type type;
	
	@Column
	private double amount;
	
	@Column
	private String descr;
	
	@Column
	private int auth;
	
	@Column
	private LocalDateTime submitted=LocalDateTime.now();
	
	@Column
	private int resolver;
	
	@Column
	private LocalDateTime resolved;
	
	@Column
	private Status status = Status.PENDING;
	
	@Column(name = "receipt")
	private String receiptUrl;

	//No-args constructor
	public Request() {
		super();
	}

	//All-args constructor
	public Request(int reimbId, Type type, double amount, String descr, int auth, LocalDateTime submitted, int resolver,
			LocalDateTime resolved, Status status, String receiptUrl) {
		super();
		this.reimbId = reimbId;
		this.type = type;
		this.amount = amount;
		this.descr = descr;
		this.auth = auth;
		this.submitted = submitted;
		this.resolver = resolver;
		this.resolved = resolved;
		this.status = status;
		this.receiptUrl = receiptUrl;
	}

//Required args constructor for new requests
	public Request(Type type, double amount, int auth, LocalDateTime submitted) {
		super();
		this.type = type;
		this.amount = amount;
		this.auth = auth;
		this.submitted = submitted;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public LocalDateTime getSubmitted() {
		return submitted;
	}

	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public LocalDateTime getResolved() {
		return resolved;
	}

	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getReceiptUrl() {
		return receiptUrl;
	}

	public void setReceiptUrl(String receiptUrl) {
		this.receiptUrl = receiptUrl;
	}

	@Override
	public String toString() {
		return "Request [reimbId=" + reimbId + ", type=" + type + ", amount=" + amount + ", descr=" + descr + ", auth="
				+ auth + ", submitted=" + submitted + ", resolver=" + resolver + ", resolved=" + resolved + ", status="
				+ status + ", receiptUrl=" + receiptUrl + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, auth, descr, receiptUrl, reimbId, resolved, resolver, status, submitted, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && auth == other.auth
				&& Objects.equals(descr, other.descr) && Objects.equals(receiptUrl, other.receiptUrl)
				&& reimbId == other.reimbId && Objects.equals(resolved, other.resolved) && resolver == other.resolver
				&& status == other.status && Objects.equals(submitted, other.submitted) && type == other.type;
	}
	
	

}
