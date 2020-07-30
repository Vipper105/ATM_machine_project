package kits.atmmachine.admin;

import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.client.KeyBoard;
import kits.atmmachine.client.Screen;
import kits.atmmachine.entity.ATMmachine;
import kits.atmmachine.repository.ATMmachineRepository;
import kits.atmmachine.repository.ATMmachineRepositoryImpl;

public class ManagerATMMachine {
	Screen manHinh = new Screen();
	KeyBoard banPhim = new KeyBoard();

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
			default:
				System.out.println("Wrong choice");
			}
		} while (isContinue);
	}

	// Thêm atm
	public void addATM() {

		ATMmachine atm;
		while (true) {

//				manHinh.displayInputAtmID();
//				int atmID = banPhim.nhanThongTinNhapVao();
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

}
