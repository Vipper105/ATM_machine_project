package kits.atmmachine.admin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kits.atmmachine.client.DatabaseNganHang;
import kits.atmmachine.client.HistoryTransaction;
import kits.atmmachine.client.KeyBoard;
import kits.atmmachine.client.Screen;
import kits.atmmachine.entity.ATMmachine;
import kits.atmmachine.entity.Account;
import kits.atmmachine.entity.Coins;
import kits.atmmachine.entity.User;
import kits.atmmachine.exception.ExceptionMessage;
import kits.atmmachine.exception.ValidateException;
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

public class Admin {

	List<ATMmachine> listMachine; //
	DatabaseNganHang databaseNganHang;
	Screen manHinh;
	KeyBoard banPhim;
	int adminID;

//	AccountRepository accountRepo;
//	ATMmachineRepository atmRepo; // field

	public Admin() {
		listMachine = new ArrayList<ATMmachine>();
		databaseNganHang = new DatabaseNganHang();

		manHinh = new Screen();
		banPhim = new KeyBoard();

	}

	public void runningSystem() {
		Scanner sc = new Scanner(System.in);
		boolean isContinueAll = true;
		ValidateException validateException = new ValidateException();
		while (isContinueAll) {

			int soTK = 0;
			// validate account ID
			soTK = validateException.validateInputAccountNumber();

			if (databaseNganHang.validateUser(soTK)) {
				// validate PIN code
				int PIN = validateException.validateInputPINCode();
				
				if (databaseNganHang.validatePIN(soTK, PIN)) {
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
//								manHinh.displayMenuAdminManagerATM();
								//
								ManagerATMMachine managerATMMachine = new ManagerATMMachine();
								managerATMMachine.managerATMmachine();
								break;

							case 2:
								ManagerUser managerUser = new ManagerUser();
								managerUser.managerUser();
								break;

							case 3:
								ManagerAccount managerAccount = new ManagerAccount();
								managerAccount.managerAccount();
								break;

							case 4:
								ManagerCoinsOfMachine machineCoinsOfMachine = new ManagerCoinsOfMachine();
								machineCoinsOfMachine.managerCoinsOfMachine();
								break;

							case 5:
								// manage transaction
								ManagerTransaction managerTransaction = new ManagerTransaction();
								managerTransaction.managerTransaction();
								break;
							case 6:
								isContinue = false;
								isContinueAll = false;
								break;

							default:
								System.out.println("Wrong choice.");
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

}