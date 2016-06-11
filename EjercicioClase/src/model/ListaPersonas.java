package model;

import exception.InsertarPersonaException;
import exception.PersonaExisteException;

public class ListaPersonas {

	public static final int	CAPACIDAD	= 10;

	private Persona[]		array_personas;

	private byte			lastPersona	= 0;

	/**
	 * Es muy posible que haga falta añadir algún campo más
	 */

	public ListaPersonas() {

		array_personas = new Persona[CAPACIDAD];
		// TODO HAY QUE HACER UN CONSTRUCTOR
		// RECUERDA QUE EL CONSTRUCTOR SIRVE PARA
		// RESERVAR MEMORIA
		// INICIALIZAR EL ESTADO DEL OBJETO Y SUS ATRIBUTOS
	}

	public Persona[] getListaPersonas() {

		// TODO HAY QUE DEVOLVER EL ARRAY DE PERSONAS QUE CONFORMAN LA LISTA
		return this.array_personas;
	}

	public Persona buscarPersona(String nombre) {

		// TODO BUSCAR PERSONA POR NOMBRE Y DEVOLVERLA
		// SI NO ESTÁ, DEVOLVER NULO
		return null;
	}

	public Persona buscarPersona(int edad) {

		Persona pFound = null;
		int i = 0;
		// TODO BUSCAR PERSONA POR EDAD Y DEVOLVERLA
		// SI NO ESTÁ, DEVOLVER NULO
		do {
			if(edad==array_personas[i].getEdad()){
				array_personas	
			}
			
			i++;
		} while ((pFound != null) && (i < array_personas.length));
		return pFound;
	}

	public boolean serializar() {

		// Hacer uso del fichero de propiedades serializa.properties,
		// para obtener de él el valor de la clave destino,
		// que representa el nombre del fichero de salida
		return false;
	}

	public boolean deserializar() {

		return false;
	}

	public boolean comprobarSiExistePersona() throws PersonaExisteException {

		boolean existe = false;
		int i = 0;
		do {
			existe = this.equals(array_personas[i]);
			i++;
		} while ((!existe) && (i < array_personas.length));
		if (existe) {
			throw new PersonaExisteException("La persona ya existe");
		}
		return existe;
	}

	public void insertarPersona(Persona p) throws InsertarPersonaException,
			PersonaExisteException {
		//TODO Tratar Excepciones Aqui BLABLABLABLABLABLA 
		if ((p != null) && (!comprobarSiExistePersona())) {
			array_personas[lastPersona] = p;
			lastPersona++;
		}
	}

	public int numeroPersonas() {

		return array_personas.length;
	}

	public boolean estaLlena() {

		return ((array_personas != null) && (array_personas.length == 10));
	}

	public void mostrar() {

		for (Persona persona : array_personas) {
			System.out.println(persona.toString());
		}
	}

}
