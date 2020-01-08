package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.QuizJoin;

import com.revature.util.ConnectionUtil;

public class QuizJoinDaoSQL implements QuizJoinDao {

	// getting all quizes for the manager
	private static final String quiz_user_join = "SELECT *"
			+ " FROM QUIZES q INNER JOIN ASSIGNED_USER_QUIZ auq"
			+ " ON q.quiz_id = auq.quiz_id"
			+ " RIGHT JOIN USERS u"
			+ " ON auq.user_id = u.user_id"
			+ " WHERE u.role = 2";
	
	
	// getting quizes only for the student
	private static final String quiz_user_specific = "SELECT *"
			+ " FROM QUIZES q INNER JOIN ASSIGNED_USER_QUIZ auq"
			+ " ON q.quiz_id = auq.quiz_id"
			+ " RIGHT JOIN USERS u"
			+ " ON auq.user_id = u.user_id"
			+ " WHERE u.role = 2 AND u.user_id = ?";
	
	
//	private String selectStatement = "SELECT * FROM ers_reimbursement";
//
//
	QuizJoin extractQuizJoin(ResultSet rs) throws SQLException {
		String quizName = rs.getString("name");
		int userId = rs.getInt("user_id");
		String firstname = rs.getString("firstname");
		String lastname = rs.getString("lastname");
		return new QuizJoin(quizName, userId, firstname, lastname);
	}

//	}

	@Override
	public int save(QuizJoin r) {
return 0;
	}
	@Override
	public List<QuizJoin> findAll() {
		try (Connection c = ConnectionUtil.getConnection()) {
//		
			PreparedStatement ps = c.prepareStatement(quiz_user_join);

			ResultSet rs = ps.executeQuery();
			List<QuizJoin> reimbursements = new ArrayList<>();
			while (rs.next()) {
				reimbursements.add(extractQuizJoin(rs));
			}

			return reimbursements;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<QuizJoin> findByAuthorId(int reimbAuthor) {
		try (Connection c = ConnectionUtil.getConnection()) {
			
			

			PreparedStatement ps = c.prepareStatement(quiz_user_specific);

			ps.setInt(1, reimbAuthor);

			ResultSet rs = ps.executeQuery();

			List<QuizJoin> reimbursements = new ArrayList<>();
			while (rs.next()) {
				reimbursements.add(extractQuizJoin(rs));
			}

			return reimbursements;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<QuizJoin> findByStatusId(int reimbStatusId) {
		try (Connection c = ConnectionUtil.getConnection()) {
	
			String sql = "SELECT * FROM ers_reimbursement " + "WHERE reimb_status_id = ? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, reimbStatusId);

			ResultSet rs = ps.executeQuery();
			List<QuizJoin> reimbList = new ArrayList<QuizJoin>();
			while (rs.next()) {
				reimbList.add(extractQuizJoin(rs));
			} 
				return reimbList;
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public QuizJoin findById(int reimbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release(int pokemonId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<QuizJoin> findByAuthorName(String name) {

		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "Select * FROM ers_reimbursement r"
					+ "LEFT JOIN ers_reimbursement_type t ON (r.reimbursement_type = t.reimb_type) "
					+ "LEFT JOIN ers_users u ON (r.reimb_author = u.ers_user_id) " + "WHERE username = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			List<QuizJoin> reimbursement = new ArrayList<>();
			while (rs.next()) {
				reimbursement.add(extractQuizJoin(rs));
			}

			return reimbursement;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int update(QuizJoin r) {
		try (Connection c = ConnectionUtil.getConnection()) {

			/*
			 * UPDATE ers_reimbursement SET reimb_resolved = current_timestamp,
			 * reimb_status_id = 2, reimb_resolver = 3 WHERE reimb_id = 28;
			 */
			String sql = " UPDATE ers_reimbursement"
					+ " SET reimb_resolved = current_timestamp, reimb_status_id = ?, reimb_resolver = ?"
					+ " WHERE reimb_id = ?";

			CallableStatement cs = c.prepareCall(sql);

			System.out.println("im working...");
			return cs.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
