package ru.rsreu.verbickaya0505.classes.compositions;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0505.classes.other.InvalidParamsException;
import ru.rsreu.verbickaya0505.enums.characteristics.CompositionTypes;
import ru.rsreu.verbickaya0505.enums.characteristics.PopularMusicVersions;
import ru.rsreu.verbickaya0505.enums.styles.PopularMusicStyles;

public class PopularComposition extends AbstractComposition {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private String album;
	private PopularMusicVersions version;

	public PopularComposition(String name, int durationInSeconds, PopularMusicStyles style, String author, String album,
			PopularMusicVersions version) throws InvalidParamsException {
		super(name, durationInSeconds, style, author);
		this.setType();
		this.setAlbum(album);
		this.setVersion(version);
	}

	@Override
	public String toString() {
		String s = super.toString();
		if (!(this.getAlbum().equals(""))) {
			s += resourcer.getString("popular.composition.album") + " " + this.getAlbum() + "\n";
		}
		if (!(this.getVersion().toString().equals(""))) {
			s += resourcer.getString("popular.composition.version") + " " + this.getVersion().toString() + "\n";
		}
		return s;
	}

	@Override
	public void setType() {
		super.setType(CompositionTypes.popularComposition);
	}

	public PopularMusicVersions getVersion() {
		return this.version;
	}

	public String getAlbum() {
		return this.album;
	}

	public void setVersion(PopularMusicVersions version) {
		this.version = version;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

}
