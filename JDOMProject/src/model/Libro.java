package model;

public class Libro implements Comparable<Libro> {
	private String	isbn;

	private String	titulo;

	private String	autor;

	private String	anyo;

	private String	editorial;

	// Constructor por defecto
	public Libro() {
		this.isbn = null;
		this.titulo = null;
		this.autor = null;
		this.anyo = null;
		this.editorial = null;
	}

	public Libro(String isbn, String titulo, String autor, String anyo,
			String editorial) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anyo = anyo;
		this.editorial = editorial;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAnyo() {
		return anyo;
	}
	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); // tipo de String más rápido en
												// añadir!
		sb.append("\nISBN: " + isbn);
		sb.append("\nTítulo: " + titulo);
		sb.append("\nAutor: " + autor);
		sb.append("\nAño: " + anyo);
		sb.append("\nEditorial: " + editorial);

		return sb.toString();
	}
	/**
	 * Sobreescribo el método de la clase compareTo de la interfaz Comparable
	 * para definir el orden natural de mis libros
	 */
	@Override
	public int compareTo(Libro l) {
		return this.titulo.compareTo(l.titulo);
	}

}
