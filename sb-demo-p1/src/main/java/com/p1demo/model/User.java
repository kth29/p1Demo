package com.p1demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	public enum UserType {
		EMPLOYEE("EMPLOYEE"), MANAGER("MANAGER");
		
		private final String utype;
		
		UserType(String utype) {
			this.utype = utype;
		}
		
		public String getUsertype() {
			return this.utype;
		}

	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(unique = true)
	private int userId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column(unique = true)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private UserType usertype;
	
//NO-ARGS constructor
	public User() {
		super();
	}

	//All-args constructor
public User(int userId, String firstName, String lastName, String email, String username, String password,
		UserType usertype) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.username = username;
	this.password = password;
	this.usertype = usertype;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public UserType getUsertype() {
	return usertype;
}

public void setUsertype(UserType usertype) {
	this.usertype = usertype;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", username=" + username + ", password=" + password + ", usertype=" + usertype + "]";
}

@Override
public int hashCode() {
	return Objects.hash(email, firstName, lastName, password, userId, username, usertype);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
			&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
			&& userId == other.userId && Objects.equals(username, other.username) && usertype == other.usertype;
}
	
	
	

}
