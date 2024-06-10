package ru.rsreu.verbickaya0705.householdappliances.basic;

import ru.rsreu.verbickaya0705.householdappliances.other.ComparableApplianceType;

public enum HouseholdApplianceType implements ComparableApplianceType {

	blender {
		public String string() {
			return RESOURCER.getString("appliance.type.blender");
		}
	},
	dishwasher {
		public String string() {
			return RESOURCER.getString("appliance.type.dishwasher");
		}
	},
	mixer {
		public String string() {
			return RESOURCER.getString("appliance.type.mixer");
		}
	},

	steamer {
		public String string() {
			return RESOURCER.getString("appliance.type.steamer");
		}
	},
	refrigerator {
		public String string() {
			return RESOURCER.getString("appliance.type.refrigerator");
		}
	},
	iron {
		public String string() {
			return RESOURCER.getString("appliance.type.iron");
		}
	},

	washingMachine {
		public String string() {
			return RESOURCER.getString("appliance.type.washingMachine");
		}
	};

	@Override
	public String toString() {
		return this.string();
	}

	@Override
	public int compareTo(ComparableApplianceType t) {
		return this.string().compareTo(t.string());
	}

}
