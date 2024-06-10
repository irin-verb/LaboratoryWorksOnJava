package ru.rsreu.verbickaya0505.classes.compositions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0505.classes.other.InvalidParamsException;
import ru.rsreu.verbickaya0505.classes.other.TimeInSeconds;
import ru.rsreu.verbickaya0505.enums.ancestors.SomeEnum;
import ru.rsreu.verbickaya0505.enums.characteristics.CompositionTypes;

public abstract class AbstractComposition implements Comparable<AbstractComposition> {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private String name;
	private TimeInSeconds duration;
	private SomeEnum style;
	private String author;
	private CompositionTypes type;

	public AbstractComposition(String name, int durationInSeconds, SomeEnum style, String author)
			throws InvalidParamsException {
		if (("".equals(name)) || (name == null)) {
			throw new InvalidParamsException(resourcer.getString("composition.with.no.name"));
		}
		if (durationInSeconds <= 0) {
			throw new InvalidParamsException(resourcer.getString("composition.with.wrong.duration"));
		}
		this.setName(name);
		this.setDuration(durationInSeconds);
		this.setStyle(style);
		this.setAuthor(author);
		this.setType();
	}

	@Override
	public String toString() {
		String s = "";
		s += resourcer.getString("composition.name") + " " + this.getName() + "\n";
		s += resourcer.getString("composition.type") + " " + this.getType().toString() + "\n";
		s += resourcer.getString("composition.duration") + " " + this.getDuration().toString() + "\n";
		s += resourcer.getString("composition.style") + " " + this.getStyle().toString() + "\n";
		if (!(this.getAuthor().equals(""))) {
			s += resourcer.getString("composition.author") + " " + this.getAuthor() + "\n";
		}
		return s;
	}

	@Override
	public int compareTo(AbstractComposition c) {
		if (c == this) {
			return 0;
		} else {
			if (c.getClass() != this.getClass()) {
				return this.getType().compareTo(c.getType());
			} else {
				return this.getStyle().compareTo(c.getStyle());
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public TimeInSeconds getDuration() {
		return this.duration;
	}

	public SomeEnum getStyle() {
		return this.style;
	}

	public String getAuthor() {
		return this.author;
	}

	public CompositionTypes getType() {
		return this.type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDuration(int durationInSeconds) {
		this.duration = new TimeInSeconds(durationInSeconds);
	}

	public void setStyle(SomeEnum style) {
		this.style = style;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public abstract void setType();

	protected void setType(CompositionTypes type) {
		this.type = type;
	}
}
