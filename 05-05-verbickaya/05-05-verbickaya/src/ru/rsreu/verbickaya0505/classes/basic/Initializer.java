package ru.rsreu.verbickaya0505.classes.basic;

import ru.rsreu.verbickaya0505.classes.compositions.AcademicComposition;
import ru.rsreu.verbickaya0505.classes.compositions.FolkComposition;
import ru.rsreu.verbickaya0505.classes.compositions.PopularComposition;
import ru.rsreu.verbickaya0505.classes.compositions.SacredComposition;
import ru.rsreu.verbickaya0505.classes.other.InvalidParamsException;
import ru.rsreu.verbickaya0505.enums.characteristics.AcademicMusicMoods;
import ru.rsreu.verbickaya0505.enums.characteristics.FolkMusicRegions;
import ru.rsreu.verbickaya0505.enums.characteristics.PopularMusicVersions;
import ru.rsreu.verbickaya0505.enums.styles.AcademicMusicStyles;
import ru.rsreu.verbickaya0505.enums.styles.FolkMusicStyles;
import ru.rsreu.verbickaya0505.enums.styles.PopularMusicStyles;
import ru.rsreu.verbickaya0505.enums.styles.SacredMusicStyles;

public class Initializer {

	private Initializer() {
	}

	public static SacredComposition Sacred1;
	public static SacredComposition Sacred2;
	public static FolkComposition Folk1;
	public static FolkComposition Folk2;
	public static FolkComposition Folk3;
	public static AcademicComposition Academic1;
	public static AcademicComposition Academic2;
	public static AcademicComposition Academic3;
	public static AcademicComposition Academic4;
	public static PopularComposition Popular1;
	public static PopularComposition Popular2;
	public static PopularComposition Popular3;
	public static PopularComposition Popular4;
	public static PopularComposition Popular5;

	public static void initialize() throws InvalidParamsException {

		Initializer.Sacred1 = new SacredComposition("Gloria", 667, SacredMusicStyles.Christian, "������� ��������", "");
		Initializer.Sacred2 = new SacredComposition("Vehi Sheamda", 310, SacredMusicStyles.Jewish, "Gaston Saieda",
				"���������� �����");

		Initializer.Folk1 = new FolkComposition("�����-�����, ������", 70, FolkMusicStyles.ritualFolklore, "",
				FolkMusicRegions.EasternEurope);
		Initializer.Folk2 = new FolkComposition("�����������", 58, FolkMusicStyles.dance, "�.�.����������",
				FolkMusicRegions.EasternEurope);
		Initializer.Folk3 = new FolkComposition("����������� ������", 95, FolkMusicStyles.roundDance, "",
				FolkMusicRegions.WesternEurope);

		Initializer.Academic1 = new AcademicComposition("����� �������", 321, AcademicMusicStyles.Classicism,
				"������ ���������", AcademicMusicMoods.tragic, "������������� ������� ����������� ������");
		Initializer.Academic2 = new AcademicComposition("������", 238, AcademicMusicStyles.Romanticism,
				"������� ��������", AcademicMusicMoods.lyric, "������� ������������� ������� ��. �.�.�����������");
		Initializer.Academic3 = new AcademicComposition("����� \"��������\"", 254, AcademicMusicStyles.Classicism,
				"���� ���������", AcademicMusicMoods.lyric, "���������� ������������� �������");
		Initializer.Academic4 = new AcademicComposition("����������� ������", 139, AcademicMusicStyles.Romanticism,
				"������ ����������", AcademicMusicMoods.joyful, "");

		Initializer.Popular1 = new PopularComposition("����� ���������", 209, PopularMusicStyles.folkMusic, "��������",
				"��� �����", PopularMusicVersions.none);
		Initializer.Popular2 = new PopularComposition("GigaChad Theme", 142, PopularMusicStyles.electonicMusic,
				"g3ox_em", "", PopularMusicVersions.phonk);
		Initializer.Popular3 = new PopularComposition("��� ���� ����", 244, PopularMusicStyles.hipHop, "���",
				"Tragic City", PopularMusicVersions.none);
		Initializer.Popular4 = new PopularComposition("������ ��� �������", 220, PopularMusicStyles.popMusic, "�����",
				"", PopularMusicVersions.none);
		Initializer.Popular5 = new PopularComposition("Below The Surface", 116, PopularMusicStyles.electonicMusic,
				"Griffinilla", "", PopularMusicVersions.speedUp);
	}
}
