package kits.atmmachine.admin;

import kits.atmmachine.DatabaseNganHang;
import kits.atmmachine.HistoryTransaction;
import kits.atmmachine.KeyBoard;
import kits.atmmachine.Screen;
import kits.atmmachine.repository.TransactionRepository;
import kits.atmmachine.repository.TransactionRepositoryImpl;

public class ManagerTransaction {
	Screen manHinh = new Screen();
	KeyBoard banPhim = new KeyBoard();

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
				DatabaseNganHang databaseNganHang = new DatabaseNganHang();
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
			default:
				System.out.println("Wrong choice");
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

//	    			userRepo.delete(userID);
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

}
