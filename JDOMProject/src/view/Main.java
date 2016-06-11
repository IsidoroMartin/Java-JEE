package view;

import java.io.IOException;
import java.util.ArrayList;
import model.Libro;

import org.jdom2.JDOMException;

import helper.OperacionesJDomXMLLibro;

public class Main {
	public static void main(String[] args) {
		OperacionesJDomXMLLibro opj = new OperacionesJDomXMLLibro();
		ArrayList<Libro> libros = null;
		try {
			opj.cargarLibros();
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		libros = opj.getLibros();
		for (Libro libro : libros) {
			System.out.println(libro);
		}
		try {
			opj.volcarLibros();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
