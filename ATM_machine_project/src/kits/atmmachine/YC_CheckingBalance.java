package kits.atmmachine;

import java.util.Date;

import kits.atmmachine.entity.Transaction;

public class YC_CheckingBalance extends Transaction {
	
	public YC_CheckingBalance(){}

	// Nếu có super thì nó sẽ gọi tới contructure có tham số của thằng cha nếu không
	// có thì phả khia báo ở thằng cha constructure mặc định
	// Đơn giản là constructure con nếu ko có super(thuộc tính lớp cha) thì nó sẽ
	// gọi đến constructure mặc định của cha,nếu ko có khia báo sẽ bị lỗi
	public YC_CheckingBalance(int accountNumber, DatabaseNganHang databaseNganHang, Screen manHinh) {
		super(accountNumber, databaseNganHang, manHinh);
		loaiGiaoDich = "Checking balance";
		super.date = new Date();
//		transactionID++;

	}

	@Override
	public void execute() {
		double soDuKhaDung = super.getDatabaseNganHang().getSoDuKhaDung(super.getAccountNumber());

		double tongSoDu = super.getDatabaseNganHang().getTongSoDu(super.getAccountNumber());
		super.getManHinh().displaySoDoKhDung();
		System.out.print(soDuKhaDung);
		super.getManHinh().displayTongSoDo();
		System.out.println(tongSoDu);
	}

	@Override
	public String transactionLog() {
		String str = "";
		// TODO Auto-generated method stub
		double soDuKhaDung = super.getDatabaseNganHang().getSoDuKhaDung(super.getAccountNumber());
		double tongSoDu = super.getDatabaseNganHang().getTongSoDu(super.getAccountNumber());
		str += "| Balance amount: " + soDuKhaDung;
		str += "\t| Total amount: " + tongSoDu;
		return str;

	}

}
