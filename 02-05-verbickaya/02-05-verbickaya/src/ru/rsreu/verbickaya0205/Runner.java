package ru.rsreu.verbickaya0205;

import java.util.Scanner;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {

	private Runner() {
	}

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println(resourcer.getString("message.that.input.is.started"));
		System.out.println(resourcer.getString("message.number.of.strings"));
		int stringCount = Integer.parseInt(in.next());
		in.nextLine();

		String[] stringArray = new String[stringCount];
		for (int i = 0; i < stringArray.length; i++) {
			System.out.println(resourcer.getString("message.input.the.string") + (i + 1) + ":");
			stringArray[i] = in.nextLine();
		}

		// Task realization

		System.out.println("\n" + resourcer.getString("message.that.calculating.is.started"));
		for (int i = 0; i < stringArray.length; i++) {
			System.out.println(resourcer.getString("message.is.the.string.with.number") + (i + 1) + ":");
			String resultString = EvenWordsReverser.reverseEvenWords(stringArray[i]);
			System.out.println(Runner.formatString(resultString));
		}

		in.close();

	}

	private static String formatString(String someString) {
		String resultString;
		if (someString.isEmpty()) {
			resultString = resourcer.getString("message.the.string.is.empty");
		} else {
			resultString = someString;
		}
		return resultString;
	}

}
