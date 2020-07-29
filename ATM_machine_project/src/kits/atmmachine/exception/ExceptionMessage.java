package kits.atmmachine.exception;

public class ExceptionMessage extends Exception {

	public ExceptionMessage(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return "Error : " + super.getMessage();
	}
	

}
