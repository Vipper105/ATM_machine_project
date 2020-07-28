package kits.atmmachine.repository;

import java.util.List;

import kits.atmmachine.entity.Coins;

public interface CoinsRepository {

	void addCoins(Coins coinID);

	void deleteCoins(long coinID);

	void updateCoins(Coins coinID);

	// Show tất cả
	List<Coins> findAllCoins();

	// Tìm kiếm
	Coins findCoinsById(int coinID);

	// Hiển thị thông tin coins khi nhập vào machineID
	Coins findCoinsByMachineID(int machineID);
}
