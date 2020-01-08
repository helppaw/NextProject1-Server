package com.revature.daos;

import java.util.List;

import com.revature.models.Results;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import com.revature.util.ConnectionUtil;

public class ResultsDaoSQL implements ResultsDao {
	
	Results extractResults(ResultSet rs) throws SQLException {
		int resultsId = rs.getInt("results_id");
		String quizName = rs.getString("name");
		int userId = rs.getInt("user_id");
		String firstname = rs.getString("firstname");
		String username = rs.getString("username");
		double grade = rs.getDouble("grade");
		return new Results(resultsId, grade, userId, firstname, username, quizName);
	}

	
	
		private static final String results_join = "SELECT *"
				+ " FROM QUIZES q INNER JOIN ASSIGNED_USER_QUIZ auq"
				+ " ON q.quiz_id = auq.quiz_id"
				+ " RIGHT JOIN USERS u"
				+ " ON auq.user_id = u.user_id"
				+ " INNER JOIN RESULTS r"
				+ " ON r.quiz_id = auq.quiz_id"
				+ " AND r.user_id = u.user_id"
				+ " WHERE u.role = 2";
		
		
	
		private static final String results_specific = "SELECT *"
				+ " FROM QUIZES q INNER JOIN ASSIGNED_USER_QUIZ auq"
				+ " ON q.quiz_id = auq.quiz_id"
				+ " RIGHT JOIN USERS u"
				+ " ON auq.user_id = u.user_id"
				+ " INNER JOIN RESULTS r"
				+ " ON r.quiz_id = auq.quiz_id"
				+ " AND r.user_id = u.user_id"
				+ " WHERE u.role = 2 AND u.user_id = ?";
		
				
		

	
	
	
	@Override
	public int save(Results r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Results r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Results> findAll() {
		try (Connection c = ConnectionUtil.getConnection()) {

			PreparedStatement ps = c.prepareStatement(results_join);

			ResultSet rs = ps.executeQuery();
			List<Results> results = new ArrayList<>();
			while (rs.next()) {
				results.add(extractResults(rs));
			}

			return results;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public List<Results> findByStudentId(int userId) {
	try (Connection c = ConnectionUtil.getConnection()) {
			
			

			PreparedStatement ps = c.prepareStatement(results_specific);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			List<Results> results = new ArrayList<>();
			while (rs.next()) {
				results.add(extractResults(rs));
			}

			return results;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
// same as above... was supposed to be for just one though
	@Override
	public List<Results> findById(int userId) {
	try (Connection c = ConnectionUtil.getConnection()) {
			
			

			PreparedStatement ps = c.prepareStatement(results_specific);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			List<Results> results = new ArrayList<>();
			while (rs.next()) {
				results.add(extractResults(rs));
			}

			return results;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

	
	


	



	

	