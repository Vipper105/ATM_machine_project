package kits.atmmachine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import kits.atmmachine.entity.Account;
import kits.atmmachine.entity.Coins;
import kits.atmmachine.repository.AccountRepository;
import kits.atmmachine.repository.AccountRepositoryImpl;
import kits.atmmachine.repository.TransactionRepository;
import kits.atmmachine.repository.TransactionRepositoryImpl;

public class DatabaseNganHang {

	private List<Account> listAccount;
	private ManHinh manHinh;
	private AccountRepository accountRepo;

	public DatabaseNganHang() {
//		listAccount = new ArrayList<Account>();

//		Role role1 = new Role(1, "Admin");
//		Role role2 = new Role(2, "User");
//
//		Location location1 = new Location(1, "HCM");
//		Location location2 = new Location(2, "ĐN");
//
//		Account tk1 = new Account(0001, 1111, "Huy", 1000, 1500, 1, 1, 1, 1);
//		Account tk2 = new Account(0002, 1111, "Nghĩa", 500, 1000, 1, 2, 2, 1);

//		listAccount.add(tk1);
//		listAccount.add(tk2);

		accountRepo = new AccountRepositoryImpl();
		// get DB
		listAccount = accountRepo.findAllAccount();

		manHinh = new ManHinh();

	}

	// Tra ve tai khoan neu dung nguoi dung
	public Account getTaiKhoanKhachHang(long soTK) {
		for (int i = 0; i < listAccount.size(); i++) {

			if (listAccount.get(i).getSoTK() == soTK) {
				return listAccount.get(i);
			}
		}
		// Nếu ko tìm thấy sẽ trả về null
		return null;
	}

	// Validate user
	boolean validateUser(int soTK) {
//		Account taiKhoanKhachHang = getTaiKhoanKhachHang(soTK);
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		if (taiKhoanKhachHang == null) {
			return false;
		}
		return true;
	}

	// authenticatedUser
	boolean authenticatedUser(int soTK, int pin_code) {

		if (validateTKKH(soTK, pin_code)) {
			return true;
		}
		return false;
	}

	// validate pin
	boolean validateTKKH(int soTK, int pin_code) {
//		Account taiKhoanKhachHang = getTaiKhoanKhachHang(soTK);
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		if (taiKhoanKhachHang != null) {
			return taiKhoanKhachHang.validatePIN(pin_code);
		}
		return false;
	}

	// Tra ve so du
	public double getSoDuKhaDung(int soTK) {
//		return getTaiKhoanKhachHang(soTK).getSoDuKhaDung();
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		return taiKhoanKhachHang.getSoDuKhaDung();

	}

	// Tra ve tong so du
	double getTongSoDu(int soTK) {
//		return getTaiKhoanKhachHang(soTK).getTongSoDu();
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		return taiKhoanKhachHang.getTongSoDu();
	}

	// Trừ số tiền rút vào số dư khả dụng
	void credit(double soTienRut, int soTK) {
//		Account taiKhoanKhachHang = getTaiKhoanKhachHang(soTK);
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		double soDuKhaDung = taiKhoanKhachHang.getSoDuKhaDung();
		double soDoTotal = taiKhoanKhachHang.getTongSoDu();

		if (soDuKhaDung >= soTienRut) {
			soDuKhaDung = soDuKhaDung - soTienRut;
			soDoTotal = soDoTotal - soTienRut;
			taiKhoanKhachHang.setSoDuKhaDung(soDuKhaDung);
			taiKhoanKhachHang.setTongSoDu(soDoTotal);
			// update xuống DB
//			System.out.println("Withdrawal succsessfully");
//			System.out.println("Số dư hiện tại : " + soDuKhaDung);
			accountRepo.updateAccount(taiKhoanKhachHang);
		} else {
//			System.out.println("Balance is not enough money for Withdrawal");
			return;
		}

	}

	// Nạp tiền vào tk
	void addMoney(double soTienNapThem, int soTK) {

//		Account taiKhoanKhachHang = getTaiKhoanKhachHang(soTK);
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		double soDuKhaDung = taiKhoanKhachHang.getSoDuKhaDung();
		double soDoTotal = taiKhoanKhachHang.getTongSoDu();

		soDuKhaDung = soDuKhaDung + soTienNapThem;
		soDoTotal = soDoTotal + soTienNapThem;
		taiKhoanKhachHang.setSoDuKhaDung(soDuKhaDung);
		taiKhoanKhachHang.setTongSoDu(soDoTotal);
		accountRepo.updateAccount(taiKhoanKhachHang);
	}

	// Change PIN
	boolean oldPIN(int oldPIN, int soTK) {
//		Account taiKhoanKhachHang = getTaiKhoanKhachHang(soTK);
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		if (taiKhoanKhachHang.getPin() == oldPIN) {
			return true;
		}

		return false;
	}

	void changePIN(int oldPIN, int newPIN, int soTK) {
//		Account taiKhoanKhachHang = getTaiKhoanKhachHang(soTK);
		Account taiKhoanKhachHang = accountRepo.findAccountById(soTK);
		if (oldPIN(oldPIN, soTK)) {
			if (oldPIN != newPIN) {
				taiKhoanKhachHang.setPin(newPIN);
				accountRepo.updateAccount(taiKhoanKhachHang);
				System.out.println("Mã pin đã dc set lại là: " + taiKhoanKhachHang.getPin());
				manHinh.displayMessageChangePinSuccess();
			} else {
				manHinh.displayMessageSameOldPIN_NewPIN();
			}

		} else {
			manHinh.displayMessageErrorOldPIN();
		}
	}

	// transfer money
	void transferMoney(long amountSendAccount, long amountReceiveAccount, double sendAmount) {
//		Account accountSend = getTaiKhoanKhachHang(amountSendAccount);
//		Account accountReceived = getTaiKhoanKhachHang(amountReceiveAccount);
		Account accountSend = accountRepo.findAccountById(amountSendAccount);
		Account accountReceived = accountRepo.findAccountById(amountReceiveAccount);

		double balanceAvailable_SendUser = accountSend.getSoDuKhaDung() - sendAmount;
		double balanceTotal_SendUser = accountSend.getTongSoDu() - sendAmount;

		if (balanceAvailable_SendUser >= 0) {
			// Account send
			accountSend.setSoDuKhaDung(balanceAvailable_SendUser);
			accountSend.setTongSoDu(balanceTotal_SendUser);
			//
			accountRepo.updateAccount(accountSend);

			manHinh.displayMessageBalanceAvailable_UserSend();
			System.out.println(accountSend.getSoDuKhaDung());
			manHinh.displayMessageBalanceTotal_UserSend();
			System.out.println(accountSend.getTongSoDu());

			// Account received
			double balanceAvailable_ReceivedUser = accountReceived.getSoDuKhaDung() + sendAmount;
			double balanceTotal_ReceivedUser = accountReceived.getTongSoDu() + sendAmount;
			accountReceived.setSoDuKhaDung(balanceAvailable_ReceivedUser);
			accountReceived.setTongSoDu(balanceTotal_ReceivedUser);
			//
			accountRepo.updateAccount(accountReceived);

			manHinh.displayMessageBalanceAvailable_UserReceive();
			System.out.println(accountReceived.getSoDuKhaDung());
			manHinh.displayMessageBalanceTotal_UserReceive();
			System.out.println(accountReceived.getTongSoDu());

		} else {
			manHinh.displayMessageErrorNotEnoughMoney();
			return;
		}

	}

	// Show all transaction
	public void showHistoryTransaction() {

		TransactionRepository tranRepo = new TransactionRepositoryImpl();
		List<HistoryTransaction> list = tranRepo.findAllTransaction();

		System.out.println(
				"Số TT\tTên giao dịch\tDescription\t\tTime \t\t\tAccountID\tAccountReceived \tMoneySend\t\tAddedMoney \tWithdrawMoney"
						+ "\t\tOldPIN \t\tNewPIN");
		for (HistoryTransaction historyTran : list) {

			System.out.printf("%-7s%-20s%-10s%-38s%-20s%-20s%-19s%-22s%-22s%-17s%-5s\n", historyTran.getTransactionID(),
					historyTran.getLoaiGiaoDich(), historyTran.getDescription(), historyTran.getDate_transaction(),
					historyTran.getAccountID(), historyTran.getAccountReceived(), historyTran.getMoneySend(),
					historyTran.getAddedMoney(), historyTran.getWithdrawMoney(), historyTran.getOldPIN(),
					historyTran.getNewPIN());
		}
	}

	// ================================== I/O ====================================
	public void receipt(List<HistoryTransaction> listTransaction) {
		// get a string from product
		StringBuffer buffer = new StringBuffer();

		buffer.append(
				"Số TT\tTên giao dịch\tDescription\t\tTime \t\t\tAccountID\tAccountReceived \tMoneySend\t\tAddedMoney \tWithdrawMoney"
						+ "\t\tOldPIN \t\tNewPIN\n");
		for (HistoryTransaction historyTran : listTransaction) {
//			buffer.append(historyTran.getTransactionID()).append("\t")
//					.append(historyTran.getLoaiGiaoDich()).append("\t").append(historyTran.getDescription()).append("\n");
			buffer.append(String.format("%-7s%-20s%-10s%-38s%-20s%-20s%-19s%-22s%-22s%-17s%-5s\n",
					historyTran.getTransactionID(), historyTran.getLoaiGiaoDich(), historyTran.getDescription(),
					historyTran.getDate_transaction(), historyTran.getAccountID(), historyTran.getAccountReceived(),
					historyTran.getMoneySend(), historyTran.getAddedMoney(), historyTran.getWithdrawMoney(),
					historyTran.getOldPIN(), historyTran.getNewPIN()));
		}

		String str = buffer.toString();

		writeReceipt(str);

	}

	//=================    Write Receipt   =======================
	public void writeReceipt(String data) {
		File newfile = new File("C:/Users/PC09/Desktop/exam/text2.txt");
		OutputStream os = null;
		try {
			os = new FileOutputStream(newfile);
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// =========================== ///// IO =======================================

	// Show info coin of ATM machine
	public void showListCoin(List<Coins> lisCoins) {
		System.out.printf("%-15s%-20s%-20s%15s\n", "Coin ID", "Price Tag", "Quantity", "Machine ID");
		for (Coins coin : lisCoins) {
			System.out.print(coin.getCoinID() + "\t\t");
			System.out.print(coin.getPriceTag() + "\t\t\t");
			System.out.print(coin.getQuantity() + "\t\t\t");
			System.out.print(coin.getMachineID() + "\n");

		}
	}

}
