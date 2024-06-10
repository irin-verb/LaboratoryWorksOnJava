package ru.rsreu.verbickaya0505.enums.styles;

import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;

public enum FolkMusicStyles implements SomeEnum {

	laborTune {
		public String string() {
			return RESOURCER.getString("folk.style.laborTune");
		}
	},
	chant {
		public String string() {
			return RESOURCER.getString("folk.style.chant");
		}
	},
	song {
		public String string() {
			return RESOURCER.getString("folk.style.song");
		}
	},
	ritualFolklore {
		public String string() {
			return RESOURCER.getString("folk.style.ritualFolklore");
		}
	},
	epic {
		public String string() {
			return RESOURCER.getString("folk.style.epic");
		}
	},
	spiritualPoem {
		public String string() {
			return RESOURCER.getString("folk.style.spiritualPoem");
		}
	},
	roundDance {
		public String string() {
			return RESOURCER.getString("folk.style.roundDance");
		}
	},
	dance {
		public String string() {
			return RESOURCER.getString("folk.style.dance");
		}
	},
	ditty {
		public String string() {
			return RESOURCER.getString("folk.style.ditty");
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
