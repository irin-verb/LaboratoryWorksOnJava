package ru.rsreu.verbickaya0505.enums.characteristics;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum CompositionTypes implements SomeEnum {

	academicComposition {
		public String string() {
			return RESOURCER.getString("composition.type.academic");
		}
	},
	folkComposition {
		public String string() {
			return RESOURCER.getString("composition.type.folk");
		}
	},
	popularComposition {
		public String string() {
			return RESOURCER.getString("composition.type.popular");
		}
	},
	sacredComposition {
		public String string() {
			return RESOURCER.getString("composition.type.sacred");
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
