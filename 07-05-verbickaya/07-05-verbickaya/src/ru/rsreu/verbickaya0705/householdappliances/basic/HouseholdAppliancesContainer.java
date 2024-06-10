package ru.rsreu.verbickaya0705.householdappliances.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0705.householdappliances.comparators.HouseholdApplianceDefaultComparator;
import ru.rsreu.verbickaya0705.householdappliances.comparators.HouseholdApplianceModelTypeComparator;
import ru.rsreu.verbickaya0705.householdappliances.other.Appliance;
import ru.rsreu.verbickaya0705.householdappliances.other.NullHouseholdAppliance;
import ru.rsreu.verbickaya0705.utilities.StringOfTableFormer;

public class HouseholdAppliancesContainer {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private List<HouseholdAppliance> items;

	public HouseholdAppliancesContainer(HouseholdAppliance... args) {
		this.items = new ArrayList<HouseholdAppliance>();
		this.addItems(args);
	}

	public HouseholdAppliancesContainer(List<HouseholdAppliance> args) {
		this.items = new ArrayList<HouseholdAppliance>();
		this.addItems(args);
	}

	public void addItems(HouseholdAppliance... args) {
		for (HouseholdAppliance item : args) {
			if (!this.isInItemsBrands(item)) {
				this.items.add(item);
			}
		}
	}

	public void addItems(List<HouseholdAppliance> args) {
		Iterator<HouseholdAppliance> iterator = args.iterator();
		while (iterator.hasNext()) {
			HouseholdAppliance item = iterator.next();
			if (!this.isInItemsBrands(item)) {
				this.items.add(item);
			}
		}
	}

	public HouseholdAppliancesContainer sortedByDefault() {
		Comparator<HouseholdAppliance> comparator = new HouseholdApplianceDefaultComparator();
		List<HouseholdAppliance> list = new ArrayList<HouseholdAppliance>();
		list = this.items;
		Collections.sort(list, comparator);
		return new HouseholdAppliancesContainer(list);
	}

	public HouseholdAppliancesContainer sortedByModelType() {
		Comparator<HouseholdAppliance> comparator = new HouseholdApplianceModelTypeComparator();
		List<HouseholdAppliance> list = new ArrayList<HouseholdAppliance>();
		list = this.items;
		Collections.sort(list, comparator);
		return new HouseholdAppliancesContainer(list);
	}

	public Set<String> getUniqueModels() {
		Iterator<HouseholdAppliance> iterator = this.items.iterator();
		Set<String> models = new HashSet<String>();
		while (iterator.hasNext()) {
			HouseholdAppliance item = iterator.next();
			models.add(item.getModel());
		}
		return models;
	}

	public HouseholdAppliancesContainer deletedByType(HouseholdApplianceType type) {
		List<HouseholdAppliance> list = new ArrayList<HouseholdAppliance>();
		list = this.items;
		Iterator<HouseholdAppliance> iterator = list.iterator();
		while (iterator.hasNext()) {
			HouseholdAppliance item = iterator.next();
			if (item.getType().compareTo(type) == 0) {
				iterator.remove();
			}
		}
		return new HouseholdAppliancesContainer(list);
	}

	public Appliance searchByBrand(String brand) {
		Map<String, HouseholdAppliance> map = this.getMapOfBrandsAndAppliances();
		if (map.containsKey(brand)) {
			return map.get(brand);
		} else {
			return new NullHouseholdAppliance();
		}
	}

	public String toStringTable() {
		final int columnWidth = 22;
		String header = StringOfTableFormer.formStringOfTable(columnWidth, resourcer.getString("appliance.type"),
				resourcer.getString("appliance.brand"), resourcer.getString("appliance.model")) + "\n";
		StringBuilder resultString = new StringBuilder(header);
		Iterator<HouseholdAppliance> iterator = this.items.iterator();
		while (iterator.hasNext()) {
			HouseholdAppliance item = iterator.next();
			resultString.append(StringOfTableFormer.formStringOfTable(columnWidth, item.getType().toString(),
					item.getBrand(), item.getModel()) + "\n");
		}
		return resultString.toString();
	}

	@Override
	public String toString() {
		StringBuilder resultString = new StringBuilder();
		Iterator<HouseholdAppliance> iterator = this.items.iterator();
		while (iterator.hasNext()) {
			HouseholdAppliance string = iterator.next();
			resultString.append(string.toString() + "\n");
		}
		return resultString.toString();
	}

	private Map<String, HouseholdAppliance> getMapOfBrandsAndAppliances() {
		Map<String, HouseholdAppliance> resultMap = new HashMap<String, HouseholdAppliance>();
		Iterator<HouseholdAppliance> iterator = this.items.iterator();
		while (iterator.hasNext()) {
			HouseholdAppliance item = iterator.next();
			resultMap.put(item.getBrand(), item);
		}
		return resultMap;
	}

	private boolean isInItemsBrands(HouseholdAppliance someItem) {
		Iterator<HouseholdAppliance> iterator = this.items.iterator();
		while (iterator.hasNext()) {
			HouseholdAppliance item = iterator.next();
			if (item.getBrand().equals(someItem.getBrand())) {
				return true;
			}
		}
		return false;
	}

}
