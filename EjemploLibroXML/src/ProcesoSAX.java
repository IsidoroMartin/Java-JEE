
import helper.LibroXML;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import model.Libro;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProcesoSAX {

	public static void main(String[] args) {
		//SAX Simple API for XML
		try {
			// Creamos nuestro objeto libro vacío
			Libro libro = new Libro();
			// Creamos la factoria de parseadores por defecto
			XMLReader reader = XMLReaderFactory.createXMLReader();//Patrón singleton
			// Añadimos nuestro manejador al reader pasandole el objeto libro
			LibroXML lib = new LibroXML(libro);
			reader.setContentHandler(lib);
			// Procesamos el xml de ejemplo
			reader.parse(new InputSource(new FileInputStream("src/libros.xml")));
			HashMap<String , Libro> libros = lib.getLibros();
			System.out.println(libros);
//			System.out.println(libro.toString());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
