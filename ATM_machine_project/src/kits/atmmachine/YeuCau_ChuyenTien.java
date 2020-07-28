package kits.atmmachine;

import java.util.Date;

import kits.atmmachine.entity.Transaction;

public class YeuCau_ChuyenTien extends Transaction {

	private BanPhim banPhim;
	private ManHinh manHinh;
	//
//	private String accountSent;
	private long accountReceived;
	private double moneySend;

	public YeuCau_ChuyenTien() {
	}

	public YeuCau_ChuyenTien(int accountNumber, DatabaseNganHang databaseNganHang, ManHinh manHinh, BanPhim banPhim,
			long accountReceived, double moneySend) {
		super(accountNumber, databaseNganHang, manHinh);
		//
		this.accountReceived = accountReceived;
		this.moneySend = moneySend;

		this.banPhim = banPhim;
		this.manHinh = manHinh;

		loaiGiaoDich = "Transfer monney";
		//
		super.date = new Date();
//		transactionID++;
	}

	public long getAccountReceived() {
		return accountReceived;
	}

	public void setAccountReceived(long accountReceived) {
		this.accountReceived = accountReceived;
	}

	public double getMoneySend() {
		return moneySend;
	}

	public void setMoneySend(double moneySend) {
		this.moneySend = moneySend;
	}

	@Override
	public void execute() {

//		// chọn tài khoản ngân hàng muốn chuyển tiền
//		manHinh.displayMessageTransferedUser();
//		int maTK_Received = banPhim.nhanThongTinNhapVao();
//
//		// Nhập số tiền muốn chuyển
//		manHinh.displayMessageInputTransferAmount();
//		double transferedAmount = banPhim.nhanMonneyNhapVao();

		// Trừ số tiền rút vào số dư khả dụng
		super.getDatabaseNganHang().transferMoney(super.getAccountNumber(), this.accountReceived, this.moneySend);

	}

	@Override
	public String transactionLog() {
		// TODO Auto-generated method stub
		return "";
	}

}
