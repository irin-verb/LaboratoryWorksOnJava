package ru.rsreu.verbickaya0505.classes.basic;

import ru.rsreu.verbickaya0505.classes.other.InvalidParamsException;
import ru.rsreu.verbickaya0505.classes.other.MusicDisk;

public class Runner {

	private Runner() {
	}

	public static void main(String[] args) {
		StringBuilder resultString = new StringBuilder();
		try {
			// ������������� ����������
			Initializer.initialize();

			// ������ ����� �� ������
			MusicDisk myDisk = new MusicDisk(Initializer.Popular1, Initializer.Sacred1, Initializer.Academic1,
					Initializer.Folk1);
			myDisk.addCompositions(Initializer.Academic2, Initializer.Popular2, Initializer.Folk2, Initializer.Sacred2);
			myDisk.addCompositions(Initializer.Folk3, Initializer.Popular3, Initializer.Academic3);
			myDisk.addCompositions(Initializer.Popular4, Initializer.Academic4);
			myDisk.addCompositions(Initializer.Popular5);

			// ����� ����������� ����� + ������� �����������������
			resultString.append(myDisk.toString());

			// ���������� ����������� ����� �� ����� � ��������� �����
			myDisk.sortByStyle();
			resultString.append(myDisk.toString());

			// ����� ����������
			resultString.append(myDisk.stringOfSearchedByName("����������� ������"));
			resultString.append(myDisk.stringOfSearchedByName("��� ���� ����"));
			resultString.append(myDisk.stringOfSearchedByName("��� ���� ����"));

		} catch (InvalidParamsException e) {
			resultString.append(e.toString());

		} finally {
			System.out.println(resultString);
		}
	}

}
