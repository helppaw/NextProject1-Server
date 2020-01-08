package com.revature.models;

import java.io.Serializable;

public class Results implements Serializable {
		private int resultsId;
		private double grade;
		private int quizId;
		private String quizName;
		private String username;
		private String firstname;
	
		


		public Results() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Results(int resultsId, double grade, int quizId, String quizName, String username, String firstname) {
			super();
			this.resultsId = resultsId;
			this.grade = grade;
			this.quizId = quizId;
			this.quizName = quizName;
			this.username = username;
			this.firstname = firstname;
		}

		

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
			long temp;
			temp = Double.doubleToLongBits(grade);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + quizId;
			result = prime * result + ((quizName == null) ? 0 : quizName.hashCode());
			result = prime * result + resultsId;
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
			Results other = (Results) obj;
			if (firstname == null) {
				if (other.firstname != null)
					return false;
			} else if (!firstname.equals(other.firstname))
				return false;
			if (Double.doubleToLongBits(grade) != Double.doubleToLongBits(other.grade))
				return false;
			if (quizId != other.quizId)
				return false;
			if (quizName == null) {
				if (other.quizName != null)
					return false;
			} else if (!quizName.equals(other.quizName))
				return false;
			if (resultsId != other.resultsId)
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Results [resultsId=" + resultsId + ", grade=" + grade + ", quizId=" + quizId + ", quizName="
					+ quizName + ", username=" + username + ", firstname=" + firstname + "]";
		}

	

		public int getResultsId() {
			return resultsId;
		}

		public void setResultsId(int resultsId) {
			this.resultsId = resultsId;
		}

		public double getGrade() {
			return grade;
		}

		public void setGrade(double grade) {
			this.grade = grade;
		}

		public int getQuizId() {
			return quizId;
		}

		public void setQuizId(int quizId) {
			this.quizId = quizId;
		}

		public String getQuizName() {
			return quizName;
		}

		public void setQuizName(String quizName) {
			this.quizName = quizName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
}