package ru.rsreu.verbickaya0605.householdappliances;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0605.exceptions.FixableException;

public class HouseholdAppliancesStorage implements Comparable<HouseholdAppliancesStorage> {

	private static Resourcer resourcer = ProjectResourcer.getInstance();
	private HouseholdAppliance[] items;

	public HouseholdAppliancesStorage(HouseholdAppliance... args) throws FixableException {
		this.items = new HouseholdAppliance[0];
		this.addItems(args);
	}

	public HouseholdAppliance[] getItems() {
		return this.items;
	}

	public void addItems(HouseholdAppliance... args) throws FixableException {
		boolean errorFlag = false;
		for (HouseholdAppliance item : args) {
			if (this.isInItemsBrands(item)) {
				errorFlag = true;
			} else {
				this.addItem(item);
			}
		}
		if (errorFlag) {
			throw new FixableException(resourcer.getString("error.reason.adding.invalid.brand"),
					resourcer.getString("error.act.adding.invalid.brand"));
		}

	}

	public void addItem(HouseholdAppliance item) {
		int newLength = this.getItems().length + 1;
		HouseholdAppliance[] newArray = new HouseholdAppliance[newLength];
		System.arraycopy(this.getItems(), 0, newArray, 0, this.getItems().length);
		newArray[newLength - 1] = item;
		this.items = new HouseholdAppliance[newLength];
		System.arraycopy(newArray, 0, this.items, 0, newLength);
	}

	public String toStringTable() {
		StringBuilder resultString = new StringBuilder("\n");
		String separator = "|";
		final int len = 20;
		for (HouseholdAppliance item : this.getItems()) {
			resultString.append(item.getType().toString()
					+ HouseholdAppliancesStorage.spasesBeforeLegth(len, item.getType().toString()) + separator);
			resultString.append(
					item.getBrand() + HouseholdAppliancesStorage.spasesBeforeLegth(len, item.getBrand()) + separator);
			resultString.append(item.getModel() + HouseholdAppliancesStorage.spasesBeforeLegth(len, item.getModel())
					+ separator + "\n");
		}
		return resultString.toString();
	}

	private static String spasesBeforeLegth(int length, String arg) {
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < length - arg.length(); i++) {
			resultString.append(" ");
		}
		return resultString.toString();
	}

	private boolean isInItemsBrands(HouseholdAppliance someItem) {
		boolean result = false;
		for (HouseholdAppliance item : this.getItems()) {
			if (item.getBrand().equals(someItem.getBrand())) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder resultString = new StringBuilder();
		for (HouseholdAppliance item : this.getItems()) {
			resultString.append(item.toString());
		}
		return resultString.toString();
	}

	@Override
	public int compareTo(HouseholdAppliancesStorage o) {
		if (o.getItems().length > this.getItems().length) {
			return -1;
		} else if (o.getItems().length < this.getItems().length) {
			return 1;
		} else {
			for (int i = 0; i < this.getItems().length; i++) {
				if (o.getItems()[i].compareTo(this.getItems()[i]) != 0) {
					return 1;
				}
			}
			return 0;
		}
	}
}
