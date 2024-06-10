package ru.rsreu.verbickaya0405;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {
	/**
	 * A dimension of matrix.
	 * 
	 * @see #main(String[])
	 */
	static final int MATRIX_SIZE = 4;
	/**
	 * The bottom border of random generation of matrix elements.
	 * 
	 * @see #main(String[])
	 */
	static final int BOTTOM_BOURDER_OF_GENERATION = -10;
	/**
	 * The bottom border of random generation of matrix elements.
	 * 
	 * @see #main(String[])
	 */
	static final int UPPER_BOURDER_OF_GENERATION = 10;
	private static Resourcer resourcer = ProjectResourcer.getInstance();

	/**
	 * The private constructor of utility class.
	 */
	private Runner() {
	}

	/**
	 * The beginning of program execution.
	 */
	public static void main(String[] args) {

		SquareMatrix matrix = new SquareMatrix(MATRIX_SIZE);
		matrix.fill(BOTTOM_BOURDER_OF_GENERATION, UPPER_BOURDER_OF_GENERATION);
		StringBuilder resultMessage = new StringBuilder(resourcer.getString("message.here.is.an.origin.matrix") + "\n");
		resultMessage.append(matrix.toString() + "\n");

		resultMessage.append(resourcer.getString("message.the.result.of.work") + "\n");

		int above = matrix.getSumAboveMainDiagonal();
		int below = matrix.getSumBelowMainDiagonal();
		resultMessage.append(resourcer.getString("message.the.sum.above.diagonal") + above + "\n");
		resultMessage.append(resourcer.getString("message.the.sum.below.diagonal") + below + "\n");

		int i = matrix.getDifferenceBetweenSumAboveAndBelowMainDiagonal();
		if (i == 0) {
			resultMessage.append(resourcer.getString("message.the.difference.between.sums.is.null"));
		} else {
			resultMessage.append(resourcer.getString("message.the.difference.between.sums") + i);
		}

		System.out.println(resultMessage);

	}

}
