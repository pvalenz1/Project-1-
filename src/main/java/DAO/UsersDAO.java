package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import models.User;
import util.ConnectionFactory;

public class UsersDAO implements DAO<User>{
    
	@Override
	public List<User> getAll() {
		User User = new User();
		ArrayList<User> users = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM ERS_USERS";

			PreparedStatement pstate = conn.prepareStatement(sql);

			ResultSet rs = pstate.executeQuery();

			while(rs.next()) {

				User.setUsers_id(rs.getInt("USERS_ID"));
				User.setUsername(rs.getString("USERNAME"));
				User.setU_password(rs.getString("U_PASSWORD"));
				User.setU_firstname(rs.getString("U_FIRSTNAME"));
				User.setU_lastname(rs.getString("U_LASTNAME"));
				User.setU_email(rs.getString("U_EMAIL"));
				User.setU_roleid(rs.getInt("U_ROLEID"));
				users.add(User);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return users;
	}

	@Override
	public User getById(int id) {
		User User = new User();
		ArrayList<User> users = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM USERS WHERE USERS_ID = ?";

			PreparedStatement pstate = conn.prepareStatement(sql);

			pstate.setInt(1, id);

			ResultSet rs = pstate.executeQuery();

			while(rs.next()) {
				User.setUsers_id(rs.getInt("USERS_ID"));
				User.setUsername(rs.getString("USERNAME"));
				User.setU_password(rs.getString("U_PASSWORD"));
				User.setU_firstname(rs.getString("U_FIRSTNAME"));
				User.setU_lastname(rs.getString("U_LASTNAME"));
				User.setU_email(rs.getString("U_EMAIL"));
				User.setU_roleid(rs.getInt("U_ROLEID"));
				users.add(User);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(User.getUsers_id() == 0) return null;

		return User;
	}


	public User getByCredentials(String username, String password) {
		User user = new User();
		//User users = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement pstate = conn.prepareStatement("SELECT * FROM ERS_USERS "
					+ "JOIN ERS_USER_ROLE ON ERS_USERS.U_ROLEID = ERS_USER_ROLE.USER_ROLE_ID WHERE "
					+ "USERNAME = ? AND U_PASSWORD = ?");
			pstate.setString(1, username);
			pstate.setString(2, password);

			ResultSet rs = pstate.executeQuery();

			while(rs.next()) {
				
		
				user.setUsers_id(rs.getInt("USERS_ID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setU_password(rs.getString("U_PASSWORD"));
				user.setU_firstname(rs.getString("U_FIRSTNAME"));
				user.setU_lastname(rs.getString("U_LASTNAME"));
				user.setU_email(rs.getString("U_EMAIL"));
				user.setU_roleid(rs.getInt("U_ROLEID"));
				
			}
		
		} catch (SQLException e) {
//			log.error(e.getMessage());  <----------------------
		}
		
		System.out.println(user + " line 109 UsersDAO");
		return user;
	}

	@Override
	public User add(User newUser) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			PreparedStatement pstate = conn.prepareStatement("INSERT INTO ERS_USERS VALUES (0, ?, ?, ?, ?, ?, 2)", new String[] {"USERS_ID"});
			
			pstate.setString(1, newUser.getUsername());
			pstate.setString(2, newUser.getU_password());
			pstate.setString(3, newUser.getU_firstname());
			pstate.setString(4, newUser.getU_lastname());
			pstate.setString(5, newUser.getU_email());
			

			if(pstate.executeUpdate() != 0) {

				// Retrieve the generated primary key for the newly added user
				ResultSet rs = pstate.getGeneratedKeys();


				while(rs.next()) {
					newUser.setUsers_id(rs.getInt(1));
//					newUser.setU_roleid(new Role(3));    //  <-------------------------
				}
				conn.commit();
		}
		} catch (SQLIntegrityConstraintViolationException sicve) {
//			log.error(sicve.getMessage());    //  <-----------------------------
//			log.warn("Username already taken.");
		} catch (SQLException e) {
//			log.error(e.getMessage());
		}

		return newUser;
		}
	
	@Override
	public User update(User updatedUser) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "UPDATE ERS_USERS SET USERNAME = ?, U_PASSWORD = ?, U_FIRSTNAME = ?, U_LASTNAME = ?, U_EMAIL = ?, U_ROLEID = ? WHERE USERS_ID = ?";

			PreparedStatement pstate = conn.prepareStatement(sql);
		
			pstate.setString(1, updatedUser.getUsername());
			pstate.setString(2, updatedUser.getU_password());
			pstate.setString(3, updatedUser.getU_firstname());
			pstate.setString(4, updatedUser.getU_lastname());
			pstate.setString(5, updatedUser.getU_email());
			pstate.setInt(6, updatedUser.getU_roleid());

			int rowsUpdated = pstate.executeUpdate();

			if (rowsUpdated != 0) {
				conn.commit();
				return updatedUser;
			}

		} catch (SQLException e) {
//			log.error(e.getMessage());    <----------------------
		}

		return null;
	}

	@Override
	public boolean delete(int users_id) {

		User User = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement pstate = conn.prepareStatement("DELETE FROM ers_users WHERE ers_users_id = ?");
			pstate.setInt(1, users_id);

			if (pstate.executeUpdate() == 0) return false;

		} catch (SQLException e) {
//			log.error(e.getMessage());  // <----------------------------
		}

		return true;
	}
   
        
}
