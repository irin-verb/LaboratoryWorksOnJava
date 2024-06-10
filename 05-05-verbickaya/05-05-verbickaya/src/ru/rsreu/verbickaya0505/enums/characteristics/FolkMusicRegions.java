package ru.rsreu.verbickaya0505.enums.characteristics;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum FolkMusicRegions implements SomeEnum {

	Australia {
		public String string() {
			return RESOURCER.getString("folk.region.Australia");
		}
	},
	Africa {
		public String string() {
			return RESOURCER.getString("folk.region.Africa");
		}
	},
	CentralAsia {
		public String string() {
			return RESOURCER.getString("folk.region.CentralAsia");
		}
	},
	EastAndSouthAsia {
		public String string() {
			return RESOURCER.getString("folk.region.EastAndSouthAsia");
		}
	},
	NearEast {
		public String string() {
			return RESOURCER.getString("folk.region.NearEast");
		}
	},
	CaucasusAndTranscaucasia {
		public String string() {
			return RESOURCER.getString("folk.region.CaucasusAndTranscaucasia");
		}
	},
	EasternEurope {
		public String string() {
			return RESOURCER.getString("folk.region.EasternEurope");
		}
	},
	WesternEurope {
		public String string() {
			return RESOURCER.getString("folk.region.WesternEurope");
		}
	},
	LatinAmerica {
		public String string() {
			return RESOURCER.getString("folk.region.LatinAmerica");
		}
	},
	NorthAndSouthAmerica {
		public String string() {
			return RESOURCER.getString("folk.region.NorthAndSouthAmerica");
		}
	},
	None {
		public String string() {
			return "";
		}
	};

	@Override
	public String toString() {
		return this.string();
	}

	@Override
	public int compareTo(SomeEnum style) {
		return this.string().compareTo(style.string());
	}
}
