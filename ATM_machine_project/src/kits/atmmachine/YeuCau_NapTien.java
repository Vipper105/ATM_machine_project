package kits.atmmachine;

import java.util.Date;

import kits.atmmachine.entity.Transaction;

public class YeuCau_NapTien extends Transaction {

	private BanPhim banPhim;
	//
	private double addedMoney;
	
	public YeuCau_NapTien() {}

	public YeuCau_NapTien(int accountNumber, DatabaseNganHang databaseNganHang, ManHinh manHinh, BanPhim banPhim,
			double addedMoney) {
		super(accountNumber, databaseNganHang, manHinh);
		this.banPhim = banPhim;
		//
		this.addedMoney = addedMoney;

		loaiGiaoDich = "Add money";
		// Khi gọi tới đối tương con sẽ tạo ra 1 đối tương new Date() và gán vào giá trị
		// date của lớp cha
		// Sau đó ở lớp cha sẽ lấy giá trị new Date ra thông qua hàm getDate và in ra
		super.date = new Date();
//		transactionID++;
	}

//	double moneyAdded;

	public BanPhim getBanPhim() {
		return banPhim;
	}

	public void setBanPhim(BanPhim banPhim) {
		this.banPhim = banPhim;
	}

	public double getAddedMoney() {
		return addedMoney;
	}

	public void setAddedMoney(double addedMoney) {
		this.addedMoney = addedMoney;
	}

	@Override
	public void execute() {
//		super.getManHinh().displayAddMoney();
//		moneyAdded = banPhim.nhanMonneyNhapVao();
		super.getDatabaseNganHang().addMoney(this.addedMoney, super.getAccountNumber());

	}

	@Override
	public String transactionLog() {
		String str = "";
//		double soTienAddThem=super.getDatabaseNganHang().get
		double soDuKhaDung = super.getDatabaseNganHang().getSoDuKhaDung(super.getAccountNumber());
		double tongSoDu = super.getDatabaseNganHang().getTongSoDu(super.getAccountNumber());
//		str += " | Money add thêm: " + moneyAdded;
		str += " | Balance amount: " + soDuKhaDung;
		str += " | Total amount: " + tongSoDu;
		return str;
	}

}
