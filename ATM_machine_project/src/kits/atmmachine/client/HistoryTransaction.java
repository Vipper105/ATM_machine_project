package kits.atmmachine.client;

public class HistoryTransaction {

	private long transactionID;
	private String loaiGiaoDich;
	private String description;
	private String date_transaction;
	private long accountID;
	private long accountReceived;
	private double moneySend;
	private double addedMoney;
	private double withdrawMoney;
	private int oldPIN;
	private int newPIN;

	public HistoryTransaction() {
	}

	public HistoryTransaction(long transactionID, String loaiGiaoDich, String description, String date_transaction,
			long accountID, long accountReceived, double moneySend, double addedMoney, double withdrawMoney, int oldPIN,
			int newPIN) {
		this.transactionID = transactionID;
		this.loaiGiaoDich = loaiGiaoDich;
		this.description = description;
		this.date_transaction = date_transaction;
		this.accountID = accountID;
		this.accountReceived = accountReceived;
		this.moneySend = moneySend;
		this.addedMoney = addedMoney;
		this.withdrawMoney = withdrawMoney;
		this.oldPIN = oldPIN;
		this.newPIN = newPIN;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

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

	public String getDate_transaction() {
		return date_transaction;
	}

	public void setDate_transaction(String date_transaction) {
		this.date_transaction = date_transaction;
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
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

	public double getAddedMoney() {
		return addedMoney;
	}

	public void setAddedMoney(double addedMoney) {
		this.addedMoney = addedMoney;
	}

	public double getWithdrawMoney() {
		return withdrawMoney;
	}

	public void setWithdrawMoney(double withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
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

	public void setAllAtributeHistoryTransaction(String loaiGiaoDich, String description, String date_transaction,
			long accountID, long accountReceived, double moneySend, double addedMoney, double withdrawMoney, int oldPIN,
			int newPIN) {
		this.loaiGiaoDich = loaiGiaoDich;
		this.description = description;
		this.date_transaction = date_transaction;
		this.accountID = accountID;
		this.accountReceived = accountReceived;
		this.moneySend = moneySend;
		this.addedMoney = addedMoney;
		this.withdrawMoney = withdrawMoney;
		this.oldPIN = oldPIN;
		this.newPIN = newPIN;
	}

	public void showHistoryTransaction() {
		System.out.println(
				"Số TT\tTên giao dịch\tDescription\t\tTime \t\t\tAccountID\tAccountReceived \tMoneySend\t\tAddedMoney \tWithdrawMoney"
						+ "\t\tOldPIN \t\tNewPIN");
		System.out.printf("%-7s%-20s%-10s%-38s%-20s%-20s%-19s%-22s%-22s%-17s%-5s\n", transactionID,
				transactionID, description, date_transaction,
				accountID, accountReceived, moneySend,
				addedMoney, withdrawMoney, oldPIN,
				newPIN);
	}

}
