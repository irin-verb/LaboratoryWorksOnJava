package ru.rsreu.verbickaya0605.exceptions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class FixableException extends MyException {

	private static final Resourcer RESOURSER = ProjectResourcer.getInstance();
	private static final long serialVersionUID = 1L;

	private final String defaultActions;

	public FixableException(String errorReason) {
		super(errorReason);
		this.defaultActions = "";
	}

	public FixableException(String errorReason, String defaultActions) {
		super(errorReason);
		this.defaultActions = defaultActions;
	}

	public String getDefaultActions() {
		return this.defaultActions;
	}

	@Override
	public String toString() {
		String resultString = super.toString();
		if (this.getDefaultActions().equals("")) {
			resultString += RESOURSER.getString("error.default.action") + "\n" + this.getDefaultActions();
		}
		return resultString;
	}

}
