package ru.rsreu.verbickaya0805;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String errorReason;

	public MyException(String errorReason) {
		this.errorReason = errorReason;
	}

	public String getErrorReason() {
		return this.errorReason;
	}

	@Override
	public String toString() {
		String resultString = this.getErrorReason() + "\n";
		return resultString;
	}

}
