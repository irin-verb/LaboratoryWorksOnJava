package ru.rsreu.verbickaya0505.classes.compositions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0505.classes.other.InvalidParamsException;
import ru.rsreu.verbickaya0505.enums.characteristics.AcademicMusicMoods;
import ru.rsreu.verbickaya0505.enums.characteristics.CompositionTypes;
import ru.rsreu.verbickaya0505.enums.styles.AcademicMusicStyles;

public class AcademicComposition extends AbstractComposition {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private AcademicMusicMoods mood;
	private String orchestra;

	public AcademicComposition(String name, int durationInSeconds, AcademicMusicStyles style, String author,
			AcademicMusicMoods mood, String orchestra) throws InvalidParamsException {
		super(name, durationInSeconds, style, author);
		this.setType();
		this.setMood(mood);
		this.setOrchestra(orchestra);
	}

	@Override
	public String toString() {
		String s = super.toString();
		if (!(this.getMood().toString().equals(""))) {
			s += resourcer.getString("academic.composition.mood") + " " + this.getMood().toString() + "\n";
		}
		if (!(this.getOrchestra().equals(""))) {
			s += resourcer.getString("academic.composition.orchestra") + " " + this.getOrchestra() + "\n";
		}

		return s;
	}

	@Override
	public void setType() {
		super.setType(CompositionTypes.academicComposition);
	}

	public AcademicMusicMoods getMood() {
		return this.mood;
	}

	public String getOrchestra() {
		return this.orchestra;
	}

	public void setMood(AcademicMusicMoods mood) {
		this.mood = mood;
	}

	public void setOrchestra(String orchestra) {
		this.orchestra = orchestra;
	}

}
