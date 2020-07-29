package kits.atmmachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kits.atmmachine.entity.ATMmachine;
import kits.atmmachine.entity.Account;
import kits.atmmachine.entity.Coins;
import kits.atmmachine.entity.User;
import kits.atmmachine.exception.AccountNumberCheckingException;
import kits.atmmachine.repository.ATMmachineRepository;
import kits.atmmachine.repository.ATMmachineRepositoryImpl;
import kits.atmmachine.repository.AccountRepository;
import kits.atmmachine.repository.AccountRepositoryImpl;
import kits.atmmachine.repository.CoinsRepository;
import kits.atmmachine.repository.CoinsRepositoryImpl;
import kits.atmmachine.repository.TransactionRepository;
import kits.atmmachine.repository.TransactionRepositoryImpl;
import kits.atmmachine.repository.UserRepository;
import kits.atmmachine.repository.UserRepositoryImpl;

public class ManagerATM {

	List<ATMmachine> listMachine; //
	DatabaseNganHang databaseNganHang;
	ManHinh manHinh;
	BanPhim banPhim;
	int adminID;

//	AccountRepository accountRepo;
//	ATMmachineRepository atmRepo; // field

	public ManagerATM() {
		listMachine = new ArrayList<ATMmachine>();
		databaseNganHang = new DatabaseNganHang();

		manHinh = new ManHinh();
		banPhim = new BanPhim();

	}

	public int validateInputAccountNumber() {

		int soTK = 0;

		manHinh.displayMessageNhapSoTK();

		boolean loop = true;

		while (loop) {
			try {
				Scanner sc = new Scanner(System.in);
				soTK = sc.nextInt();
				if (soTK > 0) {
					loop = false;
				} else {
					throw new AccountNumberCheckingException("Account number is not allow less than 0");
				}

			} catch (InputMismatchException ex) {
				System.out.println("Account number should be a number");
			} catch (AccountNumberCheckingException e) {
				System.out.println(e.getMessage());
			}
		}
		return soTK;

	}

	public void runningSystem() {
		Scanner sc = new Scanner(System.in);
		boolean isContinueAll = true;
		while (isContinueAll) {

			int soTK = 0;

			soTK = validateInputAccountNumber();

			if (databaseNganHang.validateUser(soTK)) {
				System.out.println("Nhập PIN/Password: ");
				int PIN = sc.nextInt();
				if (databaseNganHang.authenticatedUser(soTK, PIN)) {
					// đang nhập thành công
					manHinh.displayMessageLoginSuccessfull();
					//
					adminID = soTK;

					Account account = databaseNganHang.getTaiKhoanKhachHang(adminID);
//					Account account = accountRepo.findAccountById(adminID);

					if (account.getRoleID() == 1) {
						boolean isContinue = true;
						// Admin interface
						while (true) {
							manHinh.displayMenuAdmin();
							int choose = banPhim.nhanThongTinNhapVao();
							switch (choose) {
							case 1:
								manHinh.displayMenuAdminManagerATM();
								//
								managerATMmachine();
								break;

							case 2:
								managerUser();
								break;

							case 3:
								managerAccount();
								break;

							case 4:
								managerCoinsOfMachine();
								break;

							case 5:
								// manage transaction
								managerTransaction();
								break;
							case 6:
								isContinue = false;
								isContinueAll = false;
								break;

							default:

							}

							if (isContinue == false) {
								break;
							}
						}
						manHinh.displayMessageEndProgram();

					} else {
						// Get ra atm theo location của account
						manHinh.displayInputMayAtm();
						int atmID = banPhim.nhanThongTinNhapVao();

						ATMmachineRepository atmRepo = new ATMmachineRepositoryImpl();
						ATMmachine atm = atmRepo.findATMById(atmID);
						atm.runATM(soTK);

						return;
					}

				} else {
					manHinh.displayMessageWrongPINcode();
				}
			} else {
				// screen/alert
				manHinh.displayNotExistedTaiKhoanKhachHang();
			}
		}

	}

	// ============================ Quản lý User ================================
	public void managerUser() {

		boolean isContinue = true;
		int choice;
		do {
			manHinh.displayMenuAdminManagerUser();
			//
			choice = banPhim.nhanThongTinNhapVao();
			switch (choice) {
			case 1:
				// add user
				addUser();
				break;

			case 2:
				// delete user
				deleteUser();
				break;

			case 3:
				// update user
				updateUser();
				break;

			case 4:
				// show user
				readAllUser();
				break;

			case 5:
				// exit
				isContinue = false;
				break;
			}
		} while (isContinue);
	}

	// Thêm user
	public void addUser() {

		User user;
		while (true) {
			manHinh.displayInputUserName();
			String userName = banPhim.nhanThongTinChuoiNhapVao();
			manHinh.displayInputAge();
			int age = banPhim.nhanThongTinNhapVao();
			manHinh.displayInputSex();
			String sex = banPhim.nhanThongTinChuoiNhapVao();
			manHinh.displayInputPhoneNumber();
			String phoneNumber = banPhim.nhanThongTinChuoiNhapVao();
			manHinh.displayInputAddress();
			String address = banPhim.nhanThongTinChuoiNhapVao();

			user = new User(userName, age, sex, phoneNumber, address);

			UserRepository userRepo = new UserRepositoryImpl();
			userRepo.addUser(user);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	// Xóa user
	public void deleteUser() {

		while (true) {
			manHinh.displayInputUserID();
			int userID = banPhim.nhanThongTinNhapVao();
			UserRepository userRepo = new UserRepositoryImpl();
			userRepo.delete(userID);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}

	// Update user => Get user and set attribute + update
	public void updateUser() {

		while (true) {
			manHinh.displayInputUserID();
			int userID = banPhim.nhanThongTinNhapVao();
			UserRepository userRepo = new UserRepositoryImpl();

			User us = userRepo.findUserById(userID);
			// Nhập thông tin bạn muốn edit
			manHinh.displayMessageEditUser();

			manHinh.displayInputUserName();
			String userName = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayInputAge();
			int age = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputSex();
			String sex = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayInputPhoneNumber();
			String phoneNumber = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayInputAddress();
			String address = banPhim.nhanThongTinChuoiNhapVao();

			us.setAllAttributeUser(userName, age, sex, phoneNumber, address);

			userRepo.update(us);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}

	// show info all user
	public void readAllUser() {

		UserRepository userRepo = new UserRepositoryImpl();

		// Tạo 1 list để hứng findAll() : lấy dữ liệu từ DB lên
		List<User> listUser = new ArrayList<User>();
		listUser = userRepo.findAll();

		// In ra list
		for (int i = 0; i < listUser.size(); i++) {
			System.out.println(listUser.get(i).showInfoUser());
		}

	}

	// ============================ // Quản lý User ================================

	// ========================== Quản lý cây ATM ==============================
	public void managerATMmachine() {

		boolean isContinue = true;
		int choice;
		do {
			manHinh.displayMenuAdminManagerATM();
			//
			choice = banPhim.nhanThongTinNhapVao();
			switch (choice) {
			case 1:
				// add atm
				addATM();
				break;

			case 2:
				// delete atm
				deleteATM();
				break;

			case 3:
				// update atm
				updateATM();
				break;

			case 4:
				// show atm
				showATM();
				break;
			case 5:
				// show atm ID
				findATMByID();
				break;
			case 6:
				// exit
				isContinue = false;
				break;
			}
		} while (isContinue);
	}

	// Thêm atm
	public void addATM() {

		ATMmachine atm;
		while (true) {

//			manHinh.displayInputAtmID();
//			int atmID = banPhim.nhanThongTinNhapVao();
			manHinh.displayInputAtmName();
			String atmName = banPhim.nhanThongTinChuoiNhapVao();
			manHinh.displayInputAtmLocation();
			int atmLocation = banPhim.nhanThongTinNhapVao();

			atm = new ATMmachine(atmName, atmLocation);

			ATMmachineRepository ATMmachineRepo = new ATMmachineRepositoryImpl();
			ATMmachineRepo.addATM(atm);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	// Xóa ATM
	public void deleteATM() {
		while (true) {
			manHinh.displayInputAtmID();
			int atmID = banPhim.nhanThongTinNhapVao();
			ATMmachineRepository atmRepo = new ATMmachineRepositoryImpl();
			atmRepo.deleteATM(atmID);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	// Edit ATM
	public void updateATM() {
		while (true) {
			// Nhập thông tin bạn muốn edit
			manHinh.displayMessageEditATM();

			manHinh.displayInputAtmID();
			int atmID = banPhim.nhanThongTinNhapVao();

			ATMmachineRepository atmRepo = new ATMmachineRepositoryImpl();
			ATMmachine atm = atmRepo.findATMById(atmID);
			//
			manHinh.displayInputAtmName();
			String atmName = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayInputAtmLocation();
			int atmLocation = banPhim.nhanThongTinNhapVao();

			atm.setAllAttributeATM(atmName, atmLocation);

			atmRepo.updateATM(atm);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}

	// Find ATM by ID
	public void findATMByID() {
		while (true) {

			manHinh.displayInputAtmID();
			int atmID = banPhim.nhanThongTinNhapVao();

			ATMmachineRepository atmRepo = new ATMmachineRepositoryImpl();
			ATMmachine atm = atmRepo.findATMById(atmID);
			//
			System.out.printf("Machine Name: %s, Location: %d", atm.getMachineName(), atm.getLocationID());

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	// Show ATM
	public void showATM() {
		ATMmachineRepository atmRepo = new ATMmachineRepositoryImpl();

		// Tạo 1 list để hứng findAll() : lấy dữ liệu từ DB lên
		List<ATMmachine> listATM = new ArrayList<ATMmachine>();
		listATM = atmRepo.findAllATM();

		// In ra list
		for (int i = 0; i < listATM.size(); i++) {
			System.out.println(listATM.get(i).showInfoATMmachine());
		}
	}

	// ========================== // Quản lý cây ATM ==============================

	// ========================== Quản lý Account ==============================
	public void managerAccount() {

		boolean isContinue = true;
		int choice;
		do {
			manHinh.displayMenuAdminManagerAccount();

			//
			choice = banPhim.nhanThongTinNhapVao();
			switch (choice) {
			case 1:
				// add account
				addAccount();
				break;

			case 2:
				// delete account
				deleteAccount();

				break;

			case 3:
				// update account
				updateAccount();
				break;

			case 4:
				// show account
				readAllAccount();
				break;
			case 5:
				// show info user by accountID
				findInfoUserByID();
				break;

			case 6:
				// exit
				isContinue = false;
				break;
			}
		} while (isContinue);
	}

	// show info all of account
	public void readAllAccount() {

		AccountRepository accountRepo = new AccountRepositoryImpl();

		// Tạo 1 list để hứng findAll() : lấy dữ liệu từ DB lên
		List<Account> listAccount = new ArrayList<Account>();
		// listAccount Hứng cái list đã dc lấy ra từ DB
		listAccount = accountRepo.findAllAccount();

		// In ra thông tin đối tượng(account) từ listAccount
		for (int i = 0; i < listAccount.size(); i++) {
			System.out.println(listAccount.get(i).showInfoAccount());
		}

	}

	// add account
	public void addAccount() {

		Account acc;
		while (true) {
			manHinh.displayInputPINcode();
			int pinCode = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputAccountName();
			String accountName = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayInputAvailableBalance();
			double availableBalance = banPhim.nhanMonneyNhapVao();

			manHinh.displayInputTotalBalance();
			double totalBalance = banPhim.nhanMonneyNhapVao();

			manHinh.displayInputAccountTypeID();
			int accountTypeID = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputUserID();
			int userID = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputRoleID();
			int roleID = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputLocationID();
			int locationID = banPhim.nhanThongTinNhapVao();

			acc = new Account(pinCode, accountName, availableBalance, totalBalance, accountTypeID, userID, roleID,
					locationID);

			AccountRepository accRepo = new AccountRepositoryImpl();
			accRepo.addAccount(acc);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	// Xóa account
	public void deleteAccount() {

		while (true) {
			manHinh.displayInputAccountID();
			int accountID = banPhim.nhanThongTinNhapVao();
			AccountRepository userRepo = new AccountRepositoryImpl();
			userRepo.deleteAccount(accountID);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}

	// Update account
	public void updateAccount() {
		while (true) {
			manHinh.displayInputAccountID();
			int accountID = banPhim.nhanThongTinNhapVao();
			AccountRepository accountRepo = new AccountRepositoryImpl();

//    			userRepo.delete(userID);
			Account acc = accountRepo.findAccountById(accountID);
			// Nhập thông tin bạn muốn edit
			manHinh.displayMessageEditUser();
			//
			manHinh.displayInputPINcode();
			int pinCode = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputAccountName();
			String accountName = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayInputAvailableBalance();
			double availableBalance = banPhim.nhanMonneyNhapVao();

			manHinh.displayInputTotalBalance();
			double totalBalance = banPhim.nhanMonneyNhapVao();

			manHinh.displayInputAccountTypeID();
			int accountTypeID = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputUserID();
			int userID = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputRoleID();
			int roleID = banPhim.nhanThongTinNhapVao();

			manHinh.displayInputLocationID();
			int locationID = banPhim.nhanThongTinNhapVao();

			acc.setAllAccount(pinCode, accountName, availableBalance, totalBalance, accountTypeID, userID, roleID,
					locationID);

			accountRepo.updateAccount(acc);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	public void findInfoUserByID() {
		while (true) {
			manHinh.displayInputAccountID();
			int accountID = banPhim.nhanThongTinNhapVao();
			UserRepository userRepo = new UserRepositoryImpl();
			User user = userRepo.findUserByAccountID(accountID);
//			System.out.println(user.getUserName());
			System.out.println(user.showInfoUser());

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}

	// ========================== // Quản lý Account ==============================

	// ========================== Quản lý Transaction ==============================
	public void managerTransaction() {

		boolean isContinue = true;
		int choice;
		do {
			manHinh.displayMenuAdminManagerATM_Receipt();

			//
			choice = banPhim.nhanThongTinNhapVao();
			switch (choice) {
			case 1:
				// delete transaction
				manHinh.displayInputDeleteTransactionID();
				long transactionID = banPhim.nhanThongTinNhapVaoLong();
				deleteTransaction(transactionID);

				break;

			case 2:
				// update transaction
				updateTransaction();
				break;

			case 3:
				// show transaction
				databaseNganHang.showHistoryTransaction();
				break;
			case 4:
				// show transaction by accountID
				showTransactionByID();
				break;

			case 5:
				// exit
				isContinue = false;
				break;
			}
		} while (isContinue);
	}

	public void deleteTransaction(long transactionID) {

		TransactionRepository tranRepo = new TransactionRepositoryImpl();
		tranRepo.deleteTransaction(transactionID);

	}

	public void updateTransaction() {

		while (true) {
			manHinh.displayInputTransactionID();
			long transactionID = banPhim.nhanThongTinNhapVaoLong();
			TransactionRepository transactionRepo = new TransactionRepositoryImpl();

//    			userRepo.delete(userID);
			HistoryTransaction trans = transactionRepo.findTransactionById(transactionID);
			// Nhập thông tin bạn muốn edit
			manHinh.displayMessageNhapEdit();
			//
			manHinh.displayMessageInputTypeTransaction();
			String loaiGiaoDich = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayMessageInputDescription();
			String description = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayMessageInputDateTransaction();
			String date_transaction = banPhim.nhanThongTinChuoiNhapVao();

			manHinh.displayInputAccountID();
			long accountID = banPhim.nhanThongTinNhapVaoLong();

			manHinh.displayMessageInputAccountReceived();
			long accountReceived = banPhim.nhanThongTinNhapVaoLong();

			manHinh.displayMessageInputMoneySend();
			double moneySend = banPhim.nhanMonneyNhapVao();

			manHinh.displayMessageInputAddedMoney();
			double addedMoney = banPhim.nhanMonneyNhapVao();

			manHinh.displayMessageInputWithdrawMoney();
			double withdrawMoney = banPhim.nhanMonneyNhapVao();

			manHinh.displayMessageInputOldPIN();
			int oldPIN = banPhim.nhanThongTinNhapVao();

			manHinh.displayMessageInputNewPIN();
			int newPIN = banPhim.nhanThongTinNhapVao();

			trans.setAllAtributeHistoryTransaction(loaiGiaoDich, description, date_transaction, accountID,
					accountReceived, moneySend, addedMoney, withdrawMoney, oldPIN, newPIN);

			transactionRepo.updateTrans(trans);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}

	public void showTransactionByID() {

		manHinh.displayInputTransactionID();
		long transactionID = banPhim.nhanThongTinNhapVaoLong();
		TransactionRepository transRepo = new TransactionRepositoryImpl();
		HistoryTransaction his = transRepo.findTransactionById(transactionID);
		his.showHistoryTransaction();

	}

	// ========================== // Quản lý Transaction ==========================

	public void managerCoinsOfMachine() {

		boolean isContinue = true;
		int choice;
		do {
			manHinh.displayMenuAdminManagerATM_CashDispenser();

			//
			choice = banPhim.nhanThongTinNhapVao();
			switch (choice) {
			case 1:
				// add coins
				addMoneyCoin();
				break;

			case 2:
				// delete coins
				deleteCoin();
				break;

			case 3:
				// update coins
				updateCoin();
				break;

			case 4:
				// show coins by accountID
				showCurrentListCoin();

				break;
			case 5:
				// show all coins
				showAllListCoin();
				break;

			case 6:
				// exit
				isContinue = false;
				break;
			}
		} while (isContinue);

	}

	public void showCurrentListCoin() {
		while (true) {
			manHinh.displayMessageInputMachineID();
			int machineID = banPhim.nhanThongTinNhapVao();

			System.out.println("Danh sách coin hiện tại");
			CoinsRepository coinsRepo = new CoinsRepositoryImpl();
			List<Coins> lisCoins = coinsRepo.findCoinsByMachineID(machineID);
			databaseNganHang.showListCoin(lisCoins);
//			
//			for (int i = 0; i < listAccount.size(); i++) {
//				System.out.println(listAccount.get(i).showInfoAccount());
//			}

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	public void addMoneyCoin() {
		while (true) {
			System.out.println("===  Thêm coins ===");
			manHinh.displayMessageInputPriceTag();
			int priceTag = banPhim.nhanThongTinNhapVao();

			manHinh.displayMessageInputQuantity();
			long quantity = banPhim.nhanThongTinNhapVaoLong();

			manHinh.displayMessageInputMachineID();
			int machineID = banPhim.nhanThongTinNhapVao();

			Coins coin = new Coins(priceTag, quantity, machineID);

			CoinsRepository coinRepo = new CoinsRepositoryImpl();
			coinRepo.addCoins(coin);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}
	}

	public void showAllListCoin() {
		CoinsRepository coinRepo = new CoinsRepositoryImpl();
		List<Coins> listCoin = coinRepo.findAllCoins();

		for (int i = 0; i < listCoin.size(); i++) {
			System.out.println(listCoin.get(i).showInfoCoin());

		}

	}

	public void updateCoin() {
		while (true) {
			manHinh.displayMessageInputCoinID();
			int coinID = banPhim.nhanThongTinNhapVao();

			CoinsRepository coinRepo = new CoinsRepositoryImpl();
			Coins coin = coinRepo.findCoinsById(coinID);

			manHinh.displayMessageInputPriceTag();
			int priceTag = banPhim.nhanThongTinNhapVao();

			manHinh.displayMessageInputQuantity();
			long quantity = banPhim.nhanThongTinNhapVaoLong();

			manHinh.displayMessageInputMachineID();
			int machineID = banPhim.nhanThongTinNhapVao();

			coin.setAllAttributeCoins(priceTag, quantity, machineID);

			coinRepo.updateCoins(coin);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}

		}
	}

	public void deleteCoin() {

		while (true) {
			manHinh.displayMessageInputCoinID();
			int coinID = banPhim.nhanThongTinNhapVao();

			CoinsRepository coinRepo = new CoinsRepositoryImpl();
			coinRepo.deleteCoins(coinID);

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}
}