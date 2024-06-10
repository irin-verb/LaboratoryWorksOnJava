package ru.rsreu.verbickaya0605.basic;

import java.util.Scanner;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0605.exceptions.FixableException;
import ru.rsreu.verbickaya0605.exceptions.IrreparableException;

public class Runner {

	private Runner() {
	}

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public static void main(String[] args) {
		try {

			// 1 Creating folders structure
			System.out.print(resourcer.getString("step.creating.folders") + "\n");
			Initializer.initializeFolders();

			// 2 Creating and initializing of objects` array
			System.out.print(resourcer.getString("step.creating.array") + "\n");
			try {
				Initializer.initializeArray();
			} catch (FixableException exception) {
				System.out.print(exception.toString());
			}

			// 3 Creating of a file and filling it with array
			System.out.print(resourcer.getString("step.creating.filling.file") + "\n");
			Initializer.initializeFile();

			// 4 Creating of a copy file
			System.out.print(resourcer.getString("step.creating.copy.file") + "\n");
			Initializer.initializeCopyFile();

			// 5 Moving copy file
			System.out.print(resourcer.getString("step.moving.file") + "\n");
			System.out.print(resourcer.getString("message.press.f") + "\n");
			Scanner in = new Scanner(System.in);
			String key = in.next();
			Initializer.initializeMoveFile(key.trim().toLowerCase().equals("f"));
			in.close();

			// 6 Reading source file and copy file to arrays

			System.out.print(resourcer.getString("step.reading.files") + "\n");
			try {
				Initializer.initializeReadingToArrays();
			} catch (FixableException exception) {
				System.out.print(exception.toString());
			}

			// 7 Output arrays on a tables
			System.out.print(resourcer.getString("step.output.arrays") + "\n");
			System.out.print(Initializer.getArray1().toStringTable());
			System.out.print(Initializer.getArray2().toStringTable());

			// 8 Comparing arrays
			System.out.print(resourcer.getString("step.compare.arrays") + "\n");
			if (Initializer.getArray1().compareTo(Initializer.getArray2()) == 0) {
				System.out.print(resourcer.getString("message.arrays.are.equal") + "\n");
			} else {
				System.out.print(resourcer.getString("message.arrays.not.equal") + "\n");
			}

		} catch (IrreparableException exception) {
			System.out.print(exception.toString());
		} catch (Throwable exception) {
			System.out.print("\n" + resourcer.getString("error.unexpected"));
		} finally {
			System.out.print(resourcer.getString("message.the.end"));
		}
	}

}
