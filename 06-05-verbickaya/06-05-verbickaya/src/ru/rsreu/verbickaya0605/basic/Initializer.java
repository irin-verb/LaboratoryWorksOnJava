package ru.rsreu.verbickaya0605.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.verbickaya0605.exceptions.FixableException;
import ru.rsreu.verbickaya0605.exceptions.IrreparableException;
import ru.rsreu.verbickaya0605.householdappliances.HouseholdAppliance;
import ru.rsreu.verbickaya0605.householdappliances.HouseholdApplianceType;
import ru.rsreu.verbickaya0605.householdappliances.HouseholdAppliancesStorage;

public class Initializer {

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	private Initializer() {
	}

	private static final String ROOT = System.getProperty("user.dir");

	private static boolean moved;
	private static HouseholdAppliance appliance1;
	private static HouseholdAppliance appliance2;
	private static HouseholdAppliance appliance3;
	private static HouseholdAppliance appliance4;
	private static HouseholdAppliance appliance5;
	private static File folder1;
	private static File folder2;
	private static File myFile;
	private static File myFileCopy;
	private static HouseholdAppliancesStorage array;
	private static HouseholdAppliancesStorage array1;
	private static HouseholdAppliancesStorage array2;

	public static HouseholdAppliancesStorage getArray() {
		return Initializer.array;
	}

	public static HouseholdAppliancesStorage getArray1() {
		return Initializer.array1;
	}

	public static HouseholdAppliancesStorage getArray2() {
		return Initializer.array2;
	}

	public static void initializeFolders() throws IrreparableException {
		Initializer.folder1 = new File(FilePathFormer.formPath(Initializer.ROOT,
				resourcer.getString("files.folder.source.name"), resourcer.getString("files.folder.copy.name")));
		Initializer.folder2 = new File(
				FilePathFormer.formPath(Initializer.ROOT, resourcer.getString("files.folder.move.name")));
		if ((!(Initializer.folder1.mkdirs())) && (!(Initializer.folder1.exists()))
				|| (!(Initializer.folder2.mkdirs())) && (!(Initializer.folder2.exists()))) {
			throw new IrreparableException(resourcer.getString("error.reason.wrong.folder.names"));
		}
	}

	public static void initializeArray() throws FixableException {
		Initializer.appliance1 = new HouseholdAppliance("Samsung", "RB37A5000WW", HouseholdApplianceType.refrigerator);
		Initializer.appliance2 = new HouseholdAppliance("Philips", "DST3010/30", HouseholdApplianceType.iron);
		Initializer.appliance3 = new HouseholdAppliance("Bosch", "SMS23BW01T", HouseholdApplianceType.dishwasher);
		Initializer.appliance4 = new HouseholdAppliance("REDMOND", "RHB-2964", HouseholdApplianceType.blender);
		Initializer.appliance5 = new HouseholdAppliance("Polaris", "PGS 2200VA", HouseholdApplianceType.steamer);
		Initializer.array = new HouseholdAppliancesStorage(Initializer.appliance1, Initializer.appliance2,
				Initializer.appliance3, Initializer.appliance4, Initializer.appliance5);
	}

	public static void initializeFile() throws IrreparableException {
		String filePath = FilePathFormer.formPath(resourcer.getString("files.folder.source.name"),
				resourcer.getString("files.file.data.name") + "." + resourcer.getString("files.file.text.extension"));
		String fileFullPath = FilePathFormer.formPath(Initializer.ROOT, filePath);
		Initializer.myFile = new File(filePath);
		BufferedWriter writer = null;
		try {
			if (Initializer.myFile.exists()) {
				Initializer.myFile.delete();
			}
			Initializer.myFile.createNewFile();
			writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(Initializer.array.toString());
		} catch (FileNotFoundException exception) {
			throw new IrreparableException(resourcer.getString("error.reason.wrong.directory") + " " + fileFullPath);
		} catch (IOException exception) {
			throw new IrreparableException(resourcer.getString("error.reason.wrong.writing") + " " + fileFullPath);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException exception) {
					throw new IrreparableException(
							resourcer.getString("error.reason.wrong.write.closing") + " " + fileFullPath);
				}
			}
		}
	}

	public static void initializeCopyFile() throws IrreparableException {
		String sourcePath = FilePathFormer.formPath(resourcer.getString("files.folder.source.name"),
				resourcer.getString("files.file.data.name") + "." + resourcer.getString("files.file.text.extension"));
		String destinationPath = FilePathFormer.formPath(resourcer.getString("files.folder.source.name"),
				resourcer.getString("files.folder.copy.name"),
				resourcer.getString("files.file.data.name") + "." + resourcer.getString("files.file.text.extension"));
		String fullDestinationPath = FilePathFormer.formPath(Initializer.ROOT, destinationPath);
		Initializer.myFileCopy = new File(destinationPath);
		try {
			if (Initializer.myFileCopy.exists()) {
				Initializer.myFileCopy.delete();
			}
			Initializer.myFileCopy.createNewFile();
		} catch (IOException exception) {
			throw new IrreparableException(
					resourcer.getString("error.reason.wrong.directory") + " " + fullDestinationPath);
		}
		String textFromFile = Initializer.readTextFromFile(sourcePath);
		Initializer.writeTextToFile(textFromFile, destinationPath);
		String newFileName = FilePathFormer.formPath(resourcer.getString("files.folder.source.name"),
				resourcer.getString("files.folder.copy.name"),
				resourcer.getString("files.file.data.name") + "." + resourcer.getString("files.file.backup.extension"));
		File newBakFile = new File(newFileName);
		if (newBakFile.exists()) {
			newBakFile.delete();
		}
		if (!Initializer.myFileCopy.renameTo(newBakFile)) {
			throw new IrreparableException(
					resourcer.getString("error.reason.wrong.renaming") + " " + fullDestinationPath);
		}
	}

	public static void initializeMoveFile(boolean key) throws IrreparableException {
		String sourcePath = FilePathFormer.formPath(resourcer.getString("files.folder.source.name"),
				resourcer.getString("files.file.data.name") + "." + resourcer.getString("files.file.text.extension"));
		String destinationPath = FilePathFormer.formPath(resourcer.getString("files.folder.move.name"),
				resourcer.getString("files.file.data.name") + "." + resourcer.getString("files.file.text.extension"));
		String fullDestinationPath = FilePathFormer.formPath(Initializer.ROOT, destinationPath);
		File myFileMove = new File(destinationPath);
		Initializer.moved = key;
		if (key) {
			try {
				if (myFileMove.exists()) {
					myFileMove.delete();
				}
				myFileMove.createNewFile();
			} catch (IOException exception) {
				throw new IrreparableException(
						resourcer.getString("error.reason.wrong.directory") + " " + fullDestinationPath);
			}
			String textFromFile = Initializer.readTextFromFile(sourcePath);
			Initializer.writeTextToFile(textFromFile, destinationPath);
			Initializer.myFile.delete();
			Initializer.myFile = myFileMove;
		} else {
			if (myFileMove.exists()) {
				myFileMove.delete();
			}
		}

	}

	public static void initializeReadingToArrays() throws FixableException, IrreparableException {
		String path1;
		if (Initializer.moved) {
			path1 = FilePathFormer.formPath(resourcer.getString("files.folder.move.name"),
					resourcer.getString("files.file.data.name") + "."
							+ resourcer.getString("files.file.text.extension"));
		} else {
			path1 = FilePathFormer.formPath(resourcer.getString("files.folder.source.name"),
					resourcer.getString("files.file.data.name") + "."
							+ resourcer.getString("files.file.text.extension"));
		}
		String path2 = FilePathFormer.formPath(resourcer.getString("files.folder.source.name"),
				resourcer.getString("files.folder.copy.name"),
				resourcer.getString("files.file.data.name") + "." + resourcer.getString("files.file.backup.extension"));

		Initializer.array1 = Initializer.formStorageFromFile(path1);
		Initializer.array2 = Initializer.formStorageFromFile(path2);
	}

	private static String readTextFromFile(String sourcePath) throws IrreparableException {
		String fullSourcePath = FilePathFormer.formPath(Initializer.ROOT, sourcePath);
		BufferedReader reader = null;
		StringBuilder textFromFile = new StringBuilder();
		String string;
		try {
			reader = new BufferedReader(new FileReader(sourcePath));
			while ((string = reader.readLine()) != null) {
				textFromFile.append(string + "\n");
			}
		} catch (FileNotFoundException exception) {
			throw new IrreparableException(resourcer.getString("error.reason.wrong.directory") + " " + fullSourcePath);
		} catch (IOException exception) {
			throw new IrreparableException(resourcer.getString("error.reason.wrong.reading") + " " + fullSourcePath);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException exception) {
					throw new IrreparableException(
							resourcer.getString("error.reason.wrong.read.closing") + " " + fullSourcePath);
				}
			}
		}
		return textFromFile.toString();
	}

	private static void writeTextToFile(String someText, String destinationPath) throws IrreparableException {
		String fullDestinationPath = FilePathFormer.formPath(Initializer.ROOT, destinationPath);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(destinationPath));
			writer.write(someText);
		} catch (FileNotFoundException exception) {
			throw new IrreparableException(
					resourcer.getString("error.reason.wrong.directory") + " " + fullDestinationPath);
		} catch (IOException exception) {
			throw new IrreparableException(
					resourcer.getString("error.reason.wrong.writing") + " " + fullDestinationPath);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException exception) {
					throw new IrreparableException(
							resourcer.getString("error.reason.wrong.write.closing") + " " + fullDestinationPath);
				}
			}
		}
	}

	private static HouseholdAppliancesStorage formStorageFromFile(String sourcePath)
			throws FixableException, IrreparableException {
		String fileText = Initializer.readTextFromFile(sourcePath);
		HouseholdAppliancesStorage resultStorage = new HouseholdAppliancesStorage();
		HouseholdAppliance item;
		StringBuilder brand = new StringBuilder();
		StringBuilder model = new StringBuilder();
		StringBuilder type = new StringBuilder();
		int flag = 0;
		for (int i = 0; i < fileText.length(); i++) {
			if ((fileText.charAt(i) == '\"')) {
				flag = 1;
			}
			if ((flag == 1) && (fileText.charAt(i) == ' ')) {
				flag = 2;
			}
			if (fileText.charAt(i) == '\n') {
				flag = 0;
				if (HouseholdApplianceType.toType(type.toString().trim()) == null) {
					throw new IrreparableException("error.reason.invalid.file.content" + " " + sourcePath);
				} else {
					item = new HouseholdAppliance(brand.toString().trim(), model.toString().trim(),
							HouseholdApplianceType.toType(type.toString().trim()));
					resultStorage.addItem(item);
				}
				type = new StringBuilder();
				brand = new StringBuilder();
				model = new StringBuilder();
			}
			if ((fileText.charAt(i) != '\n') && (fileText.charAt(i) != '\"')) {
				if (flag == 0) {
					type.append(fileText.charAt(i));
				} else if (flag == 1) {
					brand.append(fileText.charAt(i));
				} else if (flag == 2) {
					model.append(fileText.charAt(i));
				}
			}
		}
		return resultStorage;
	}

}
