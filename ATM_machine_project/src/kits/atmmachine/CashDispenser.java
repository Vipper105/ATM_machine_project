package kits.atmmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kits.atmmachine.entity.ATMmachine;
import kits.atmmachine.entity.Coins;
import kits.atmmachine.repository.CoinsRepository;
import kits.atmmachine.repository.CoinsRepositoryImpl;

public class CashDispenser {

	List<Coins> listCoins;

	CoinsRepository coinsRepo;
	int machineID;

	public CashDispenser() {
		coinsRepo = new CoinsRepositoryImpl();
	}

	public CashDispenser(int machineID) {
		this();
		this.machineID = machineID;
	}

	public long sumCoinsInATM(int machineID) {
		listCoins = coinsRepo.findCoinsByMachineID(machineID);
		long sumCashDispenser = 0;
		for (int i = 0; i < listCoins.size(); i++) {
			sumCashDispenser += listCoins.get(i).getPriceTag() * listCoins.get(i).getQuantity();
		}
		return sumCashDispenser;
	}

	public void dispenserWithMinimumCoin(double amount, int machineID) {
		listCoins = coinsRepo.findCoinsByMachineID(machineID);

		List<Integer> listMinimumCoin = new ArrayList<Integer>();
		int[] arrPriceTag = new int[listCoins.size()];
		long[] arrQuantityOfPriceTag = new long[arrPriceTag.length];

		// push value of priceTag to array
		for (int i = 0; i < listCoins.size(); i++) {
			arrPriceTag[i] = listCoins.get(i).getPriceTag();
		}

		// push quantity of priceTag to array
		for (int i = 0; i < listCoins.size(); i++) {
			arrQuantityOfPriceTag[i] = listCoins.get(i).getQuantity();
		}

		// make increase array
		Arrays.sort(arrPriceTag);

		for (int i = arrPriceTag.length - 1; i > 0; i--) {
			while (arrPriceTag[i] <= amount) {
				if (arrQuantityOfPriceTag[i] > 0) {
					listMinimumCoin.add(arrPriceTag[i]);
					amount = amount - arrPriceTag[i];
//				if (arrQuantityOfPriceTag[i] > 0) {
					arrQuantityOfPriceTag[i]--;
				} else {
					i--;
				}
			}
		}

		System.out.println("\n --------  List of price tag  --------- ");
		// print array contains minimun coin
		String str1 = "";
		for (int i = 0; i < listMinimumCoin.size(); i++) {
			str1 += listMinimumCoin.get(i)+" ,";
//			System.out.print(listMinimumCoin.get(i) + ", ");
		}
		System.out.println(str1.replaceAll(",$", ""));

		System.out.println("\n --------  List of quantity of price array  ----------");
		// print array contains quantity of priceTag after payment
		String str2 = "";
		for (int i = 0; i < arrQuantityOfPriceTag.length; i++) {
			str2 += arrQuantityOfPriceTag[i] + " ,";
//			System.out.print(arrQuantityOfPriceTag[i] + ", ");	
		}
		System.out.println(str2.replaceAll(",$", ""));
		System.out.println("=========================================================================");

		// input data from quantity array back quantity listCoins
		// arrQuantityOfPriceTag.length
		for (int i = 0; i < arrQuantityOfPriceTag.length; i++) {
			listCoins.get(i).setQuantity(arrQuantityOfPriceTag[i]);
		}

		// update to DB
		CoinsRepository coinsRepo = new CoinsRepositoryImpl();
		for (int i = 0; i < listCoins.size(); i++) {
			coinsRepo.updateCoins(listCoins.get(i));
		}

		return;

	}

}
