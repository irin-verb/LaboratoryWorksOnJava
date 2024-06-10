package ru.rsreu.verbickaya0305;

import java.util.Arrays;

public class ArrayWithMaximumsOfAbsoluteValues {
	private int[] arrayBody;

	public ArrayWithMaximumsOfAbsoluteValues(final int... args) {
		this.arrayBody = new int[args.length];
		this.setArrayElements(args);
	}

	public final void setArrayElements(final int... args) {
		System.arraycopy(args, 0, arrayBody, 0, args.length);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.arrayBody);
	}

	public IntNumber getMaximumOfElementsAbsoluteValues(final int numberOfMaximum) {
		int[] arrayOfMaximums = ArrayWithMaximumsOfAbsoluteValues.formArrayOfMaximums(arrayBody);
		IntNumber resultValue;
		if ((numberOfMaximum > 0) && (numberOfMaximum <= arrayOfMaximums.length)) {
			resultValue = new DefinedIntNumber(arrayOfMaximums[numberOfMaximum - 1]);
		} else {
			resultValue = new NullIntNumber();
		}
		return resultValue;
	}

	private static int[] formArrayOfMaximums(final int[] args) {
		int[] additionalArray = Arrays.copyOf(args, args.length);
		ArrayWithMaximumsOfAbsoluteValues.replaceNegativeElementsByPositive(additionalArray);
		Arrays.sort(additionalArray);
		int[] resultArray = ArrayWithMaximumsOfAbsoluteValues.formArrayOfUniqueElements(additionalArray);
		ArrayWithMaximumsOfAbsoluteValues.reverseElements(resultArray);
		return resultArray;
	}

	private static void replaceNegativeElementsByPositive(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				array[i] *= -1;
			}
		}
	}

	private static int[] formArrayOfUniqueElements(final int[] ascSortedArray) {
		int arrayLength = 0;
		for (int i = 0; i < ascSortedArray.length; i++) {
			if ((i == 0) || ((i != 0) && (ascSortedArray[i] > ascSortedArray[i - 1]))) {
				arrayLength++;
			}
		}
		int[] resultArray = new int[arrayLength];
		int j = 0;
		for (int i = 0; i < ascSortedArray.length; i++) {
			if ((i == 0) || ((i != 0) && (ascSortedArray[i] > ascSortedArray[i - 1]))) {
				resultArray[j] = ascSortedArray[i];
				j++;
			}
		}
		return resultArray;
	}

	private static void reverseElements(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int additionalValue = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = additionalValue;
		}
	}
}
