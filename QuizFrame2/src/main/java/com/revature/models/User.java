package com.revature.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Serializable {
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private int role;
	
	
	

	// allow jackson to convert passwords in json to the java object
	// but don't allow it to convert the password in object to json

	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

	private int active;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}







	public User(int userId, String username, String password, String firstname, String lastname, int role, int active) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.active = active;
	}







	public int getUserId() {
		return userId;
	}







	public void setUserId(int userId) {
		this.userId = userId;
	}







	public String getFirstname() {
		return firstname;
	}







	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}







	public String getLastname() {
		return lastname;
	}







	public void setLastname(String lastname) {
		this.lastname = lastname;
	}







	public int getRole() {
		return role;
	}







	public void setRole(int role) {
		this.role = role;
	}







	public int getActive() {
		return active;
	}







	public void setActive(int active) {
		this.active = active;
	}







	public int getErsUserId() {
		return userId;
	}



	public void setErsUserId(int ersUserId) {
		this.userId = ersUserId;
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



	public String getUserFirstName() {
		return firstname;
	}



	public void setUserFirstName(String userFirstName) {
		this.firstname = userFirstName;
	}



	public String getUserLastName() {
		return lastname;
	}



	public void setUserLastName(String userLastName) {
		this.lastname = userLastName;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", role=" + role + ", active=" + active + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
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
		if (active != other.active)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}