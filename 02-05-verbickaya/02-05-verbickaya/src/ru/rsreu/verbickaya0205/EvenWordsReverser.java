package ru.rsreu.verbickaya0205;

import java.util.regex.Pattern;

public class EvenWordsReverser {

	private EvenWordsReverser() {
	}

	public static String reverseEvenWords(String originalString) {
		String[] arrayOfWords = EvenWordsReverser.formArrayOfWords(originalString);
		EvenWordsReverser.reverseEvenElements(arrayOfWords);
		String resultString = EvenWordsReverser.formOneString(arrayOfWords);
		return resultString;
	}

	private static String[] formArrayOfWords(final String someString) {
		Pattern spaces = Pattern.compile("\\s+");
		String s = someString.trim();
		String[] resultArray = spaces.split(s);
		return resultArray;
	}

	private static void reverseEvenElements(String[] arrayOfStrings) {
		StringBuilder s;
		for (int i = 0; i < arrayOfStrings.length; i++) {
			if (i % 2 == 1) {
				s = new StringBuilder(arrayOfStrings[i]);
				arrayOfStrings[i] = s.reverse().toString();
			}
		}
	}

	private static String formOneString(final String[] arrayOfStrings) {
		StringBuilder resultString = new StringBuilder("");
		for (int i = 0; i < arrayOfStrings.length; i++) {
			resultString.append(arrayOfStrings[i]);
			if (i != arrayOfStrings.length - 1) {
				resultString.append(" ");
			}
		}
		return resultString.toString();
	}

}
