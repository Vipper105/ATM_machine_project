package kits.atmmachine;

import java.util.Date;

import kits.atmmachine.entity.Transaction;

public class YeuCau_ThayDoiMaPIN extends Transaction {

	private int oldPIN;
	private int newPIN;

	private BanPhim banPhim;
	
	public YeuCau_ThayDoiMaPIN() {}

	public YeuCau_ThayDoiMaPIN(int accountNumber, DatabaseNganHang databaseNganHang, ManHinh manHinh, BanPhim banPhim,
			int oldPIN, int newPIN) {
		super(accountNumber, databaseNganHang, manHinh);
		this.banPhim = banPhim;

		loaiGiaoDich = "Change PIN";
		super.date = new Date();
		//
		this.oldPIN = oldPIN;
		this.newPIN = newPIN;

	}

	public int getOldPIN() {
		return oldPIN;
	}

	public void setOldPIN(int oldPIN) {
		this.oldPIN = oldPIN;
	}

	public int getNewPIN() {
		return newPIN;
	}

	public void setNewPIN(int newPIN) {
		this.newPIN = newPIN;
	}

	@Override
	public void execute() {
		super.getDatabaseNganHang().changePIN(oldPIN, newPIN, super.getAccountNumber());
	}

	@Override
	public String transactionLog() {
		// TODO Auto-generated method stub
		return "";
	}

}
