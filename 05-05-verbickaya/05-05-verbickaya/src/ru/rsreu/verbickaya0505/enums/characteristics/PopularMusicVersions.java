package ru.rsreu.verbickaya0505.enums.characteristics;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum PopularMusicVersions implements SomeEnum {

	speedUp {
		public String string() {
			return RESOURCER.getString("popular.version.speedUp");
		}
	},
	nightcore {
		public String string() {
			return RESOURCER.getString("popular.version.nightcore");
		}
	},
	slowed {
		public String string() {
			return RESOURCER.getString("popular.version.slowed");
		}
	},
	reverb {
		public String string() {
			return RESOURCER.getString("popular.version.reverb");
		}
	},
	bassBoosted {
		public String string() {
			return RESOURCER.getString("popular.version.bassBoosted");
		}
	},
	phonk {
		public String string() {
			return RESOURCER.getString("popular.version.phonk");
		}
	},
	none {
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
