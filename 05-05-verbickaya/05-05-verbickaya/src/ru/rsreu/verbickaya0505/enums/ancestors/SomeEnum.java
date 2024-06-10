package ru.rsreu.verbickaya0505.enums.ancestors;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public interface SomeEnum {

	Resourcer RESOURCER = ProjectResourcer.getInstance();

	String string();

	String toString();

	int compareTo(SomeEnum style);
}
