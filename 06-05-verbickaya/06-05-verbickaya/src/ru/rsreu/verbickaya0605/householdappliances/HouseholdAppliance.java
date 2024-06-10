package ru.rsreu.verbickaya0605.householdappliances;

public class HouseholdAppliance implements Comparable<HouseholdAppliance> {

	private String brand;
	private String model;
	private HouseholdApplianceType type;

	public HouseholdAppliance(String brand, String model, HouseholdApplianceType type) {
		this.setBrand(brand.trim());
		this.setModel(model.trim());
		this.setType(type);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public HouseholdApplianceType getType() {
		return type;
	}

	public void setType(HouseholdApplianceType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		int code = this.getBrand().length() * this.getModel().length() + this.getType().toString().length();
		return code;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof HouseholdAppliance)) {
			return false;
		}
		HouseholdAppliance obj = (HouseholdAppliance) o;
		return (this.compareTo(obj) == 0);
	}

	@Override
	public String toString() {
		String s = "";
		s += this.getType().toString() + " \"" + this.getBrand() + " " + this.getModel() + "\"\n";
		return s;
	}

	@Override
	public int compareTo(HouseholdAppliance o) {
		if (o == this) {
			return 0;
		} else {
			if (this.getType() == this.getType()) {
				if (this.getBrand().equals(o.getBrand())) {
					return this.getModel().compareTo(o.getModel());
				} else {
					return this.getBrand().compareTo(o.getBrand());
				}
			} else {
				return this.getType().compareTo(o.getType());
			}
		}

	}

}
