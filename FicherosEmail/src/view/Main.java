package view;

import helper.FicherosHelper;

import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		File f = new File("src/recursos/correos.txt");
		FicherosHelper.ficheroToString(f);
		String[] correos = FicherosHelper.correosFinder(f);
		Arrays.sort(correos);
		for (String correo : correos) {
			System.out.println(correo);
		}

	}
}
