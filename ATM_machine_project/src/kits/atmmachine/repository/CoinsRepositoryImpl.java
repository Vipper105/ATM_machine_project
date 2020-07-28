package kits.atmmachine.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.config.ConnectionFactory;
import kits.atmmachine.entity.Coins;
import kits.atmmachine.entity.User;

public class CoinsRepositoryImpl implements CoinsRepository {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public void addCoins(Coins coinID) {

	}

	@Override
	public void deleteCoins(long coinID) {

	}

	@Override
	public void updateCoins(Coins coinID) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Coins> findAllCoins() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Coins> findCoinsByMachineID(int machineID) {
		List<Coins> lsCoin = new ArrayList<Coins>();
		String queryString = "SELECT c.* FROM atmmachine as a JOIN coins as c ON  a.machineID =c.machineID  WHERE c.machineID='"
				+ machineID + "'";

		try {
			connection = getConnection();

			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); // Select

			while (rs.next()) {
				Coins coins = new Coins();
				// Lấy giá trị từ cột DB tương ứng set giá trị cho đối tượng
				coins.setCoinID(rs.getInt("coinID"));
				coins.setPriceTag(rs.getInt("priceTag"));
				coins.setQuantity(rs.getLong("quantity"));
				coins.setMachineID(rs.getInt("machineID"));

				lsCoin.add(coins);
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
		return lsCoin;
	}

	@Override
	public Coins findCoinsById(int coinID) {
		// TODO Auto-generated method stub
		return null;
	}

}
