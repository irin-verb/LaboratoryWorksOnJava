package ru.rsreu.verbickaya0505.enums.styles;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum SacredMusicStyles implements SomeEnum {

	Islamic {
		public String string() {
			return RESOURCER.getString("sacred.style.Islamic");
		}
	},
	Jewish {
		public String string() {
			return RESOURCER.getString("sacred.style.Jewish");
		}
	},
	Christian {
		public String string() {
			return RESOURCER.getString("sacred.style.Christian");
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
