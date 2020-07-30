package kits.atmmachine.client;

public class Screen {

	public void displayMessageHello() {
		System.out.println("Hello..");
	}

	public void displayMessageNhapSoTK() {
		System.out.println("Input account number of card : ");
	}

	// change PIN
	public void displayMessageNhapPIN() {
		System.out.println("Input PIN code : ");
	}

	public void displayMessageEnterOldPIN() {
		System.out.println("Input old PIN : ");
	}

	public void displayMessageErrorOldPIN() {
		System.out.println("Old PIN is not exactly : ");
	}

	public void displayMessageEnterNewPIN() {
		System.out.println("Input new PIN : ");
	}

	public void displayMessageSameOldPIN_NewPIN() {
		System.out.println("Old PIN and new PIN should be not duplicate. ");
	}

	public void displayMessageChangePinSuccess() {
		System.out.println("PIN code changed successfully! ");
	}

	public void displayMessageLoginSuccessfull() {
		System.out.println("Login successfully.");
	}

	public void displayMessageWrongPINcode() {
		System.out.println("Wrong PIN code.");
	}

	public void displayNotExistedTaiKhoanKhachHang() {
		System.out.println("Account is not existed");
	}

	public void displayInputSoTienMuonRut() {
		System.out.println("Input Withdrawal money: ");
	}

	public void displayMainMenu() {
		System.out.println("============================================");
		System.out.println("Main menu");

		System.out.println("\t1 - Check balance");
		System.out.println("\t2 - Withdrawal");
		System.out.println("\t3 - Deposit");
		System.out.println("\t4 - Transfer fund");
		System.out.println("\t5 - Change PIN");
		System.out.println("\t6 - Show transaction");
		System.out.println("\t7 - Exit");

		System.out.println("Input your choice: ");

	}

	// get balance
	public void displaySoDoKhDung() {
		System.out.print("\nAvailable balance: ");
	}

	public void displayTongSoDo() {
		System.out.print("\nTotal balance: ");
	}

	public void displayMenuRutTien() {
		System.out.println("============================================");
		System.out.println("Menu Withdrawal");
		System.out.println("\t1 - $10" + "\t\t" + " 5 - $500");
		System.out.println("\t2 - $50" + "\t\t" + " 6 - $1000");
		System.out.println("\t3 - $100" + "\t" + " 7 - $2000");
		System.out.println("\t4 - $200" + "\t" + " 8 - Exit");
		System.out.println("Input your choice: ");

	}

	public void displayAddMoney() {
		System.out.print("\nInput deposit : ");

	}

	public void displayMessageContinue() {
		System.out.println("\nDo you wanna continue? Y/N ");
	}

	// transfer money
	public void displayMessageTransferedUser() {
		System.out.print("\nInput received user : ");
	}

	public void displayMessageInputTransferAmount() {
		System.out.print("\nInput money want to transfer : ");
	}

	public void displayMessageBalanceAvailable_UserSend() {
		System.out.print("\nAvailable balance of user send : ");
	}

	public void displayMessageBalanceAvailable_UserReceive() {
		System.out.print("\nAvailable balance of receive user : ");
	}

	public void displayMessageBalanceTotal_UserSend() {
		System.out.print("\nTotal balance of user send : ");
	}

	public void displayMessageBalanceTotal_UserReceive() {
		System.out.print("\nTotal balance of receive user : ");
	}

	public void displayMessageErrorNotEnoughMoney() {
		System.out.println("\nAvailable balance is NOT enough.");
	}

	public void displayMessageAccountReceivedNotExisted() {
		System.out.println("\nAccount received is not existed");
	}

	public void displayMenuAdmin() {
		System.out.println("============================================");
		System.out.println("Menu admin");

		System.out.println("\t1. Manager ATM");
		System.out.println("\t2. Manager User");
		System.out.println("\t3. Manager Account");
		System.out.println("\t4. Manager Cashdispenser/Coins");
		System.out.println("\t5. Manager Payment/Transaction");
		System.out.println("\t6. Exit");

		System.out.println("Input your choice : ");

	}

	public void displayMenuAdminManagerATM() {
		System.out.println(" ================    Manager ATM   ===============");
		System.out.println("\t1 - Add ATM");
		System.out.println("\t2 - Delete ATM");
		System.out.println("\t3 - Update ATM");
		System.out.println("\t4 - Show ATM");
		System.out.println("\t5 - Find ATM by ID");
		System.out.println("\t6 - Exit");

		System.out.println("Input your choice : ");

	}

	public void displayMenuAdminManagerUser() {

		System.out.println("==============    Manager User    =============");
		System.out.println("\t1 - Add User");
		System.out.println("\t2 - Delete User");
		System.out.println("\t3 - Update User");
		System.out.println("\t4 - Show User");
		System.out.println("\t5 - Exit");

		System.out.println("Input your choice : ");

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
		System.out.println("\t5 - Show all kind money");
		System.out.println("\t6 - Exit");

		System.out.println("Input your choice: ");

	}

	public void displayMenuAdminManagerATM_Receipt() {

		System.out.println("==============   Manager Check receipt/transaction/payment  ===========");
		System.out.println("\t1 - Delete transaction by accountID");
		System.out.println("\t2 - Update transaction by accountID");
		System.out.println("\t3 - Show all transaction");
		System.out.println("\t4 - Show transaction by accountID");
		System.out.println("\t5 - Exit");

		System.out.println("Input your choice: ");

	}

	// In receipt
	public void displayAskPrintReceipt() {
		System.out.println("Do you wanna print receipt ? Y/N");
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
		System.out.println("==============   Input info to Edit  =============== ");
	}

	// Delete user
	public void displayInputUserID() {
		System.out.println("Input user ID : ");
	}

	// CRUD ATM machine
	// add atm
	public void displayInputAtmID() {
		System.out.println("Input ATM ID: ");
	}

	public void displayInputMayAtm() {
		System.out.println("Please choose ATM machine (1->5): ");
	}

	public void displayInputAtmName() {
		System.out.println("Input ATM name: ");
	}

	public void displayInputAtmLocation() {
		System.out.println("Input ATM location: ");
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
		System.out.println("Input info want to Edit : ");
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
		System.out.println("Transaction Type : ");
	}

	public void displayMessageInputDescription() {
		System.out.println("Input Description : ");
	}

	public void displayMessageInputDateTransaction() {
		System.out.println("Input date transaction date : ");
	}

	public void displayMessageInputAccountReceived() {
		System.out.println("Input received account : ");
	}

	public void displayMessageInputMoneySend() {
		System.out.println("Input money Send : ");
	}

	public void displayMessageInputAddedMoney() {
		System.out.println("Input deposit : ");
	}

	public void displayMessageInputWithdrawMoney() {
		System.out.println("Input withdrawl Money : ");
	}

	public void displayMessageInputOldPIN() {
		System.out.println("Input old PIN : ");
	}

	public void displayMessageInputNewPIN() {
		System.out.println("Input new PIN : ");
	}

	// Quản lý coins
	public void displayMessageInputMachineID() {
		System.out.println("Input machine ID :   ");
	}

	public void displayMessageInputCoinID() {
		System.out.println("Input coin ID :   ");
	}

	public void displayMessageInputPriceTag() {
		System.out.println("Input price tag :   ");
	}

	public void displayMessageInputQuantity() {
		System.out.println("Input quantity :   ");
	}

	// In hóa đơn
	public void displayMessagePrintReceiptSuccess() {
		System.out.println("Print receipt successfully.");
	}

	public void displayMessageEndProgram() {
		System.out.println("End program.");
	}

}
