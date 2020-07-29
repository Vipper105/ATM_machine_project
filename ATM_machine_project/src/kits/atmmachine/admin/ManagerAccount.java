package kits.atmmachine.admin;

import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.KeyBoard;
import kits.atmmachine.Screen;
import kits.atmmachine.entity.Account;
import kits.atmmachine.entity.User;
import kits.atmmachine.repository.AccountRepository;
import kits.atmmachine.repository.AccountRepositoryImpl;
import kits.atmmachine.repository.UserRepository;
import kits.atmmachine.repository.UserRepositoryImpl;

public class ManagerAccount {

	Screen manHinh = new Screen();
	KeyBoard banPhim = new KeyBoard();

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
			default:
				System.out.println("Wrong choice");
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

//	    			userRepo.delete(userID);
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
//				System.out.println(user.getUserName());
			System.out.println(user.showInfoUser());

			manHinh.displayMessageContinue();
			String isContinue = banPhim.nhanThongTinNhapVaoYesNo();
			if (isContinue.equals("N")) {
				break;
			}
		}

	}

	// ========================== // Quản lý Account ==============================
}
