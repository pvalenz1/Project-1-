package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Reimbursement;
import models.User;
import util.ConnectionFactory;

public class ReimbursementDAO implements DAO<Reimbursement> {

	@Override
	public Reimbursement getById(int reimb_id) {

		Reimbursement reimb = new Reimbursement();
		User user = new User();

		ArrayList<Reimbursement> reimbursement = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			if (conn != null) {

				String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";

				PreparedStatement pstate = conn.prepareStatement(sql);
				pstate.setInt(1, reimb_id);
				ResultSet rs = pstate.executeQuery();

				while (rs.next()) {

				}
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amt(rs.getDouble("reimb_amt"));
				reimb.setReimb_desc(rs.getString("reimb_desc"));
				reimb.setReimb_receipt(rs.getLong("reimb_receipt"));
				reimb.setReimb_sub(rs.getDate("reimb_sub"));
				reimb.setReimb_author(rs.getInt("reimb_author"));
				reimb.setReimb_resolver(rs.getInt("reimb_resolver"));
				reimb.setReimb_typeid(rs.getInt("reimb_typeid"));
				reimb.setReimb_statusid(rs.getInt("reimb_statusid"));

				reimbursement.add(reimb);
			} else {
				throw new SQLException("Connection not detected");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return reimb;
//
//        private static java.sql.Date getCurrentDate(){
//        	
//        	java.util.Date today = new java.util.Date();
//        	return new java.sql.Date(today.getDate())
//        }
//        		

	}

	@Override
	public List<Reimbursement> getAll() {  // <-------------------------------
		return null;
	}

	@Override
	public Reimbursement add(Reimbursement reimb) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			User user = new User();

			PreparedStatement pstate = conn.prepareStatement(
					"INSERT INTO chrisomar.ers_reimbursement VALUES (2, ?, ?, ?, ?, null, 1, ?)",
					new String[] { "reimb_id" });

			// pstmt.setInt(1, reimb.getReimbID());
			pstate.setDouble(1, reimb.getReimb_amt());
			pstate.setDate(2, getDate()); // <------------------------------
			pstate.setString(3, reimb.getReimb_desc());
			pstate.setInt(4, reimb.getReimb_author());
			pstate.setInt(5, reimb.getReimb_typeid());

			if (pstate.executeUpdate() != 0) {

				// Retrieve the generated primary key for the newly added user
				ResultSet rs = pstate.getGeneratedKeys();

				while (rs.next()) {
					reimb.setReimb_id(rs.getInt(1));
				}
				conn.commit();
			}

		} catch (SQLIntegrityConstraintViolationException sicve) {
//			log.error(sicve.getMessage()); // <---------------------------------
//			log.warn("Username already taken.");
		} catch (SQLException e) {
//			log.error(e.getMessage()); // <---------------------------------
		}

		return reimb;

	}

	@Override
	public Reimbursement update(Reimbursement updatedObj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUSID = ? WHERE REIMB_ID = ?";

			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setInt(1, updatedObj.getReimb_statusid());
			pstate.setInt(2, updatedObj.getReimb_id());

			int rowsUpdated = pstate.executeUpdate();

			if (rowsUpdated != 0) {
				conn.commit();
			}
			return updatedObj;
		} catch (SQLIntegrityConstraintViolationException sicve) {
			System.out.print("INVALID - Username already taken");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public List<Reimbursement> getAll() {   //<-----------------------------

		ArrayList<Reimbursement> reimbursements = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM ERS_REIMBURSEMENT";

			PreparedStatement prepState = conn.prepareStatement(sql);

			ResultSet rs = prepState.executeQuery();

			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();

				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amt(rs.getDouble("reimb_amt"));
				reimb.setReimb_desc(rs.getString("reimb_desc"));
				reimb.setReimb_receipt(rs.getLong("reimb_receipt"));
				reimb.setReimb_sub(rs.getDate("reimb_sub"));
				reimb.setReimb_author(rs.getInt("reimb_author"));
				reimb.setReimb_resolver(rs.getInt("reimb_resolver"));
				reimb.setReimb_typeid(rs.getInt("reimb_typeid"));
				reimb.setReimb_statusid(rs.getInt("reimb_statusid"));

				reimbursements.add(reimb);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		System.out.println(reimbursements);
		return reimbursements;
	}
}
