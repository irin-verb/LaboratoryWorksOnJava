package ru.rsreu.verbickaya0505.classes.other;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class TimeInSeconds {

	private static final int MINUT_COEFF = 60;
	private static final int HOUR_COEFF = MINUT_COEFF * 60;
	private static final int DAY_COEFF = HOUR_COEFF * 24;

	private static final int SEC_ARRAY_NUMBER = 0;
	private static final int MINUT_ARRAY_NUMBER = 1;
	private static final int HOUR_ARRAY_NUMBER = 2;
	private static final int DAY_ARRAY_NUMBER = 3;

	private static final int ARRAY_NUMBER = 4;

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private int secTime;
	private int[] formattedTime;

	public TimeInSeconds(int time) {
		this.setTime(time);
		this.stateFormattedTime();
	}

	public void setTime(int time) {
		this.secTime = time;
		this.stateFormattedTime();
	}

	public int getSecTime() {
		return this.secTime;
	}

	@Override
	public String toString() {
		String s = "";
		int day = this.getFormattedTime()[DAY_ARRAY_NUMBER];
		int hour = this.getFormattedTime()[HOUR_ARRAY_NUMBER];
		int min = this.getFormattedTime()[MINUT_ARRAY_NUMBER];
		int sec = this.getFormattedTime()[SEC_ARRAY_NUMBER];
		if (day > 0) {
			s += String.format("%d ", day) + resourcer.getString("time.days") + " ";
		}
		if (hour > 0) {
			s += String.format("%d ", hour) + resourcer.getString("time.hours") + " ";
		}
		if (min > 0) {
			s += String.format("%d ", min) + resourcer.getString("time.minuts") + " ";
		}
		if (sec > 0) {
			s += String.format("%d ", sec) + resourcer.getString("time.seconds");
		}
		return s;
	}

	private void stateFormattedTime() {
		int time = this.getSecTime();
		this.formattedTime = new int[ARRAY_NUMBER];
		this.formattedTime[DAY_ARRAY_NUMBER] = time / TimeInSeconds.DAY_COEFF;
		time %= TimeInSeconds.DAY_COEFF;
		this.formattedTime[HOUR_ARRAY_NUMBER] = time / TimeInSeconds.HOUR_COEFF;
		time %= TimeInSeconds.HOUR_COEFF;
		this.formattedTime[MINUT_ARRAY_NUMBER] = time / TimeInSeconds.MINUT_COEFF;
		time %= TimeInSeconds.MINUT_COEFF;
		this.formattedTime[SEC_ARRAY_NUMBER] = time;
	}

	private int[] getFormattedTime() {
		return this.formattedTime;
	}

}
