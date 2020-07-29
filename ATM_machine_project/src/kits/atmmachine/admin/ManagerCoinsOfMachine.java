package kits.atmmachine.admin;

import java.util.List;

import kits.atmmachine.DatabaseNganHang;
import kits.atmmachine.KeyBoard;
import kits.atmmachine.Screen;
import kits.atmmachine.entity.Coins;
import kits.atmmachine.repository.CoinsRepository;
import kits.atmmachine.repository.CoinsRepositoryImpl;

public class ManagerCoinsOfMachine {

	Screen manHinh = new Screen();
	KeyBoard banPhim = new KeyBoard();

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
			default:
				System.out.println("Wrong choice");
			}
		} while (isContinue);

	}

	public void showCurrentListCoin() {
		while (true) {
			manHinh.displayMessageInputMachineID();
			int machineID = banPhim.nhanThongTinNhapVao();

			System.out.println("The current list COINS");
			CoinsRepository coinsRepo = new CoinsRepositoryImpl();
			List<Coins> lisCoins = coinsRepo.findCoinsByMachineID(machineID);
			DatabaseNganHang databaseNganHang = new DatabaseNganHang();
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
			System.out.println("===  Add more COINS ===");
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
