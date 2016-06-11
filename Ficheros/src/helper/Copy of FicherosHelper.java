package helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Entidad encargada de realizar operaciones con ficheros
 * 
 * @author alumno
 *
 */
public class FicherosHelper {
	File f = null;

	/**
	 * Constructor clase
	 * 
	 * @param f
	 */
	public FicherosHelper(File f) {
		this.f = f;
	}

	/**
	 * Metodo que comprueba si el fichero existe, si es un directorio y muestra
	 * un listado del mismo
	 */
	public void ls() {
		if ((this.f.isDirectory()) && (this.f.exists())) {
			for (String s : this.f.list()) {
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
	 * Funcion que lee el fichero de la entidad linea a linea.
	 */
	public String[] leerFichero() {
		String[] lineasFichero = null;
		if (this.f != null) {
			lineasFichero = new String[this.contarLineas()];
			int i = 0;
			FileReader fr = null;
			BufferedReader br = null;
			String linea;
			try {
				fr = new FileReader(this.f);
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

		}
		return lineasFichero;
	}

	/**
	 * Clase que escribe en un fichero y devuelve un boolean
	 * 
	 * @param lineas
	 * @return
	 */
	public boolean escribirFichero(String[] lineas) {
		boolean escrito = true;
		if (this.f != null) {
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
				fw = new FileWriter(this.f, true);
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

		}
		return escrito;
	}

	/**
	 * Cuenta las lineas del fichero de la entidad.
	 * 
	 * @return int numero de lineas
	 */
	private int contarLineas() {
		int i = 0;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(this.f);
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

}
/**
 * Leer fichero de texto Escribir array de String en un fichero por lineas
 **/
