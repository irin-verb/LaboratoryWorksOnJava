package ru.rsreu.verbickaya0505.classes.compositions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0505.classes.other.InvalidParamsException;
import ru.rsreu.verbickaya0505.enums.characteristics.CompositionTypes;
import ru.rsreu.verbickaya0505.enums.characteristics.FolkMusicRegions;
import ru.rsreu.verbickaya0505.enums.styles.FolkMusicStyles;

public class FolkComposition extends AbstractComposition {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private FolkMusicRegions region;

	public FolkComposition(String name, int durationInSeconds, FolkMusicStyles style, String author,
			FolkMusicRegions region) throws InvalidParamsException {
		super(name, durationInSeconds, style, author);
		this.setType();
		this.setRegion(region);
	}

	@Override
	public String toString() {
		String s = super.toString();
		if (!(this.getRegion().toString().equals(""))) {
			s += resourcer.getString("folk.composition.region") + " " + this.getRegion().toString() + "\n";
		}
		return s;
	}

	@Override
	public void setType() {
		super.setType(CompositionTypes.folkComposition);
	}

	public FolkMusicRegions getRegion() {
		return this.region;
	}

	public void setRegion(FolkMusicRegions region) {
		this.region = region;
	}

}
