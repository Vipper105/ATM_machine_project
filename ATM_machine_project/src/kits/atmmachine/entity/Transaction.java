package kits.atmmachine.entity;



import java.util.Date;

import kits.atmmachine.DatabaseNganHang;
import kits.atmmachine.ManHinh;

public abstract class Transaction {

	protected DatabaseNganHang databaseNganHang;
	protected ManHinh manHinh;

	private int accountNumber;
	//
//	static int transactionID = 0;
	protected long transactionID;
	protected String loaiGiaoDich;
	protected String description;
	protected Date date;
	
//	int subtransactionID=0;

	public Transaction() {
	}

	public Transaction(int accountNumber, DatabaseNganHang databaseNganHang, ManHinh manHinh) {
		this.accountNumber = accountNumber;
		this.databaseNganHang = databaseNganHang;
		this.manHinh = manHinh;
	}

	
	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public DatabaseNganHang getDatabaseNganHang() {
		return databaseNganHang;
	}

	public void setDatabaseNganHang(DatabaseNganHang databaseNganHang) {
		this.databaseNganHang = databaseNganHang;
	}

	public ManHinh getManHinh() {
		return manHinh;
	}

	public void setManHinh(ManHinh manHinh) {
		this.manHinh = manHinh;
	}

	//
//	public int getTransactionID() {
//		return transactionID;
//	}
//
//	public void setTransactionID(int transactionID) {
//		this.transactionID = transactionID;
//	}

	public String getLoaiGiaoDich() {
		return loaiGiaoDich;
	}

	public void setLoaiGiaoDich(String loaiGiaoDich) {
		this.loaiGiaoDich = loaiGiaoDich;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Hiển thị số dư
	public abstract void execute();

	// Hiển thị lịch sử giao dịch
	public abstract String transactionLog();
}