package ru.rsreu.verbickaya0505.classes.compositions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0505.classes.other.InvalidParamsException;
import ru.rsreu.verbickaya0505.enums.characteristics.CompositionTypes;
import ru.rsreu.verbickaya0505.enums.styles.SacredMusicStyles;

public class SacredComposition extends AbstractComposition {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private String religionText;

	public SacredComposition(String name, int durationInSeconds, SacredMusicStyles style, String author,
			String religionText) throws InvalidParamsException {
		super(name, durationInSeconds, style, author);
		this.setType();
		this.religionText = religionText;
	}

	@Override
	public String toString() {
		String s = super.toString();
		if (!(this.getReligionText().equals(""))) {
			s += resourcer.getString("sacred.composition.religionText") + " " + this.getReligionText() + "\n";
		}
		return s;
	}

	@Override
	public void setType() {
		super.setType(CompositionTypes.sacredComposition);
	}

	public String getReligionText() {
		return this.religionText;
	}

	public void setReligionText(String religionText) {
		this.religionText = religionText;
	}
}
