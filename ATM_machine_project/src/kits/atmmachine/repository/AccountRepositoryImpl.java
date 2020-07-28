package kits.atmmachine.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.config.ConnectionFactory;
import kits.atmmachine.entity.Account;

public class AccountRepositoryImpl implements AccountRepository {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	// Lấy data từ DB set thuộc tính cho các đối tượng
	public List<Account> findAllAccount() {
		//
		List<Account> lsAccount = new ArrayList<Account>();
		String queryString = "SELECT * FROM account";

		try {
			connection = getConnection();

			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); // Select

			// Duyệt hết mỗi hàng => rồi lưu kết quả vào mảng
			while (rs.next()) {

				Account ac = new Account();

				// Lấy giá trị từ cột DB tương ứng set giá trị cho đối tượng
				ac.setSoTK(rs.getLong("accountID"));
				ac.setPin(rs.getInt("pinCode"));
				ac.setNameAccount(rs.getString("accountName"));
				ac.setSoDuKhaDung(rs.getDouble("availableBalance"));
				ac.setTongSoDu(rs.getDouble("totalBalance"));
				ac.setAccountTypeID(rs.getInt("accountTypeID"));
				ac.setUserID(rs.getInt("userID"));
				ac.setRoleID(rs.getInt("roleID"));
				ac.setLocationID(rs.getInt("locationID"));

//				Role ro = new Role();
//				// Lấy thông tin từ bảng role vào đối tượng Role
//				ro.setRoleID(rs.getInt("roleID"));
//				ro.setRoleName(rs.getString("roleName"));
//				us.setRole(ro); // vì setROle nhận tham số là 1 kiểu role

				lsAccount.add(ac);
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
		return lsAccount;
	}

	@Override
	public Account findAccountById(long accountID) {
		// Viết câu truy vấn
		String queryString = "SELECT * FROM account WHERE accountID='" + accountID + "'";
		// tạo 1 đối tượng để hứng giá trị dc select ra từ câu truy vấn
		Account acc = new Account();
		try {
			// Tạo kết nối với marian DB
			connection = getConnection();
			// Tạo 1 đối tượng PreparedStatement để thực thi(compile) câu lệnh sql
			stmt = connection.prepareStatement(queryString);
			// Thực thi câu sql và lưu vào bảng ResultSet
			rs = stmt.executeQuery();

			while (rs.next()) {
				acc.setSoTK(rs.getLong("accountID"));
				acc.setPin(rs.getInt("pinCode"));
				acc.setNameAccount(rs.getString("accountName"));
				acc.setSoDuKhaDung(rs.getDouble("availableBalance"));
				acc.setTongSoDu(rs.getDouble("totalBalance"));
				acc.setAccountTypeID(rs.getInt("accountTypeID"));
				acc.setUserID(rs.getLong("userID"));
				acc.setRoleID(rs.getInt("roleID"));
				acc.setLocationID(rs.getInt("locationID"));

			}

			connection.close();
//			System.out.println("Account is found");
		} catch (Exception e) {
			System.out.println("Account is not found");
			e.printStackTrace();
		}

		return acc;
	}

	@Override
	// Đẩy thông tin nhập vào xuống DB
	public void addAccount(Account acc) {
		String queryString = "INSERT INTO account value(?,?,?,?,?,?,?,?,?)";

		try {
			connection = getConnection();

			stmt = (PreparedStatement) connection.prepareStatement(queryString);

			stmt.setLong(1, acc.getSoTK());
			stmt.setInt(2, acc.getPin());
			stmt.setString(3, acc.getNameAccount());
			stmt.setDouble(4, acc.getSoDuKhaDung());
			stmt.setDouble(5, acc.getTongSoDu());
			stmt.setInt(6, acc.getAccountTypeID());
			stmt.setLong(7, acc.getUserID());
			stmt.setInt(8, acc.getRoleID());
			stmt.setInt(9, acc.getLocationID());

			stmt.executeUpdate();
			connection.close();
			System.out.println("Bạn đã add Account thành công!");

		} catch (Exception e) {
			System.out.println("Add Account thất bại.");
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAccount(long accountID) {
		String queryString = "DELETE FROM account WHERE accountID='" + accountID + "'";
		
		try {

			connection = getConnection();

			stmt = connection.prepareStatement(queryString);

			stmt.executeUpdate();
			connection.close();
			System.out.println("Xóa account thành công");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Account chưa được xóa");
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(Account acc) {
		String queryString = "UPDATE account SET "
				+ "pinCode=?,accountName=?,availableBalance=?,totalBalance=?,accountTypeID=?,userID=?,roleID=?,locationID=?"
				+ " WHERE accountID=? ";

		try {
			connection = getConnection();
			stmt = (PreparedStatement) connection.prepareStatement(queryString);

			stmt.setInt(1, acc.getPin());
			stmt.setString(2, acc.getNameAccount());
			stmt.setDouble(3, acc.getSoDuKhaDung());
			stmt.setDouble(4, acc.getTongSoDu());
			stmt.setInt(5, acc.getAccountTypeID());
			stmt.setLong(6, acc.getUserID());
			stmt.setInt(7, acc.getRoleID());
			stmt.setInt(8, acc.getLocationID());

			stmt.setLong(9, acc.getSoTK());

			stmt.executeUpdate();
			connection.close();

			System.out.println("Account is updated successfully");
		} catch (Exception e) {
			System.out.println("Account is updated fail");
			e.printStackTrace();
		}

	}

}
