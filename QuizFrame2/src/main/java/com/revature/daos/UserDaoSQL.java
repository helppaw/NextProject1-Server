package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoSQL implements UserDao {

	User extractUser(ResultSet rs) throws SQLException {
		int rsUserId = rs.getInt("user_id");
		String rsUsername = rs.getString("username");
		String rsPassword = rs.getString("password");
		String rsFirstname = rs.getString("firstname");
		String rsLastname = rs.getString("lastname");
		int rsRole = rs.getInt("role");
		int rsActive = rs.getInt("active");
		return new User(rsUserId, rsUsername, rsPassword, rsFirstname, rsLastname, rsRole, rsActive);
	}

	@Override
	public int save(User u) {
		return 0;
	}

	@Override
	public List<User> findAll() {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
			users.add(extractUser(rs));
			}

			return users;

		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		}
	}

	public User findByUsernameAndPassword(String username, String password) {
		try (Connection c = ConnectionUtil.getConnection()) {

			Statement statement = c.createStatement();

			String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password
					+ "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				return extractUser(rs);
			} else {
				return null;
			}

		} catch (SQLException e) { 
			System.out.println("i got caught");
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findByUsername(String username) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE username = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			User u = null;
			if (rs.next()) {
				u = extractUser(rs);
			}

			return u;

		} catch (SQLException e) {
		
//			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findById(int ersUserId) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE user_id = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, ersUserId);

			ResultSet rs = ps.executeQuery();

			User u = null;
			if (rs.next()) {
				u = extractUser(rs);
			}

			return u;

		} catch (SQLException e) {
			
//			e.printStackTrace();
			return null;
		}
	}
}