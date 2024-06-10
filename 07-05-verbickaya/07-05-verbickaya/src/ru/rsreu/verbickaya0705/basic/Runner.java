package ru.rsreu.verbickaya0705.basic;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0705.householdappliances.basic.HouseholdApplianceType;

public class Runner {

	private Runner() {
	}

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public static void main(String[] args) {

		StringBuilder resultString = new StringBuilder();

		// initializing the list and sorting by two ways

		Initializer.initialize();

		resultString.append(resourcer.getString("list.origin") + "\n");
		resultString.append(Initializer.list.toStringTable());

		resultString.append("\n" + resourcer.getString("list.sorted.default") + "\n");
		resultString.append(Initializer.list.sortedByDefault().toStringTable());

		resultString.append("\n" + resourcer.getString("list.sorted.model.type") + "\n");
		resultString.append(Initializer.list.sortedByModelType().toStringTable());

		// getting values of the second parameter without repeats

		resultString.append("\n" + resourcer.getString("list.unique.model.values") + "\n");
		resultString.append(Initializer.list.getUniqueModels().toString());

		// deleting elements with some value of the third parameter

		HouseholdApplianceType type = HouseholdApplianceType.iron;

		resultString.append("\n\n" + resourcer.getString("list.deleted.type") + ": " + type.toString() + "\n");
		resultString.append(Initializer.list.deletedByType(type).toStringTable());

		// searching elements by value of the first parameter

		String brand1 = "REDMOND";
		String brand2 = "SomeBrand";

		resultString.append("\n" + resourcer.getString("list.element.of.brand") + ": " + brand1 + "\n");
		resultString.append(Initializer.list.searchByBrand(brand1.trim()).toString());

		resultString.append("\n\n" + resourcer.getString("list.element.of.brand") + ": " + brand2 + "\n");
		resultString.append(Initializer.list.searchByBrand(brand2.trim()).toString());

		// output

		System.out.print(resultString.toString());
	}

}
