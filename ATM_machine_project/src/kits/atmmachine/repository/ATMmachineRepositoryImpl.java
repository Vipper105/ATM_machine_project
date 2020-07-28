package kits.atmmachine.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.config.ConnectionFactory;
import kits.atmmachine.entity.ATMmachine;

public class ATMmachineRepositoryImpl implements ATMmachineRepository {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public void addATM(ATMmachine machine) {
		String queryString = "INSERT INTO atmmachine value(?,?,?)";

		try {
			connection = getConnection();

			stmt = (PreparedStatement) connection.prepareStatement(queryString);

			stmt.setInt(1, machine.getMachineID());
			stmt.setString(2, machine.getMachineName());
			stmt.setInt(3, machine.getLocationID());

			stmt.executeUpdate();
			connection.close();
			System.out.println("Bạn đã add ATM machine thành công!");

		} catch (Exception e) {
			System.out.println("Add ATM machine thất bại.");
			e.printStackTrace();
		}

	}

	@Override
	public List<ATMmachine> findAllATM() {
		List<ATMmachine> lsATM = new ArrayList<ATMmachine>();
		String queryString = "SELECT * FROM atmmachine";

		try {
			connection = getConnection();

			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); // Select

			while (rs.next()) {
				ATMmachine atm = new ATMmachine();
				// Lấy giá trị từ cột DB tương ứng set giá trị cho đối tượng
				atm.setMachineID(rs.getInt("machineID"));
				atm.setMachineName(rs.getString("machineName"));
				atm.setLocationID(rs.getInt("locationID"));

				lsATM.add(atm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return lsATM;
	}

	@Override
	public void deleteATM(int machineID) {
		String queryString = "DELETE FROM atmmachine WHERE machineID='" + machineID + "'";

		try {

			connection = getConnection();

			stmt = connection.prepareStatement(queryString);

			stmt.executeUpdate();
			connection.close();
			System.out.println("Xóa ATM machine thành công");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ATM machine chưa được xóa");
			e.printStackTrace();
		}

	}

	@Override
	public void updateATM(ATMmachine atm) {
		String queryString = "UPDATE atmmachine SET machineName=?, locationID=? WHERE machineID=?";

		try {
			connection = getConnection();
			stmt = (PreparedStatement) connection.prepareStatement(queryString);

			stmt.setString(1, atm.getMachineName());
			stmt.setInt(2, atm.getLocationID());

			stmt.setInt(3, atm.getMachineID());

			stmt.executeUpdate();
			connection.close();

			System.out.println("ATM machine is updated successfully");
		} catch (Exception e) {
			System.out.println("ATM machine is updated fail");
			e.printStackTrace();
		}

	}

	@Override
	public ATMmachine findATMById(int machineID) {

		String queryString = "SELECT * FROM atmmachine WHERE machineID='" + machineID + "'";
		ATMmachine atm = new ATMmachine();
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery();

			while (rs.next()) {
				atm.setMachineID(rs.getInt("machineID"));
				atm.setMachineName(rs.getString("machineName"));
				atm.setLocationID(rs.getInt("locationID"));

			}

			connection.close();
			System.out.println("Account is found");
		} catch (Exception e) {
			System.out.println("ATM is not found");
			e.printStackTrace();
		}

		return atm;
		
		
	}

}
