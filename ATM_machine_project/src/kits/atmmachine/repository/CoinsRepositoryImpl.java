package kits.atmmachine.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	@Override
	public void addCoins(Coins coinID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCoins(long coinID) {
		// TODO Auto-generated method stub

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
	public Coins findCoinsById(int coinID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coins findCoinsByMachineID(int machineID) {
		// TODO Auto-generated method stub
		return null;
	}

}
