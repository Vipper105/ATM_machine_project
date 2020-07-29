package kits.atmmachine;

import java.util.Scanner;

public class BanPhim {
	Scanner sc;

	public BanPhim() {
		sc = new Scanner(System.in);
	}

	public int nhanThongTinNhapVao() {

		int data = Integer.parseInt(sc.nextLine());
//		sc.nextLine();
		return data;
	}

	public long nhanThongTinNhapVaoLong() {

		long data = Long.parseLong(sc.nextLine());
//		sc.nextLine();
		return data;
	}

	public double nhanMonneyNhapVao() {

		double data = Double.parseDouble(sc.nextLine());
//		sc.nextLine();
		return data;
	}

	public String nhanThongTinNhapVaoYesNo() {

		String data = sc.nextLine();
//		sc.nextLine();
		return data;
	}

	public String nhanThongTinChuoiNhapVao() {

		String data = sc.nextLine();
//		sc.nextLine();
		return data;
	}

}
