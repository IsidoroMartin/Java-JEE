package cursosbasicos;

import java.io.Serializable;

public class Persona implements Serializable{
	byte edad;
	String nombre;
	String apellido;

	public Persona(byte edad, String nombre, String apellido) {
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Persona() {
		
	}

	@Override
	public String toString() {
		return this.nombre + " " + this.edad + " " + this.apellido;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void sumarEdadMismaPersona(byte incremento) {
		this.setEdad((byte) (this.getEdad() + incremento));
	}

	public static Persona sumarEdadNuevaPersona(Persona p, byte incremento) {
		return new Persona((byte) (p.getEdad() + incremento), p.getNombre(),
				p.getApellido());
	}

}
