package kits.atmmachine;

import java.util.Date;

import kits.atmmachine.entity.Transaction;

public class YC_Withdrawal extends Transaction {

	private KeyBoard banPhim;

	private double withdrawlMoney;
	
	public YC_Withdrawal() {}

	public YC_Withdrawal(int accountNumber, DatabaseNganHang databaseNganHang, Screen manHinh, KeyBoard banPhim,
			double withdrawlMoney) {
		super(accountNumber, databaseNganHang, manHinh);
		//
		this.withdrawlMoney = withdrawlMoney;
		this.banPhim = banPhim;
		loaiGiaoDich = "Widthwal money";
		super.date = new Date();
//		transactionID++;

	}

	public double getWithdrawlMoney() {
		return withdrawlMoney;
	}

	public void setWithdrawlMoney(double withdrawlMoney) {
		this.withdrawlMoney = withdrawlMoney;
	}

	@Override
	public void execute() {
		
		super.getDatabaseNganHang().credit(withdrawlMoney, super.getAccountNumber());

	}

	@Override
	public String transactionLog() {

		return "";
	}

}
