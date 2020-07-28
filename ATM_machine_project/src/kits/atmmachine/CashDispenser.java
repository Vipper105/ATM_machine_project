package kits.atmmachine;

import java.util.List;

import kits.atmmachine.entity.Coins;
import kits.atmmachine.repository.CoinsRepository;
import kits.atmmachine.repository.CoinsRepositoryImpl;

public class CashDispenser {

	private final static int INITIAL_COUNT = 500;
	private int count;
	List<Coins> listCoins;

	CoinsRepository coinsRepo;
	int machineID;

	public CashDispenser() {
		count = INITIAL_COUNT;
		coinsRepo = new CoinsRepositoryImpl();
		listCoins = coinsRepo.findCoinsByMachineID(machineID);

	}

	public CashDispenser(int machineID) {
		this();
		this.machineID = machineID;

	}

	public void dispenseCash(int amount) {
		int billsRequired = amount / 20;
		count = ++billsRequired;

	}

//	public boolean checkCashAvailable(int amount) {
//		int billsRequired = amount / 20;
//
//		if (count >= billsRequired) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	public boolean checkCashAvailable(int amount) {
		long sumCashDispenser = 0;

		for (int i = 0; i < listCoins.size(); i++) {
			sumCashDispenser += listCoins.get(i).getPriceTag() * listCoins.get(i).getQuantity();
		}

		if (amount > sumCashDispenser) {
			return false;
		}
		return true;
	}

	public boolean checkCashEnoughMoneyDispense() {
		
		
		
		
		return true;
	}
	
}
