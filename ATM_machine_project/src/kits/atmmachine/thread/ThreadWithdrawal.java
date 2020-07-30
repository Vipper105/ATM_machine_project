package kits.atmmachine.thread;

import kits.atmmachine.client.CashDispenser;

public class ThreadWithdrawal implements Runnable {

	String s;

	int machineID;
	double withdrawlMoney;
	CashDispenser cashDispenser;

	public ThreadWithdrawal(double withdrawlMoney, int machineID) {
		this.withdrawlMoney = withdrawlMoney;
		this.machineID = machineID;

	}

	public void run() {
		CashDispenser cashDispenser = new CashDispenser();
		try {

			for (int i = 1; i <= 3; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			cashDispenser.dispenserWithMinimumCoin(withdrawlMoney, machineID);

		} catch (Exception ex) {

		}

	}

}
