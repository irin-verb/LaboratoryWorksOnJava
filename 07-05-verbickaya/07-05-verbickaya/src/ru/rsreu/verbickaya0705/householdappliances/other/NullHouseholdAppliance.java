package ru.rsreu.verbickaya0705.householdappliances.other;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class NullHouseholdAppliance implements Appliance {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	@Override
	public String toString() {
		return NullHouseholdAppliance.resourcer.getString("appliance.value.of.max.is.empty");
	}

}
