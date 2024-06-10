package ru.rsreu.verbickaya0305;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class NullIntNumber implements IntNumber {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	@Override
	public String toString() {
		return NullIntNumber.resourcer.getString("message.the.value.of.max.is.empty");
	}

}
