package model;

import java.io.Serializable;

public class Persona implements Serializable {

	private int		edad;

	private String	nombre;

	public Persona(String nombre, int edad) {

		this.edad = edad;
		this.nombre = nombre;
	}

	public int getEdad() {

		return edad;
	}

	public void setEdad(int edad) {

		this.edad = edad;
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	@Override
	public String toString() {

		return this.nombre + " " + this.edad;
	}

	@Override
	public boolean equals(Object o) {
		return ((o != null) && (o instanceof Persona)
				&& (this.getEdad() == ((Persona) (o)).getEdad()) && (this
					.getNombre().equals(((Persona) (o)).getNombre())));
	}

}
