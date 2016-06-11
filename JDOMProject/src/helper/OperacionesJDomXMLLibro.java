package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Libro;

public class OperacionesJDomXMLLibro {
	private ArrayList<Libro>	libros	= null;

	public OperacionesJDomXMLLibro(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	public OperacionesJDomXMLLibro() {
		libros = new ArrayList<Libro>();
	}
	public void cargarLibros() throws FileNotFoundException, JDOMException,
			IOException {

		// Creamos el parser encargado de interpretar el XML
		SAXBuilder builder = new SAXBuilder();
		// Generamos el arbol DOM del XML utilizando el parser
		Document document = builder
				.build(new FileInputStream("src/libros.xml"));

		Element elementoRaiz = document.getRootElement();
		// Cargo los libros obteniendo el valor y los atributos de cada elemento
		// de cada libro
		List<Element> libros = elementoRaiz.getChildren();
		for (Element libroElement : libros) {
			Libro libro = new Libro(libroElement.getAttributeValue("isbn"),
					libroElement.getChildText("titulo"),
					libroElement.getChildText("autor"),
					libroElement.getChildText("anyo"),
					libroElement.getChildText("editorial"));
			this.libros.add(libro);
		}
		// ordeno el ArrayList de libro
		ordenarLibros();
	}
	/**
	 * Ordeno el ArrayList de libros
	 */
	private void ordenarLibros() {
		Collections.sort(this.libros);
	}
	/**
	 * Getter del ArrayList de libros
	 * 
	 * @return ArrayList<Libro>
	 */
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	/**
	 * Genero el arbol XML y lo escribo en un fichero
	 * 
	 * @throws IOException
	 */
	public void volcarLibros() throws IOException {
		Integer cont = 0;
		// Me creo el elemento raíz
		Element libros = new Element("libros");
		/**
		 * Recorro el arraylist de libros y creo un elemento por cada libro del
		 * arraylist, al cual añado los elementos y atributos oportunos
		 */
		for (Libro libro : this.libros) {
			cont++;
			Element libroElement = new Element("libro");
			Attribute isbnAtribute = new Attribute("isbn", libro.getIsbn());
			libroElement.setAttribute(isbnAtribute);

			Element tituloElement = new Element("titulo");
			tituloElement.addContent(libro.getTitulo());
			libroElement.addContent(tituloElement);

			Element autorElement = new Element("autor");
			autorElement.addContent(libro.getAutor());
			libroElement.addContent(autorElement);

			Element anyoElement = new Element("anyo");
			anyoElement.addContent(libro.getAnyo());
			libroElement.addContent(anyoElement);

			Element editorialElement = new Element("editorial");
			editorialElement.addContent(libro.getEditorial());
			libroElement.addContent(editorialElement);

			libros.addContent(libroElement);
		}
		// Añado el total de libros
		Attribute total = new Attribute("totalLibros", cont.toString());
		libros.setAttribute(total);
		// Genero el arbol XML
		Document arbol = new Document(libros);
		Format format = Format.getPrettyFormat();
		// Creamos el serializador con el formato deseado
		XMLOutputter xmloutputter = new XMLOutputter(format);
		// Serializamos el document parseado
		String docStr = xmloutputter.outputString(arbol);
		// Volcamos en un fichero
		FileOutputStream fos = new FileOutputStream("src/Fichero.xml");
		// Cambio la codificación del fichero de salida a UTF8
		Writer out = new OutputStreamWriter(fos, "UTF8");
		out.write(docStr);
		out.close();

		// FileWriter fw = new FileWriter("src/Fichero.xml");
		// fw.write(docStr);
		// fw.close();
	}
}
