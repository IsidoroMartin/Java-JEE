package helper;
import java.util.HashMap;

import model.Libro;
import model.RedefinirHashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
// JAXP Java Api for XML Process, SAX

/**
 * Entidad encargada de leer libros en un XML con los atributos de nuestra entidad Libro
 * @author isi
 *
 */
public class LibroXML extends DefaultHandler {
	private String					valor	= null;

	private HashMap<String, Libro>	libros	= new RedefinirHashMap();

	private Libro					libro;

	public LibroXML(Libro libro) {
		this.libro = libro;
	}
	/**
	 * RECOGE LAS ETIQUETAS DE EMPIECE DE CADA ELEMENTO, EN CASO DE QUE EL
	 * ELEMENTO TENGA ATRIBUTOS SE PUEDE RECOGER EL VALOR DE EL ATRIBUTO CON
	 * GETVALUE
	 */
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		// System.out.println(uri + " " + localName + " " + name);
		// Limpiamos la variable temporal.
		valor = null;
		// Si la etiqueta es libro leemos el atributo isbn
		if (localName.equals("libro")) {
			this.libro = new Libro();
			String isbn = attributes.getValue("isbn");
			// Lo guardamos en el objeto libro
			libro.setIsbn(isbn);
		}
		// System.out.println("******************************");
	}
	/**
	 * RECOGE EL CONTENIDO DE CADA ELEMENTO, BUSCA CADENAS QUE NO ESTÉN ENTRE
	 * ETIQUETAS
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// Guardamos el texto en la variable temporal
		valor = new String(ch, start, length);
		// System.out.println(valor);
	}
	/**
	 * RECOGE LOS CIERRES DE ETIQUETA, EN EL MOMENTO EN QUE SE CIERRA CADA
	 * ETIQUETA ASIGNAMOS EL CONTENIDO DE CADA ELEMENTO A NUESTRA ENTIDAD LIBRO
	 */
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		// System.out.println("-----------------------------");
		// System.out.println(uri + " " + localName + " " + name);
		// Según la etiqueta guardamos el valor leido
		// en una propiedad del objeto libro
		// System.out.println(name);
		if (localName.equals("titulo")) {
			libro.setTitulo(valor);
		}
		else if (localName.equals("autor")) {
			libro.setAutor(valor);
		}
		else if (localName.equals("anyo")) {
			libro.setAnyo(valor);
		}
		else if (localName.equals("editorial")) {
			libro.setEditorial(valor);
			libros.put(this.libro.getIsbn(), this.libro);
		}
		else if (localName.equals("libro")) {
			libros.put(this.libro.getIsbn(), this.libro);

		}
		/**
		 * Getter del HashMap que contiene los libros recogidos en el XML
		 */
	}
	public HashMap<String, Libro> getLibros() {
		return libros;
	}

}