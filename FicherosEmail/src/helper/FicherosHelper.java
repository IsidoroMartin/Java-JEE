package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicherosHelper {

	/**
	 * Método que lee el fichero que se pasa por parámetro linea a linea y lo
	 * devuelve en forma de String
	 * 
	 * @param f
	 *            File Fichero a leer
	 * @return String | fichero
	 */
	public static String ficheroToString(File f) {

		BufferedReader br = null;
		String linea = "";
		String fichero = "";
		try {
			br = new BufferedReader(new FileReader(f));
			while ((linea = br.readLine()) != null) {
				fichero += linea;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(2);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(3);
			}
		}

		return fichero;
	}

	/**
	 * Método que busca correos según el patrón del fichero
	 * (***correo\@blabla.com///) y los devuelve en un String[]
	 * 
	 * @param f File archivo
	 * @return String[]
	 */
	public static String[] correosFinder(File f) {

		String[] correosString = null;
		String emails = "";
		String ficheroStr = ficheroToString(f);
		int indiceInicio = 0;
		int indiceFinal = 0;
		Character separador = '-';
		while ((indiceInicio = ficheroStr.indexOf("***")) != -1) {
			indiceFinal = ficheroStr.indexOf("///");
			emails += ficheroStr.substring(indiceInicio + 3, indiceFinal)
					+ separador;
			ficheroStr = ficheroStr.substring(indiceFinal + 3,
					ficheroStr.length() - 1);
		}
		return emails.split(separador.toString());

	}

}
