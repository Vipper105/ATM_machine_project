package kits.atmmachine.exception;

public class AccountNumberCheckingException extends Exception {

	public AccountNumberCheckingException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return "Error input account number: " + super.getMessage();
	}
	

}
