package ru.rsreu.verbickaya0605.basic;

import java.io.File;

public class FilePathFormer {

	private FilePathFormer() {
	}

	public static String formPath(String... args) {
		if (args.length == 0) {
			return "";
		}
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < args.length - 1; i++) {
			resultString.append(args[i]);
			if (!args[i].endsWith(File.separator)) {
				resultString.append(File.separator);
			}
		}
		resultString.append(args[args.length - 1]);
		return resultString.toString();
	}
}
