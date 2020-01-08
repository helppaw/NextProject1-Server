package com.revature.models;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class QuizJoin implements Serializable {
	private String quizName;
	private int userId;
	private String firstname;
	public QuizJoin(String quizName, int userId, String firstname, String lastname) {
		super();
		this.quizName = quizName;
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	private String lastname;

	public QuizJoin() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((quizName == null) ? 0 : quizName.hashCode());
		result = prime * result + userId;
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
		QuizJoin other = (QuizJoin) obj;
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
		if (quizName == null) {
			if (other.quizName != null)
				return false;
		} else if (!quizName.equals(other.quizName))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [quizName=" + quizName + ", userId=" + userId + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
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

	


	}
