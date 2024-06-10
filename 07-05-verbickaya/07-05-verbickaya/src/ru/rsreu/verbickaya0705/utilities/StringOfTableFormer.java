package ru.rsreu.verbickaya0705.utilities;

public class StringOfTableFormer {

	private StringOfTableFormer() {
	}

	private static final String SEPARATOR = "|";

	public static String formStringOfTable(int columnWidth, String... args) {
		StringBuilder resultString = new StringBuilder(StringOfTableFormer.SEPARATOR);
		for (String item : args) {
			resultString.append(StringOfTableFormer.completeBySpaces(columnWidth, item));
			resultString.append(StringOfTableFormer.SEPARATOR);
		}
		return resultString.toString();
	}

	private static String completeBySpaces(int spacesCount, String string) {
		StringBuilder resultString = new StringBuilder(string);
		for (int i = 0; i < spacesCount - string.length(); i++) {
			resultString.append(" ");
		}
		return resultString.toString();
	}

}
