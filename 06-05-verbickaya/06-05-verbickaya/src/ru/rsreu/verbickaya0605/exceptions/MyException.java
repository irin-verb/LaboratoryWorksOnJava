package ru.rsreu.verbickaya0605.exceptions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Resourcer RESOURSER = ProjectResourcer.getInstance();

	private final String errorReason;

	public MyException(String errorReason) {
		this.errorReason = errorReason;
	}

	public String getErrorReason() {
		return this.errorReason;
	}

	@Override
	public String toString() {
		String resultString = RESOURSER.getString("error.label") + " " + this.getErrorReason() + "\n";
		return resultString;
	}
}
