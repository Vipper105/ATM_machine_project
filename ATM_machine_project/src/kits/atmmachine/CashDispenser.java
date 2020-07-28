package kits.atmmachine;

import java.util.List;

import kits.atmmachine.entity.Coins;

public class CashDispenser {

	private final static int INITIAL_COUNT = 500;
	private int count;
	List<Coins> listCoins;

	public CashDispenser() {
		count = INITIAL_COUNT;
		

	}

	public void dispenseCash(int amount) {
		int billsRequired = amount / 20;
		count = ++billsRequired;

	}

	public boolean checkCashAvailable(int amount) {
		int billsRequired = amount / 20;

		if (count >= billsRequired) {
			return true;
		} else {
			return false;
		}
	}

}
