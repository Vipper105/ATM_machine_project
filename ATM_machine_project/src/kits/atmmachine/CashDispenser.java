package kits.atmmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kits.atmmachine.entity.ATMmachine;
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
//		listCoins = coinsRepo.findCoinsByMachineID(machineID);

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

	public long sumCoinsInATM(int machineID) {
		listCoins = coinsRepo.findCoinsByMachineID(machineID);
		long sumCashDispenser = 0;
		for (int i = 0; i < listCoins.size(); i++) {
			sumCashDispenser += listCoins.get(i).getPriceTag() * listCoins.get(i).getQuantity();
		}
		return sumCashDispenser;
	}

	public void dispenserWithMinimumCoin(int amount, int machineID) {
		listCoins = coinsRepo.findCoinsByMachineID(machineID);

		List<Integer> listMinimumCoin = new ArrayList<Integer>();
		int[] arrPriceTag = new int[listCoins.size()];
		long[] arrQuantityOfPriceTag = new long[arrPriceTag.length];

		// add value of priceTag to array
		for (int i = 0; i < listCoins.size(); i++) {
			arrPriceTag[i] = listCoins.get(i).getPriceTag();
		}

		// add quantity of priceTag to array
		for (int i = 0; i < listCoins.size(); i++) {
			arrQuantityOfPriceTag[i] = listCoins.get(i).getQuantity();
		}

		// make increase array
		Arrays.sort(arrPriceTag);

		//
//		int count = 0;
		for (int i = arrPriceTag.length - 1; i > 0; i--) {
			while (arrPriceTag[i] <= amount) {
				listMinimumCoin.add(arrPriceTag[i]);
				amount = amount - arrPriceTag[i];
				arrQuantityOfPriceTag[i]++;

//				count++;
			}
		}

		// display minimun coin
		for (int i = 0; i < listMinimumCoin.size(); i++) {
			System.out.print(listMinimumCoin.get(i) + ", ");
		}

		// display quantity of priceTag after payment

		return;
	}

	public boolean checkCashEnoughMoneyDispense() {

		return true;
	}

}
