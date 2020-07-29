package kits.atmmachine.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.config.ConnectionFactory;
import kits.atmmachine.entity.User;

public class UserRepositoryImpl implements UserRepository {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	// Lấy ra danh sách user
	public List<User> findAll() {
		List<User> lsUser = new ArrayList<User>();
		String queryString = "SELECT * FROM user";

		try {
			connection = getConnection();

			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); // Select

			while (rs.next()) {
				User us = new User();
				// Lấy giá trị từ cột DB tương ứng set giá trị cho đối tượng
				us.setUserId(rs.getLong("userID"));
				us.setUserName(rs.getString("userName"));
				us.setAge(rs.getInt("age"));
				us.setSex(rs.getString("sex"));
				us.setPhoneNumber(rs.getString("phoneNumber"));
				us.setAddress(rs.getString("address"));

				lsUser.add(us);
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
		return lsUser;
	}

	@Override
	// Tìm user theo ..
	public User findUserById(int id) {
		// Viết câu truy vấn
		String queryString = "SELECT * FROM user WHERE userID='" + id + "'";
		// tạo 1 đối tượng để hứng giá trị dc select ra từ câu truy vấn
		User us = new User();
		try {
			// Tạo kết nối với marian DB
			connection = getConnection();
			// Tạo 1 đối tượng PreparedStatement để thực thi(compile) câu lệnh sql
			stmt = connection.prepareStatement(queryString);
			// Thực thi câu sql và lưu vào bảng ResultSet
			rs = stmt.executeQuery();

			while (rs.next()) {
				us.setUserId(rs.getLong("userID"));
				us.setUserName(rs.getString("userName"));
				us.setAge(rs.getInt("age"));
				us.setSex(rs.getString("sex"));
				us.setPhoneNumber(rs.getString("phoneNumber"));
				us.setAddress(rs.getString("address"));
			}

			connection.close();
			System.out.println("User is found");
		} catch (Exception e) {
			System.out.println("User is not found");
			e.printStackTrace();
		}

		return us;
	}
	
	// Tìm user theo mã tài khoản accountID
		public User findUserByAccountID(int accountID) {
			String queryString = "SELECT user.* FROM user JOIN account ON user.userID=account.userID WHERE account.accountID='" + accountID + "'";

			User us = new User();
			try {
				connection = getConnection();
			
				stmt = connection.prepareStatement(queryString);
				rs = stmt.executeQuery();

				while (rs.next()) {
					us.setUserId(rs.getLong("userID"));
					us.setUserName(rs.getString("userName"));
					us.setAge(rs.getInt("age"));
					us.setSex(rs.getString("sex"));
					us.setPhoneNumber(rs.getString("phoneNumber"));
					us.setAddress(rs.getString("address"));
				}

				connection.close();
				System.out.println("User is found");
			} catch (Exception e) {
				System.out.println("User is not found");
				e.printStackTrace();
			}

			return us;
		}

	@Override
	// Update user thực hiện sai khi tìm kiếm ra user (hay gọi là getUser)
	public void update(User user) {

		String queryString = "UPDATE user SET userName=?,age=?,sex=?,phoneNumber=?,address=? WHERE userID=? ";

		try {
			connection = getConnection();
			stmt =(PreparedStatement) connection.prepareStatement(queryString);
		
			stmt.setString(1, user.getUserName());
			stmt.setInt(2, user.getAge());
			stmt.setString(3, user.getSex());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(5, user.getAddress());
			
			stmt.setLong(6, user.getUserId());
			
			stmt.executeUpdate();
			connection.close();

			System.out.println("User is updated successfully");
		} catch (Exception e) {
			System.out.println("User is updated fail");
			e.printStackTrace();
		}

	}

	@Override
	// Xóa User
	public void delete(long userID) {

		String queryString = "DELETE FROM user WHERE userID='" + userID + "'";												

		try {

			connection = getConnection();

			stmt = connection.prepareStatement(queryString);

			stmt.executeUpdate();
			connection.close();
			System.out.println("Xóa sản phẩm thành công");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sản phẩm chưa được xóa");
			e.printStackTrace();
		}

	}

	@Override
	// Thêm User
	public void addUser(User user) {
		String queryString = "INSERT INTO user(userName,age,sex,phoneNumber,address) values(?,?,?,?,?)";

		try {
			connection = getConnection();

			stmt = (PreparedStatement) connection.prepareStatement(queryString);

			stmt.setString(1, user.getUserName());
			stmt.setInt(2, user.getAge());
			stmt.setString(3, user.getSex());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(5, user.getAddress());

			stmt.executeUpdate();
			connection.close();
			System.out.println("Bạn đã add user thành công!");
			/*
			 * 1) public ResultSet executeQuery(String sql): được sử dụng để thực hiện truy
			 * vấn SELECT. Nó trả về đối tượng của ResultSet. 2) public int
			 * executeUpdate(String sql): được sử dụng để thực thi câu truy vấn được chỉ
			 * định, nó có thể là create, drop, insert, update, delete, ...
			 */
		} catch (Exception e) {
			System.out.println("Add User thất bại.");
			e.printStackTrace();
		}

	}

}
