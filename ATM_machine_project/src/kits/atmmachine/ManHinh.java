package kits.atmmachine;

public class ManHinh {

	public void displayMessage() {
		System.out.println("Xin chào");
	}

	public void displayMessageNhapSoTK() {
		System.out.println("Mời bạn nhập số tài khoản : ");
	}

	// change PIN
	public void displayMessageNhapPIN() {
		System.out.println("Mời bạn nhập mã PIN : ");
	}

	public void displayMessageEnterOldPIN() {
		System.out.println("Mời nhập bạn mã PIN cũ : ");
	}

	public void displayMessageErrorOldPIN() {
		System.out.println("Mã PIN cũ không chính xác : ");
	}

	public void displayMessageEnterNewPIN() {
		System.out.println("Mời nhập bạn mã PIN mới : ");
	}

	public void displayMessageSameOldPIN_NewPIN() {
		System.out.println("Mã PIN cũ và mới không được trùng nhau: ");
	}

	public void displayMessageChangePinSuccess() {
		System.out.println("Mã PIN đã được đổi thành công! ");
	}

	public void displayMessageLoginSuccessfull() {
		System.out.println("Bạn đã đang nhập thành công");
	}

	public void displayMessageWrongPINcode() {
		System.out.println("Bạn đã nhập sai mã PIN");
	}

	public void displayNotExistedTaiKhoanKhachHang() {
		System.out.println("Tài khoản này không tồn tại");
	}

	public void displayInputSoTienMuonRut() {
		System.out.println("Nhập số tiền muốn rút");
	}

	public void displayMainMenu() {
		System.out.println("============================================");
		System.out.println("Main menu");

		System.out.println("\t1 - Xem số dư");
		System.out.println("\t2 - Rút tiền");
		System.out.println("\t3 - Nạp tiền vào tài khoản");
		System.out.println("\t4 - Chuyển tiền");
		System.out.println("\t5 - Đổi mã PIN");
		System.out.println("\t6 - Show transaction");
		System.out.println("\t7 - Exit");

		System.out.println("Nhập vào lựa chọn");

	}

	// get balance
	public void displaySoDoKhDung() {
		System.out.print("\nSố dư khả dụng của bạn là: ");
	}

	public void displayTongSoDo() {
		System.out.print("\nTổng số dư của bạn là: ");
	}

	public void displayMenuRutTien() {
		System.out.println("============================================");
		System.out.println("Menu rút tiền");
		System.out.println("\t1 - $20" + "\t\t" + " 4 - $100");
		System.out.println("\t2 - $40" + "\t\t" + " 5 - $200");
		System.out.println("\t3 - $60" + "\t\t" + " 6 - Thoát giao dịch");
		System.out.println("Nhập lựa chọn: ");

	}

	public void displayAddMoney() {
		System.out.print("\nMời bạn nhập số tiền muốn thêm vào tài khoản: ");

	}

	public void displayMessageContinue() {
		System.out.println("\nBạn có muốn tiếp tục hay không? Y/N ");
	}

	// transfer money
	public void displayMessageTransferedUser() {
		System.out.print("\nMời bạn nhập vào user muốn chuyển tiền: ");
	}

	public void displayMessageInputTransferAmount() {
		System.out.print("\nMời bạn nhập vào số tiền muốn chuyển: ");
	}

	public void displayMessageBalanceAvailable_UserSend() {
		System.out.print("\nSố dư khả dụng của user gửi là: ");
	}

	public void displayMessageBalanceAvailable_UserReceive() {
		System.out.print("\nSố dư khả dụng của user nhận là: ");
	}

	public void displayMessageBalanceTotal_UserSend() {
		System.out.print("\nTổng số dư của user gửi là: ");
	}

	public void displayMessageBalanceTotal_UserReceive() {
		System.out.print("\nTổng số dư của user nhận là: ");
	}

	public void displayMessageErrorNotEnoughMoney() {
		System.out.println("\nSố dư khả dụng của bạn không đủ.");
	}

	public void displayMenuAdmin() {
		System.out.println("============================================");
		System.out.println("Menu admin");

		System.out.println("\t1. Manager ATM");
		System.out.println("\t2. Manager User");
		System.out.println("\t3. Manager Account");
		System.out.println("\t4. Manager Cashdispenser");
		System.out.println("\t5. Manager Payment/Transaction");
		System.out.println("\t6. Exit");

		System.out.println("Nhập vào lựa chọn: ");

	}

	public void displayMenuAdminManagerATM() {
		System.out.println(" ================    Manager ATM   ===============");
		System.out.println("\t1 - Add ATM");
		System.out.println("\t2 - Delete ATM");
		System.out.println("\t3 - Update ATM");
		System.out.println("\t4 - Show ATM");
		System.out.println("\t5 - Find ATM by ID");
		System.out.println("\t6 - Exit");

		System.out.println("Nhập vào lựa chọn: ");

	}

	public void displayMenuAdminManagerUser() {

		System.out.println("==============    Manager User    =============");
		System.out.println("\t1 - Add User");
		System.out.println("\t2 - Delete User");
		System.out.println("\t3 - Update User");
		System.out.println("\t4 - Show User");
		System.out.println("\t5 - Exit");

		System.out.println("Nhập vào lựa chọn: ");

	}

	public void displayMenuAdminManagerAccount() {

		System.out.println("==============    Manager Account    =============");
		System.out.println("\t1 - Add Account");
		System.out.println("\t2 - Delete Account");
		System.out.println("\t3 - Update Account");
		System.out.println("\t4 - Show Account");
		System.out.println("\t5 - Show information user by AccountID");
		System.out.println("\t6 - Exit");

		System.out.println("Nhập vào lựa chọn: ");

	}

	public void displayMenuAdminManagerATM_CashDispenser() {

		System.out.println("==============    Manager CashDispenser    =============");
		System.out.println("\t1 - Add Money quantity of ATM");
		System.out.println("\t2 - Delete Money quantity of ATM");
		System.out.println("\t3 - Update Money quantity of ATM");
		System.out.println("\t4 - Show Money quantity of ATM");
		System.out.println("\t5 - Exit");

		System.out.println("Nhập vào lựa chọn: ");

	}

	public void displayMenuAdminManagerATM_Receipt() {

		System.out.println("==============   Manager Check receipt/transaction/payment  ===========");
		System.out.println("\t1 - Add transaction by accountID");
		System.out.println("\t2 - Delete transaction by accountID");
		System.out.println("\t3 - Update transaction by accountID");
		System.out.println("\t4 - Show transaction by accountID");
		System.out.println("\t5 - Exit");

		System.out.println("Nhập vào lựa chọn: ");

	}

	// In receipt
	public void displayAskPrintReceipt() {
		System.out.println(" Bạn có muốn in hóa đơn không ? Y/N");
	}

	// Thêm user /edit
	public void displayInputUserName() {
		System.out.println("User name: ");
	}

	public void displayInputAge() {
		System.out.println("User age: ");
	}

	public void displayInputSex() {
		System.out.println("User sex: ");
	}

	public void displayInputPhoneNumber() {
		System.out.println("User phone number: ");
	}

	public void displayInputAddress() {
		System.out.println("User address: ");
	}

	// Edit user
	public void displayMessageEditUser() {
		System.out.println("==============   Nhập thông tin bạn muốn Edit  =============== ");
	}

	// Delete user
	public void displayInputUserID() {
		System.out.println("Input user id: ");
	}

	// CRUD ATM machine
	// add atm
	public void displayInputAtmID() {
		System.out.println("Input atm id: ");
	}

	public void displayInputMayAtm() {
		System.out.println("Please choose ATM machine (1->3): ");
	}

	public void displayInputAtmName() {
		System.out.println("Input atm name: ");
	}

	public void displayInputAtmLocation() {
		System.out.println("Input atm location: ");
	}

	// delete atm
	// edit atm
	public void displayMessageEditATM() {
		System.out.println("==============   Nhập ID của ATM bạn muốn Edit  =============== ");
	}

	// CRUD account
	// add account
	public void displayInputAccountID() {
		System.out.println("Input AccountID: ");
	}

	public void displayInputPINcode() {
		System.out.println("Pin code: ");
	}

	public void displayInputAccountName() {
		System.out.println("Name account: ");
	}

	public void displayInputAvailableBalance() {
		System.out.println("Available Balance: ");
	}

	public void displayInputTotalBalance() {
		System.out.println("Total Balance: ");
	}

	public void displayInputAccountTypeID() {
		System.out.println("Account Type ID : ");
	}

//	public void displayInputUserID() {
//		System.out.println("User address: ");
//	}

	public void displayInputRoleID() {
		System.out.println("Role ID: ");
	}

	public void displayInputLocationID() {
		System.out.println("Location ID: ");
	}

	// CRUD transaction

	public void displayInputDeleteTransactionID() {
		System.out.println("Transaction ID for delete : ");
	}

	public void displayMessageNhapEdit() {
		System.out.println("Nhập thông tin bạn muốn Edit : ");
	}

//	private long transactionID;
//	private String loaiGiaoDich;
//	private String description;
//	private String date_transaction;
//	private long accountID;
//	private long accountReceived;
//	private double moneySend;
//	private double addedMoney;
//	private double withdrawMoney;
//	private int oldPIN;
//	private int newPIN;
	public void displayInputTransactionID() {
		System.out.println("Transaction ID : ");
	}

	public void displayMessageInputTypeTransaction() {
		System.out.println("Nhập loại giao dich : ");
	}

	public void displayMessageInputDescription() {
		System.out.println("Nhập description: ");
	}

	public void displayMessageInputDateTransaction() {
		System.out.println("Nhập date_transaction: ");
	}

	public void displayMessageInputAccountReceived() {
		System.out.println("Nhập account received : ");
	}

	public void displayMessageInputMoneySend() {
		System.out.println("Nhập money Send : ");
	}

	public void displayMessageInputAddedMoney() {
		System.out.println("Nhập added Money : ");
	}

	public void displayMessageInputWithdrawMoney() {
		System.out.println("Nhập withdraw Money : ");
	}

	public void displayMessageInputOldPIN() {
		System.out.println("Nhập old PIN : ");
	}

	public void displayMessageInputNewPIN() {
		System.out.println("Nhập new PIN : ");
	}

	// Quản lý coins
	public void displayMessageInputMachineID() {
		System.out.println("Input machine ID to display coins:   ");
	}

	// In hóa đơn
	public void displayMessagePrintReceiptSuccess() {
		System.out.println("Print receipt successfully.");
	}

	public void displayMessageEndProgram() {
		System.out.println("End program.");
	}

}
