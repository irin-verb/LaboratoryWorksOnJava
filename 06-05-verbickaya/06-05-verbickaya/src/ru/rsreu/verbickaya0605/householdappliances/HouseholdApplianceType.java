package ru.rsreu.verbickaya0605.householdappliances;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public enum HouseholdApplianceType {
	blender {
		public String string() {
			return resourcer.getString("appliance.type.blender");
		}
	},
	dishwasher {
		public String string() {
			return resourcer.getString("appliance.type.dishwasher");
		}
	},
	mixer {
		public String string() {
			return resourcer.getString("appliance.type.mixer");
		}
	},
	refrigerator {
		public String string() {
			return resourcer.getString("appliance.type.refrigerator");
		}
	},
	steamer {
		public String string() {
			return resourcer.getString("appliance.type.steamer");
		}
	},
	iron {
		public String string() {
			return resourcer.getString("appliance.type.iron");
		}
	},
	washingMachine {
		public String string() {
			return resourcer.getString("appliance.type.washingMachine");
		}
	};

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	abstract String string();

	@Override
	public String toString() {
		return this.string();
	}

	public static HouseholdApplianceType toType(String type) {
		if (type.equals(HouseholdApplianceType.blender.toString())) {
			return HouseholdApplianceType.blender;
		} else if (type.equals(HouseholdApplianceType.dishwasher.toString())) {
			return HouseholdApplianceType.dishwasher;
		} else if (type.equals(HouseholdApplianceType.mixer.toString())) {
			return HouseholdApplianceType.mixer;
		} else if (type.equals(HouseholdApplianceType.refrigerator.toString())) {
			return HouseholdApplianceType.refrigerator;
		} else if (type.equals(HouseholdApplianceType.steamer.toString())) {
			return HouseholdApplianceType.steamer;
		} else if (type.equals(HouseholdApplianceType.iron.toString())) {
			return HouseholdApplianceType.iron;
		} else if (type.equals(HouseholdApplianceType.washingMachine.toString())) {
			return HouseholdApplianceType.washingMachine;
		} else {
			return null;
		}
	}
}
