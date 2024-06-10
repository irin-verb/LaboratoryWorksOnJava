package ru.rsreu.verbickaya0605.exceptions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class IrreparableException extends MyException {

	private static final Resourcer RESOURSER = ProjectResourcer.getInstance();
	private static final long serialVersionUID = 1L;

	public IrreparableException(String errorReason) {
		super(errorReason);
	}

	@Override
	public String toString() {
		String resultString = super.toString();
		resultString += RESOURSER.getString("error.irreparable") + "\n";
		return resultString;
	}

}
