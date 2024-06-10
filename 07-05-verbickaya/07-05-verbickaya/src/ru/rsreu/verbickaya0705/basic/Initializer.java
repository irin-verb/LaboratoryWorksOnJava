package ru.rsreu.verbickaya0705.basic;

import ru.rsreu.verbickaya0705.householdappliances.basic.HouseholdAppliance;
import ru.rsreu.verbickaya0705.householdappliances.basic.HouseholdApplianceType;
import ru.rsreu.verbickaya0705.householdappliances.basic.HouseholdAppliancesContainer;

public class Initializer {

	private Initializer() {
	}

	private static HouseholdAppliance appliance1;
	private static HouseholdAppliance appliance2;
	private static HouseholdAppliance appliance3;
	private static HouseholdAppliance appliance4;
	private static HouseholdAppliance appliance5;
	private static HouseholdAppliance appliance6;

	public static HouseholdAppliancesContainer list;

	public static void initialize() {

		Initializer.appliance1 = new HouseholdAppliance("Samsung", "BBBB", HouseholdApplianceType.iron);
		Initializer.appliance2 = new HouseholdAppliance("Philips", "AA", HouseholdApplianceType.iron);
		Initializer.appliance3 = new HouseholdAppliance("Bosch", "BB", HouseholdApplianceType.dishwasher);
		Initializer.appliance4 = new HouseholdAppliance("REDMOND", "BB", HouseholdApplianceType.blender);
		Initializer.appliance5 = new HouseholdAppliance("Polaris", "C", HouseholdApplianceType.steamer);
		Initializer.appliance6 = new HouseholdAppliance("Hitachi", "AA", HouseholdApplianceType.refrigerator);

		Initializer.list = new HouseholdAppliancesContainer(Initializer.appliance1, Initializer.appliance2,
				Initializer.appliance3, Initializer.appliance4, Initializer.appliance5, Initializer.appliance6);
	}

}
