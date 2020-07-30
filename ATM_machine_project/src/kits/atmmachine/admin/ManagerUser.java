package kits.atmmachine.admin;

import java.util.ArrayList;
import java.util.List;

import kits.atmmachine.client.KeyBoard;
import kits.atmmachine.client.Screen;
import kits.atmmachine.entity.User;
import kits.atmmachine.repository.UserRepository;
import kits.atmmachine.repository.UserRepositoryImpl;

public class ManagerUser {

	Screen manHinh = new Screen();
	KeyBoard banPhim = new KeyBoard();

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
			default:
				System.out.println("Wrong choice");
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

}
