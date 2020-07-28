package kits.atmmachine.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kits.atmmachine.HistoryTransaction;
import kits.atmmachine.YeuCau_ChuyenTien;
import kits.atmmachine.YeuCau_HienThiSoDu;
import kits.atmmachine.YeuCau_NapTien;
import kits.atmmachine.YeuCau_RutTien;
import kits.atmmachine.YeuCau_ThayDoiMaPIN;
import kits.atmmachine.config.ConnectionFactory;
import kits.atmmachine.entity.Transaction;
import kits.atmmachine.entity.User;

public class TransactionRepositoryImpl implements TransactionRepository {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public void addTransaction(Transaction transaction, int flag) {
		String queryString = "";
		switch (flag) {
		case 4:
			transaction = (YeuCau_ChuyenTien) transaction;
			queryString = "INSERT INTO transaction(loaiGiaoDich,description,date_transaction,accountID,accountReceived,moneySend) values(?,?,?,?,?,?)";
			break;
		case 1:
			transaction = (YeuCau_HienThiSoDu) transaction;
			queryString = "INSERT INTO transaction(loaiGiaoDich,description,date_transaction,accountID) values(?,?,?,?)";
			break;
		case 3:
			transaction = (YeuCau_NapTien) transaction;
			queryString = "INSERT INTO transaction(loaiGiaoDich,description,date_transaction,accountID,addedMoney) values(?,?,?,?,?)";
			break;
		case 2:
			transaction = (YeuCau_RutTien) transaction;
			queryString = "INSERT INTO transaction(loaiGiaoDich,description,date_transaction,accountID,withdrawlMoney) values(?,?,?,?,?)";
			break;
		case 5:
			transaction = (YeuCau_ThayDoiMaPIN) transaction;
			queryString = "INSERT INTO transaction(loaiGiaoDich,description,date_transaction,accountID,oldPIN,newPIN) values(?,?,?,?,?,?)";
			break;
		}
		try {
			connection = getConnection();

			stmt = (PreparedStatement) connection.prepareStatement(queryString);
			stmt.setString(1, transaction.getLoaiGiaoDich());
			stmt.setString(2, transaction.getDescription());
			stmt.setString(3, transaction.getDate().toString());
			stmt.setLong(4, transaction.getAccountNumber());

			if (transaction instanceof YeuCau_ChuyenTien) {
//			transaction=new YeuCau_ChuyenTien();
				stmt.setLong(5, ((YeuCau_ChuyenTien) transaction).getAccountReceived());
				stmt.setDouble(6, ((YeuCau_ChuyenTien) transaction).getMoneySend());
//				int temp = 0;
//				if (aaa.) {
//					temp= aaaaaaa'
//				}
//				stmt.setDouble(8, 0);
//				stmt.setDouble(9, 0);
//				stmt.setInt(10, 0);
//				stmt.setInt(11, 0);
			}

			if (transaction instanceof YeuCau_HienThiSoDu) {

			}

			if (transaction instanceof YeuCau_NapTien) {
//				transaction=new YeuCau_ChuyenTien();
				// double addedMoney;
				stmt.setDouble(5, ((YeuCau_NapTien) transaction).getAddedMoney());
			}

			if (transaction instanceof YeuCau_RutTien) {
//				transaction=new YeuCau_ChuyenTien();
				stmt.setDouble(5, ((YeuCau_RutTien) transaction).getWithdrawlMoney());

			}

			if (transaction instanceof YeuCau_ThayDoiMaPIN) {
//				transaction=new YeuCau_ChuyenTien();
//				private int oldPIN;
//				private int newPIN;
				stmt.setInt(5, ((YeuCau_ThayDoiMaPIN) transaction).getOldPIN());
				stmt.setInt(6, ((YeuCau_ThayDoiMaPIN) transaction).getNewPIN());

			}

			stmt.executeUpdate();
			connection.close();
			System.out.println("Bạn đã add transaction thành công!");

		} catch (Exception e) {
			System.out.println("Add transaction thất bại.");
			e.printStackTrace();
		}

	}

	@Override
	public void deleteTransaction(long transactionID) {
		String queryString = "DELETE FROM transaction WHERE transactionID='" + transactionID + "'";

		try {

			connection = getConnection();

			stmt = connection.prepareStatement(queryString);

			stmt.executeUpdate();
			connection.close();
			System.out.println("Xóa transaction thành công");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Transaction chưa được xóa");
			e.printStackTrace();
		}

	}

	@Override
	public HistoryTransaction findTransactionById(long transactionID) {
		// Viết câu truy vấn
		String queryString = "SELECT * FROM transaction WHERE transactionID='" + transactionID + "'";
		// tạo 1 đối tượng để hứng giá trị dc select ra từ câu truy vấn
		HistoryTransaction tran = new HistoryTransaction();
		try {
			// Tạo kết nối với marian DB
			connection = getConnection();
			// Tạo 1 đối tượng PreparedStatement để thực thi(compile) câu lệnh sql
			stmt = connection.prepareStatement(queryString);
			// Thực thi câu sql và lưu vào bảng ResultSet
			rs = stmt.executeQuery();

			while (rs.next()) {
				tran.setTransactionID(rs.getLong("transactionID"));
				tran.setLoaiGiaoDich(rs.getString("loaiGiaoDich"));
				tran.setDescription(rs.getString("description"));
				tran.setDate_transaction(rs.getString("date_transaction"));
				tran.setAccountID(rs.getLong("accountID"));
				tran.setAccountReceived(rs.getLong("accountReceived"));
				tran.setMoneySend(rs.getDouble("moneySend"));
				tran.setAddedMoney(rs.getDouble("addedMoney"));
				tran.setWithdrawMoney(rs.getDouble("withdrawlMoney"));
				tran.setOldPIN(rs.getInt("oldPIN"));
				tran.setNewPIN(rs.getInt("newPIN"));

			}

			connection.close();
			System.out.println("Transaction is found");
		} catch (Exception e) {
			System.out.println("Transaction is not found");
			e.printStackTrace();
		}

		return tran;
	}

	@Override
	public void updateTrans(HistoryTransaction transaction) {
		String queryString = "UPDATE transaction SET loaiGiaoDich=?,description=?,date_transaction=?,accountID=?,accountReceived=?,"
				+ "moneySend=?,addedMoney=?,withdrawlMoney=?,oldPIN=?,newPIN=? " + "WHERE transactionID=? ";

		try {
			connection = getConnection();
			stmt = (PreparedStatement) connection.prepareStatement(queryString);

			stmt.setString(1, transaction.getLoaiGiaoDich());
			stmt.setString(2, transaction.getDescription());
			stmt.setString(3, transaction.getDate_transaction());
			stmt.setLong(4, transaction.getAccountID());
			stmt.setLong(5, transaction.getAccountReceived());
			stmt.setDouble(6, transaction.getMoneySend());
			stmt.setDouble(7, transaction.getAddedMoney());
			stmt.setDouble(8, transaction.getWithdrawMoney());
			stmt.setInt(9, transaction.getOldPIN());
			stmt.setInt(10, transaction.getOldPIN());

			stmt.setLong(11, transaction.getTransactionID());

			stmt.executeUpdate();
			connection.close();

			System.out.println("Transaction is updated successfully");
		} catch (Exception e) {
			System.out.println("Transaction is updated fail");
			e.printStackTrace();
		}

	}

	@Override
	public List<HistoryTransaction> findAllTransaction() {

		List<HistoryTransaction> lsTran = new ArrayList<HistoryTransaction>();

		String queryString = "SELECT * FROM transaction";

		try {
			connection = getConnection();

			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //

			while (rs.next()) {
				HistoryTransaction hisTran = new HistoryTransaction();
//		  trị từ cột DB tương ứng set giá trị cho đối tượng
				hisTran.setTransactionID(rs.getLong("transactionID"));
				hisTran.setLoaiGiaoDich(rs.getString("loaiGiaoDich"));
				hisTran.setDescription(rs.getString("description"));
				hisTran.setDate_transaction(rs.getString("date_transaction"));
				hisTran.setAccountID(rs.getLong("accountID"));
				hisTran.setAccountReceived(rs.getLong("accountReceived"));
				hisTran.setMoneySend(rs.getDouble("moneySend"));
				hisTran.setAddedMoney(rs.getDouble("addedMoney"));
				hisTran.setAddedMoney(rs.getDouble("withdrawlMoney"));
				hisTran.setOldPIN(rs.getInt("oldPIN"));
				hisTran.setNewPIN(rs.getInt("newPIN"));

				lsTran.add(hisTran);
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

		return lsTran;
	}

}
