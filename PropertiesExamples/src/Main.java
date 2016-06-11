import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

	enum Idioma {
		ES, EN, IT
	}
/**
 * Método que escribe un fichero con el contenido que se pasa por parámetros
 * @param rutaFichero String
 * @param contenido String
 * @return
 */
	public static boolean cargarFichero(String rutaFichero, String contenido) {

		BufferedWriter bw = null;
		boolean escrito = false;
		try {
			bw = new BufferedWriter(new FileWriter(rutaFichero));
			bw.write(contenido);
			escrito = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return escrito;
	}

	public static void main(String[] args) {

		Idioma idioma = Idioma.valueOf(args[0]);
		String ruta = "",rutaFichero="", contenido = "";
		Properties propiedades = new Properties();
		InputStream entrada = null;
		switch (idioma) {
		case ES:
			ruta = "src/properties/story_es.properties";
			rutaFichero = "src/story_es.txt";
			break;
		case EN:
			ruta = "src/properties/story_en.properties";
			rutaFichero = "src/story_en.txt";
			break;
		case IT:
			ruta = "src/properties/story_it.properties";
			rutaFichero = "src/story_it.txt";
			break;
		default:
			System.out.println("Debe introducir un idioma");
			break;
		}
		if (ruta != "" && rutaFichero!="") {
			try {
				entrada = new FileInputStream(ruta);
				propiedades.load(entrada);
				contenido = propiedades.getProperty("start") + " "
						+ propiedades.getProperty("body") + " "
						+ propiedades.getProperty("end");
				if (cargarFichero(rutaFichero, contenido)) {
					System.out.println("Cuento cargado con éxito!");
				}else{
					System.out.println("No se ha podido cargar el cuento :(");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
