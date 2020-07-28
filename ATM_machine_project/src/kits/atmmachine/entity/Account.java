package kits.atmmachine.entity;

public class Account {
	private long soTK;
	private int pin;
	private String nameAccount;
	private double soDuKhaDung;
	private double tongSoDu; // gồm cả số dư khả dụng + số dự chưa xài dc
	private int accountTypeID; // checking account saving acount tài khoản doanh nghiệp
	private long userID; // khóa phụ
	private int roleID;
	private int locationID;

	public Account() {
	}

	public Account(int pin, String nameAccount, double soDuKhaDung, double tongSoDu, int accountTypeID, long userID,
			int roleID, int locationID) {
		this.pin = pin;
		this.nameAccount = nameAccount;
		this.soDuKhaDung = soDuKhaDung;
		this.tongSoDu = tongSoDu;
		this.accountTypeID = accountTypeID;
		this.userID = userID;
		this.roleID = roleID;
		this.locationID = locationID;
	}

	public Account(int soTK, int pin, String nameAccount, double soDuKhaDung, double tongSoDu, int accountTypeID,
			long userID, int roleID, int locationID) {
		this.soTK = soTK;
		this.pin = pin;
		this.nameAccount = nameAccount;
		this.soDuKhaDung = soDuKhaDung;
		this.tongSoDu = tongSoDu;
		this.accountTypeID = accountTypeID;
		this.userID = userID;
		this.roleID = roleID;
		this.locationID = locationID;
	}

	public long getSoTK() {
		return soTK;
	}

	public void setSoTK(long soTK) {
		this.soTK = soTK;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getNameAccount() {
		return nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public double getSoDuKhaDung() {
		return soDuKhaDung;
	}

	public void setSoDuKhaDung(double soDuKhaDung) {
		this.soDuKhaDung = soDuKhaDung;
	}

	public double getTongSoDu() {
		return tongSoDu;
	}

	public void setTongSoDu(double tongSoDu) {
		this.tongSoDu = tongSoDu;
	}

	public int getAccountTypeID() {
		return accountTypeID;
	}

	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	//
	public void setAllAccount(int pin, String nameAccount, double soDuKhaDung, double tongSoDu, int accountTypeID,
			long userID, int roleID, int locationID) {
		this.pin = pin;
		this.nameAccount = nameAccount;
		this.soDuKhaDung = soDuKhaDung;
		this.tongSoDu = tongSoDu;
		this.accountTypeID = accountTypeID;
		this.userID = userID;
		this.roleID = roleID;
		this.locationID = locationID;
	}

	public String showInfoAccount() {
		return "Account [soTK=" + soTK + ", pin=" + pin + ", name=" + nameAccount + ", soDuKhaDung=" + soDuKhaDung
				+ ", tongSoDu=" + tongSoDu + ", accountTypeID=" + accountTypeID + ", userID=" + userID + ", roleID="
				+ roleID + ", locationID=" + locationID + "]";
	}

	public boolean validatePIN(int pin_code) {
		if (pin == pin_code) {
			return true;
		}

		return false;

	}

}
