package ru.rsreu.verbickaya0705.householdappliances.other;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public interface ComparableApplianceType {

	Resourcer RESOURCER = ProjectResourcer.getInstance();

	String string();

	String toString();

	int compareTo(ComparableApplianceType style);

}
