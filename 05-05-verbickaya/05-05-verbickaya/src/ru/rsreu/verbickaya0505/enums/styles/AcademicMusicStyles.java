package ru.rsreu.verbickaya0505.enums.styles;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum AcademicMusicStyles implements SomeEnum {

	MiddleAges {
		public String string() {
			return RESOURCER.getString("academic.style.MiddleAges");
		}
	},
	Rebirth {
		public String string() {
			return RESOURCER.getString("academic.style.Rebirth");
		}
	},
	Baroque {
		public String string() {
			return RESOURCER.getString("academic.style.Baroque");
		}
	},
	Classicism {
		public String string() {
			return RESOURCER.getString("academic.style.Classicism");
		}
	},
	Romanticism {
		public String string() {
			return RESOURCER.getString("academic.style.Romanticism");
		}
	},
	Modernism {
		public String string() {
			return RESOURCER.getString("academic.style.Modernism");
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
