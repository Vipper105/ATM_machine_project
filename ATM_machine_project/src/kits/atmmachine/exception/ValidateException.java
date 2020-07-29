package kits.atmmachine.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import kits.atmmachine.Screen;

public class ValidateException {

	Screen manHinh;

	public int validateInputAccountNumber() {
		manHinh=new Screen();
		int soTK = 0;

		boolean con = true;

		while (con) {
			manHinh.displayMessageNhapSoTK();
			try {
				Scanner sc = new Scanner(System.in);
				soTK = sc.nextInt();
				if (soTK > 0) {
					con = false;
				} else {
					throw new ExceptionMessage("Account number is not allow less than 0");
				}

			} catch (InputMismatchException ex) {
				System.out.println("Account number should be only number (NOT contains words)");
			} catch (ExceptionMessage e) {
				System.out.println(e.getMessage());
			}
		}
		return soTK;

	}
	
	public int validateInputPINCode() {
		manHinh=new Screen();
		int PINcode = 0;

		boolean con = true;

		while (con) {
			manHinh.displayMessageNhapPIN();;
			try {
				Scanner sc = new Scanner(System.in);
				PINcode = sc.nextInt();
				if (PINcode > 0) {
					con = false;
				} else {
					throw new ExceptionMessage("PIN code is not allow less than 0");
				}

			} catch (InputMismatchException ex) {
				System.out.println("PIN code should be only number (NOT contains words)");
			} catch (ExceptionMessage e) {
				System.out.println(e.getMessage());
			}
		}
		return PINcode;

	}
}
