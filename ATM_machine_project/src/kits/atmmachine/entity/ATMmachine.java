package kits.atmmachine.entity;

import java.util.List;
import java.util.Scanner;
import kits.atmmachine.BanPhim;
import kits.atmmachine.CashDispenser;
import kits.atmmachine.DatabaseNganHang;
import kits.atmmachine.HistoryTransaction;
import kits.atmmachine.ManHinh;
import kits.atmmachine.YeuCau_ChuyenTien;
import kits.atmmachine.YeuCau_HienThiSoDu;
import kits.atmmachine.YeuCau_NapTien;
import kits.atmmachine.YeuCau_RutTien;
import kits.atmmachine.YeuCau_ThayDoiMaPIN;
import kits.atmmachine.repository.AccountRepository;
import kits.atmmachine.repository.AccountRepositoryImpl;
import kits.atmmachine.repository.CoinsRepository;
import kits.atmmachine.repository.TransactionRepository;
import kits.atmmachine.repository.TransactionRepositoryImpl;

public class ATMmachine {

	private int machineID;
	private String machineName;
	private int locationID;
	//
	boolean authenticated;

	BanPhim banPhim;
	CashDispenser cashDispenser;
	ManHinh manHinh;
	DatabaseNganHang databaseNganHang;

	Transaction transaction;

	int current_AccountNumber;

//	List<Transaction> lisTransactions;

	CoinsRepository coinsRepo;

	Scanner sc = new Scanner(System.in);

	public ATMmachine() {
		authenticated = false;
		current_AccountNumber = 0;

		banPhim = new BanPhim();
		cashDispenser = new CashDispenser();
		databaseNganHang = new DatabaseNganHang();
		manHinh = new ManHinh();

		transaction = null;
//		coins=new Coins();
//		lisTransactions = new ArrayList<Transaction>();

	}

	public ATMmachine(String machineName, int locationID) {
		this();
//		lisTransactions = new ArrayList<Transaction>();
		this.machineName = machineName;
		this.locationID = locationID;
	}

	// set all thuộc tính trừ ID
	public void setAllAttributeATM(String machineName, int locationID) {
		this.machineName = machineName;
		this.locationID = locationID;
	}

	public int getMachineID() {
		return machineID;
	}

	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	// run ATM machine ........
	public void runATM(int soTK) {
		boolean isOn = true;

		// Mản hình hiển thị message welcome
		manHinh.displayMessage();

		while (isOn) {

			// User interface
			boolean isContinue = false;

			int flag = 0;
			do {
				// display main menu
				manHinh.displayMainMenu();
				int choice = banPhim.nhanThongTinNhapVao();
//						System.out.println(databaseNganHang.listAccount.get(1));

				switch (choice) {
				case 1:
					transaction = new YeuCau_HienThiSoDu(soTK, databaseNganHang, manHinh);

					// Xem số dư
					transaction.execute();
					//
//					 System.out.println(cashDispenser.sumCoinsInATM(machineID));
//					lisTransactions.add(transaction);
					flag = 1;
					addTrans(transaction, flag);
					isContinue = true;
					break;

				case 2:
					boolean isOnDrawMonney = true;
					double soTienRut = 0;
					int[] amounts = { 0, 10, 50, 100, 200, 500, 1000, 2000 };
					while (isOnDrawMonney) {
						manHinh.displayMenuRutTien();
						int choiceMoney = banPhim.nhanThongTinNhapVao();

						switch (choiceMoney) {
						case 1:
							soTienRut += amounts[choiceMoney];
							break;
						case 2:
							soTienRut += amounts[choiceMoney];
							break;
						case 3:
							soTienRut += amounts[choiceMoney];
							break;
						case 4:
							soTienRut += amounts[choiceMoney];
							break;
						case 5:
							soTienRut += amounts[choiceMoney];
							break;
						case 6:
							soTienRut += amounts[choiceMoney];
							break;
						case 7:
							soTienRut += amounts[choiceMoney];
							break;

						case 8:
							// Exit
							isOnDrawMonney = false;
							break;
						default:
							System.out.println("Wrong choice");
						}
					}

					AccountRepository accRepo=new AccountRepositoryImpl();
					Account account=accRepo.findAccountById(machineID);
//					Account account = new Account();
					long totalAmountCoins = cashDispenser.sumCoinsInATM(machineID);
					if (soTienRut <= account.getSoDuKhaDung()) {
						if (soTienRut <= totalAmountCoins) {
							transaction = new YeuCau_RutTien(soTK, databaseNganHang, manHinh, banPhim, soTienRut);
							// Rút tiền
							System.out.println("Total Withdrawal: " + soTienRut);
							transaction.execute();

							cashDispenser.dispenserWithMinimumCoin(soTienRut, machineID);
							flag = 2; 
							addTrans(transaction, flag);
							isContinue = true;

						} else {
							System.out.println("Cash dispenser is not enough.");
						}

					} else {
						System.out.println("Balance is not enough money for Withdrawal");
					}
//					lisTransactions.add(transaction);
					break;

				case 3:
					// Nạp tiền vào tài khoản
					manHinh.displayAddMoney();
					double moneyAdded = banPhim.nhanMonneyNhapVao();
					transaction = new YeuCau_NapTien(soTK, databaseNganHang, manHinh, banPhim, moneyAdded);
					transaction.execute();
					//
//					lisTransactions.add(transaction);
					flag = 3;
					addTrans(transaction, flag);
					isContinue = true;
					break;

				case 4:
					// Chuyển tiền
					// chọn tài khoản ngân hàng muốn chuyển tiền
					manHinh.displayMessageTransferedUser();
					long maTK_Received = banPhim.nhanThongTinNhapVao();
					// Nhập số tiền muốn chuyển
					manHinh.displayMessageInputTransferAmount();
					double transferedAmount = banPhim.nhanMonneyNhapVao();

					transaction = new YeuCau_ChuyenTien(soTK, databaseNganHang, manHinh, banPhim, maTK_Received,
							transferedAmount);
					transaction.execute();
//					lisTransactions.add(transaction);
					//
					flag = 4;
					addTrans(transaction, flag);
					isContinue = true;
					break;

				case 5:
					// Đổi mã PIN
					manHinh.displayMessageEnterOldPIN();
					int oldPIN = banPhim.nhanThongTinNhapVao();
					manHinh.displayMessageEnterNewPIN();
					int newPIN = banPhim.nhanThongTinNhapVao();

					transaction = new YeuCau_ThayDoiMaPIN(soTK, databaseNganHang, manHinh, banPhim, oldPIN, newPIN);
					transaction.execute();
					//
//					lisTransactions.add(transaction);
					//
					flag = 5;
					addTrans(transaction, flag);
					isContinue = true;
					break;
				case 6:
					// show transaction
//					showTransaction(lisTransactions, soTK);
					databaseNganHang.showHistoryTransaction();
					break;
				case 7:
					// Thoát
					isOn = false;
					//
					current_AccountNumber = 0;
					transaction = null;
					isContinue = false;
					break;

				default:
					System.out.println("Wrong choice");
				}

				// continue ??
				manHinh.displayMessageContinue();
				String isCon = banPhim.nhanThongTinNhapVaoYesNo();

				isContinue = check(isCon);

			} while (isContinue);
			manHinh.displayMessageEndProgram();
			isOn = false;
		}

		// In receipt => lấy từ lịch sử gia dịch
		manHinh.displayAskPrintReceipt();
		String data = banPhim.nhanThongTinNhapVaoYesNo();
		boolean isPrintReceipt = check(data);

		TransactionRepository tranRepo = new TransactionRepositoryImpl();
		List<HistoryTransaction> listTransaction = tranRepo.findAllTransaction();
		if (isPrintReceipt == true) {
			databaseNganHang.receipt(listTransaction);
			manHinh.displayMessagePrintReceiptSuccess();

		} else {
			return;
		}
	}

	boolean check(String value) {
		boolean isOK = true;
		if (value.equalsIgnoreCase("Y")) {
			isOK = true;
		} else if (value.equalsIgnoreCase("N")) {
			isOK = false;
		}
		return isOK;
	}

	public String showInfoATMmachine() {
		return "ATMmachine [machineID=" + machineID + ", machineName=" + machineName + ", locationID=" + locationID
				+ "]";
	}

	// Show transaction
	void showTransaction(List<Transaction> listTransaction, int soTK) {
		int transactionID = 0;
		for (Transaction tran : listTransaction) {
			System.out.print("Time: " + tran.getDate() + " | ");
			System.out.print(" Transaction ID: " + (++transactionID) + " | ");
			System.out.print(" Account number: " + soTK + " | ");
			System.out.print(" Loại giao dịch: " + tran.getLoaiGiaoDich() + " ");
			// Gọi lịch sử log của mỗi thằng con
			tran.transactionLog();
			System.out.println();
		}
		System.out.println(" => Tổng số lượng transaction: " + listTransaction.size());

	}

//	// =========================== // IO =======================================

	// thêm transaction
	public void addTrans(Transaction transaction, int flag) {

		TransactionRepository accRepo = new TransactionRepositoryImpl();
		accRepo.addTransaction(transaction, flag);

	}

}
