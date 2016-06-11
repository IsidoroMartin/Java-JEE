package helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Entidad encargada de realizar operaciones con ficheros
 * 
 * @author alumno
 */
public class FicherosHelper {

	/**
	 * Metodo que comprueba si el fichero existe, verifica si es un directorio y
	 * muestra un listado del mismo
	 */
	public static void ls(File f) {

		if ((f.isDirectory()) && (f.exists())) {
			for (String s : f.list()) {
				System.out.println(s);
			}
		}
	}

	// public static void lsRecursivo(String ruta) {
	// File f;
	// if (new File(ruta).isFile()) {
	// f = new File(ruta);
	// if (f.isDirectory()) {
	// for (String s : f.list()) {
	// System.out.println(s);
	// }
	// lsRecursivo("..");
	// }
	// }
	// }

	/**
	 * Método que lee el fichero de la entidad linea a linea y lo devuelve en
	 * forma de String[](linea a linea).
	 * 
	 * @param f
	 *            File Fichero a leer
	 * @return String[] | Lineas
	 */
	public static String[] leerFichero(File f) {

		String[] lineasFichero = null;
		if ((f == null) && (!f.isFile())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Error");
			}
		}
		lineasFichero = new String[contarLineas(f)];
		int i = 0;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while ((linea = br.readLine()) != null) {
				lineasFichero[i] = linea;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return lineasFichero;
	}

	/**
	 * Método que escribe en un fichero a través de un array de String[] que
	 * recibe y devuelve false en caso de fallar en algún lugar del método
	 * 
	 * @param lineas
	 *            String[]
	 * @return boolean
	 */
	public static boolean escribirFichero(String[] lineas, File f) {

		boolean escrito = true;
		if ((f == null) && (!f.exists()) && (!f.isFile())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Error");
			}
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < lineas.length; i++) {
				bw.write(lineas[i] + "\n");
			}
		} catch (FileNotFoundException e) {
			escrito = false;
		} catch (IOException e) {
			escrito = false;
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}

			} catch (IOException e) {
				escrito = false;
			}

		}
		return escrito;
	}

	/**
	 * Cuenta las lineas del fichero de la entidad.
	 * 
	 * @return int numero de lineas
	 */
	private static int contarLineas(File f) {

		int i = 0;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr); // (int) br.lines().count() (Devuelve
											// long)
			while (br.readLine() != null) {
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return i;
	}

	/**
	 * @param fOrigen
	 * @param fDestino
	 * @return
	 */
	/**
	 * .read() te devuelve un entero con el numero de bytes que quieres leer, en
	 * caso de no especificarlo te devuelve la longitud de bytes del fichero
	 */
	public static boolean copiarFichBytes(File fOrigen, File fDestino) {

		int c;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		boolean copiado = true;
		if (fOrigen.exists() && fDestino.exists()) {
			try {
				in = new BufferedInputStream(new FileInputStream(fOrigen));
				out = new BufferedOutputStream(new FileOutputStream(fDestino));
				byte[] tam = new byte[1024];
				while ((c = in.read(tam)) != -1) {
					out.write(tam, 0, c);
				}

			} catch (FileNotFoundException e) {
				copiado = false;
				System.out.println(1);
			} catch (IOException e) {
				copiado = false;
				System.out.println(2);
			} finally {
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					copiado = false;
					System.out.println(3);
				}
			}
		}

		return copiado;
	}

}

