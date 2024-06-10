package ru.rsreu.verbickaya0705.householdappliances.comparators;

import java.util.Comparator;

import ru.rsreu.verbickaya0705.householdappliances.basic.HouseholdAppliance;

public class HouseholdApplianceDefaultComparator implements Comparator<HouseholdAppliance> {

	@Override
	public int compare(HouseholdAppliance ap1, HouseholdAppliance ap2) {
		return ap1.compareTo(ap2);
	}

}
