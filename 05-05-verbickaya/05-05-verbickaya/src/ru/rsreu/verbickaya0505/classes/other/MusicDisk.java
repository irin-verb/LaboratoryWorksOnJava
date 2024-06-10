package ru.rsreu.verbickaya0505.classes.other;

import java.util.Arrays;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0505.classes.compositions.AbstractComposition;

public class MusicDisk {

	private static final String COMPOSITION_SEPARATOR = "~~~~~~~~~~~~~~~~\n";
	private static final String DISK_SEPARATOR = "^^^^^^^^^^^^^^^^\n";

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private AbstractComposition[] compositions;
	private TimeInSeconds duration;

	public MusicDisk(AbstractComposition... args) {
		this.compositions = new AbstractComposition[0];
		this.addCompositions(args);
	}

	public void addCompositions(AbstractComposition... args) {
		int oldLength = this.compositions.length;
		int addingLength = args.length;
		int newLength = oldLength + addingLength;
		AbstractComposition[] newArray = new AbstractComposition[newLength];
		System.arraycopy(this.compositions, 0, newArray, 0, oldLength);
		System.arraycopy(args, 0, newArray, oldLength, addingLength);
		this.compositions = new AbstractComposition[newLength];
		System.arraycopy(newArray, 0, this.compositions, 0, newLength);
		this.stateDuration();
	}

	public TimeInSeconds getDuration() {
		return this.duration;
	}

	public void sortByStyle() {
		Arrays.sort(this.compositions);
	}

	public AbstractComposition[] searchByName(String name) {
		int length = this.countEntranceOfName(name);
		AbstractComposition[] array = new AbstractComposition[length];
		int i = 0;
		for (AbstractComposition element : this.compositions) {
			if (element.getName().equals(name)) {
				array[i] = element;
				i++;
			}
		}
		return array;
	}

	public String stringOfSearchedByName(String name) {
		String s = "\n" + resourcer.getString("the.result.of.search.by.name") + " \"" + name + "\":\n";
		AbstractComposition[] array = this.searchByName(name);
		if (array.length == 0) {
			s += resourcer.getString("search.returned.no.results");
		} else {
			for (AbstractComposition item : array) {
				s += MusicDisk.COMPOSITION_SEPARATOR;
				s += item.toString();
			}
		}
		return s;
	}

	@Override
	public String toString() {
		String s = "\n";
		s += MusicDisk.DISK_SEPARATOR + resourcer.getString("here.is.disk.of.compositions") + "\n";
		s += resourcer.getString("general.duration.of.compositions") + " " + this.getDuration().toString() + "\n";
		for (int i = 0; i < this.compositions.length; i++) {
			s += MusicDisk.COMPOSITION_SEPARATOR;
			s += resourcer.getString("here.is.composition");
			s += String.format(" ¹ %d ", i + 1) + "\n";
			s += this.compositions[i].toString();
		}
		return s;
	}

	private void stateDuration() {
		int generalDuration = 0;
		for (AbstractComposition element : this.compositions) {
			generalDuration += element.getDuration().getSecTime();
		}
		this.duration = new TimeInSeconds(generalDuration);
	}

	private int countEntranceOfName(String name) {
		int count = 0;
		for (AbstractComposition element : this.compositions) {
			if (element.getName().equals(name)) {
				count++;
			}
		}
		return count;
	}

}
