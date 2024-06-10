package ru.rsreu.verbickaya0505.enums.characteristics;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum AcademicMusicMoods implements SomeEnum {

	tragic {
		public String string() {
			return RESOURCER.getString("academic.mood.tragic");
		}
	},
	lyric {
		public String string() {
			return RESOURCER.getString("academic.mood.lyric");
		}
	},
	joyful {
		public String string() {
			return RESOURCER.getString("academic.mood.joyful");
		}
	},
	contemplative {
		public String string() {
			return RESOURCER.getString("academic.mood.contemplative");
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
