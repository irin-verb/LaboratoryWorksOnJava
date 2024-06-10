package ru.rsreu.verbickaya0505.enums.styles;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum PopularMusicStyles implements SomeEnum {

	folkMusic {
		public String string() {
			return RESOURCER.getString("popular.style.folkMusic");
		}
	},
	country {
		public String string() {
			return RESOURCER.getString("popular.style.country");
		}
	},
	latinAmericanMusic {
		public String string() {
			return RESOURCER.getString("popular.style.latinAmericanMusic");
		}
	},
	blues {
		public String string() {
			return RESOURCER.getString("popular.style.blues");
		}
	},
	jazz {
		public String string() {
			return RESOURCER.getString("popular.style.jazz");
		}
	},
	electonicMusic {
		public String string() {
			return RESOURCER.getString("popular.style.electonicMusic");
		}
	},
	rock {
		public String string() {
			return RESOURCER.getString("popular.style.rock");
		}
	},
	hipHop {
		public String string() {
			return RESOURCER.getString("popular.style.hipHop");
		}
	},
	reggae {
		public String string() {
			return RESOURCER.getString("popular.style.reggae");
		}
	},
	newWave {
		public String string() {
			return RESOURCER.getString("popular.style.newWave");
		}
	},
	disco {
		public String string() {
			return RESOURCER.getString("popular.style.disco");
		}
	},
	popMusic {
		public String string() {
			return RESOURCER.getString("popular.style.popMusic");
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
