package kits.atmmachine;

import java.util.Date;

import kits.atmmachine.entity.Transaction;

public class YeuCau_RutTien extends Transaction {

	private BanPhim banPhim;

	private double withdrawlMoney;
	
	public YeuCau_RutTien() {}

	public YeuCau_RutTien(int accountNumber, DatabaseNganHang databaseNganHang, ManHinh manHinh, BanPhim banPhim,
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
