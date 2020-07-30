package kits.atmmachine.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import kits.atmmachine.client.Screen;

public class ValidateException {

	Screen manHinh;

	public int validateInputAccountNumber() {
		manHinh = new Screen();
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
		manHinh = new Screen();
		int PINcode = 0;

		boolean con = true;

		while (con) {
			manHinh.displayMessageNhapPIN();

			try {
				Scanner sc = new Scanner(System.in);
				PINcode = sc.nextInt();
				
				// count the number of digits
				int count = 0;
				int temp = PINcode;
				while (temp > 0) {
					temp = temp / 10;
					count++;
				}

				if (PINcode < 0) {
					throw new ExceptionMessage("PIN code is not allow less than 0");
				} else if (count != 4) {
					throw new ExceptionMessage("PIN code must have 4 digits");
				} else {
					con = false;
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
