package kits.atmmachine.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.config.ConnectionFactory;
import kits.atmmachine.entity.Coins;

public class CoinsRepositoryImpl implements CoinsRepository {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	// add coin
	@Override
	public void addCoins(Coins coin) {
		String queryString = "INSERT INTO coins(priceTag,quantity,machineID) values(?,?,?)";

		try {
			connection = getConnection();

			stmt = (PreparedStatement) connection.prepareStatement(queryString);

			stmt.setInt(1, coin.getPriceTag());
			stmt.setLong(2, coin.getQuantity());
			stmt.setInt(3, coin.getMachineID());

			stmt.executeUpdate();
			connection.close();
			System.out.println("Bạn đã add coins thành công!");

		} catch (Exception e) {
			System.out.println("Add Coins thất bại.");
			e.printStackTrace();
		}
	}

	// delete coins by coin ID
	@Override
	public void deleteCoins(long coinID) {
		String queryString = "DELETE FROM coins WHERE coinID='" + coinID + "'";

		try {

			connection = getConnection();

			stmt = connection.prepareStatement(queryString);

			stmt.executeUpdate();
			connection.close();
			System.out.println("Delete coin successfully");

		} catch (Exception e) {

			System.out.println("Delete coin fail");
			e.printStackTrace();
		}
	}

	// find coin by coinID
	@Override
	public Coins findCoinsById(int coinID) {

		String queryString = "SELECT * FROM coins WHERE coinID='" + coinID + "'";

		Coins coin = new Coins();
		try {

			connection = getConnection();

			stmt = connection.prepareStatement(queryString);

			rs = stmt.executeQuery();

			while (rs.next()) {
				coin.setCoinID(rs.getInt("coinID"));
				coin.setPriceTag(rs.getInt("priceTag"));
				coin.setQuantity(rs.getLong("quantity"));
				coin.setMachineID(rs.getInt("machineID"));
			}

			connection.close();
			System.out.println("Coin is found");
		} catch (Exception e) {
			System.out.println("Coin is not found");
			e.printStackTrace();
		}

		return coin;
	}

	// update data coins
	@Override
	public void updateCoins(Coins coin) {

		String queryString = "UPDATE coins SET priceTag=?,quantity=?,machineID=? WHERE coinID=?";

		try {

			connection = getConnection();
			stmt = (PreparedStatement) connection.prepareStatement(queryString);
			stmt.setInt(1, coin.getPriceTag());
			stmt.setLong(2, coin.getQuantity());
			stmt.setInt(3, coin.getMachineID());

			stmt.setInt(4, coin.getCoinID());

			stmt.executeUpdate();
			connection.close();

//			System.out.println("Update coin successfully");
		} catch (Exception e) {
			System.out.println("Update coin fail");
			e.printStackTrace();
		}

	}

	// show all coins
	@Override
	public List<Coins> findAllCoins() {
		List<Coins> lsCoin = new ArrayList<Coins>();
		String queryString = "SELECT * FROM coins";

		try {
			connection = getConnection();

			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); // Select

			while (rs.next()) {
				Coins coin = new Coins();
				// Lấy giá trị từ cột DB tương ứng set giá trị cho đối tượng
				coin.setCoinID(rs.getInt("coinID"));
				coin.setPriceTag(rs.getInt("priceTag"));
				coin.setQuantity(rs.getLong("quantity"));
				coin.setMachineID(rs.getInt("machineID"));

				lsCoin.add(coin);
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

	// show coins by machine ID
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

}
