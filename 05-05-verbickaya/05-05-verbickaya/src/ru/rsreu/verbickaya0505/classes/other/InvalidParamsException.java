package ru.rsreu.verbickaya0505.classes.other;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class InvalidParamsException extends Exception {

	private static final Resourcer RESOURSER = ProjectResourcer.getInstance();
	private static final long serialVersionUID = 1L;

	private final String message;

	public InvalidParamsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		String s = RESOURSER.getString("here.is.error") + " " + this.getMessage();
		return s;
	}
}
