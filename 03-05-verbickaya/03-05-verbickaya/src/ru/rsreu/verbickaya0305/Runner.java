package ru.rsreu.verbickaya0305;

import java.util.Scanner;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {

	private Runner() {
	}

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public static void main(String[] args) {

		// Inputting of a data

		Scanner in = new Scanner(System.in);

		System.out.println(resourcer.getString("message.that.input.is.started"));
		System.out.println(resourcer.getString("mesage.to.input.array.length"));
		final int arrayLength = Integer.parseInt(in.next());
		in.nextLine();
		int[] inputingArray = new int[arrayLength];

		System.out.println(resourcer.getString("message.to.input.array.elements"));
		for (int i = 1; i <= arrayLength; i++) {
			System.out.println(resourcer.getString("word.element") + " ¹" + i + ": ");
			inputingArray[i - 1] = Integer.parseInt(in.next());
			in.nextLine();
		}

		System.out.println(resourcer.getString("message.to.input.the.number.of.maximum"));
		System.out.println("MAX_NUM = ");
		final int numberOfMaximum = Integer.parseInt(in.next());
		in.nextLine();
		in.close();

		// Task realization

		StringBuilder resultMessage = new StringBuilder(resourcer.getString("message.that.calculating.is.started"));
		resultMessage.append("\n" + resourcer.getString("message.here.is.original.array") + "\n");
		ArrayWithMaximumsOfAbsoluteValues array = new ArrayWithMaximumsOfAbsoluteValues(inputingArray);
		resultMessage.append(array.toString());
		resultMessage.append(
				"\nMAX_NUM ¹" + numberOfMaximum + " " + resourcer.getString("message.among.absolute.values") + "\n");
		IntNumber resultMaximumValue = array.getMaximumOfElementsAbsoluteValues(numberOfMaximum);
		resultMessage.append(resultMaximumValue.toString());
		System.out.println(resultMessage);

	}

}
