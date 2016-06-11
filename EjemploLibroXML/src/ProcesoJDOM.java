
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

// JDOM for JAVA
public class ProcesoJDOM {

	public static void main(String[] args) throws FileNotFoundException,
			JDOMException, IOException {

		// CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		// Construimos el arbol DOM a partir del fichero xml
		Document documentJDOM = builder.build(new FileInputStream(
				"src/libros.xml"));

		// MOSTRAMOS EL DOCUMENTO
		Element raiz = documentJDOM.getRootElement();
		// Recorremos los hijos de la etiqueta raíz
		List<Element> libros = raiz.getChildren();
		for (Element libro : libros) {
			// para cada libro, obtenemos su detalle
			System.out.println(libro.getAttribute("isbn"));
			List<Element> detalles = libro.getChildren();

			for (Element detalle : detalles) {

				System.out.println("Nombre =" + detalle.getName());
				System.out.println("Valor =" + detalle.getValue());

			}

		}

		// AÑADO UN NUEVO HIJO
		Element padre = documentJDOM.getRootElement();
		// Creamos una nueva etiqueta
		Element nuevolibro = new Element("libro");
		Element titulo = new Element("titulo");
		// Añadimos un atributo
		nuevolibro.setAttribute("isbn", "xxxx-yyyy");
		titulo.addContent("dsafdfasd");
		nuevolibro.addContent(titulo);
		padre.addContent(nuevolibro);

		// SERIALIZO EL DOCUMENT A UN FICHERO DE SALIDA

		Format format = Format.getPrettyFormat();
		// Creamos el serializador con el formato deseado
		XMLOutputter xmloutputter = new XMLOutputter(format);
		// Serializamos el document parseado
		String docStr = xmloutputter.outputString(documentJDOM);
		// Volcamos en un fichero
		FileWriter fw = new FileWriter("lsalida3.xml");
//		FileWriter fw = new FileWriter
		fw.write(docStr);
		fw.close();

	}

}
