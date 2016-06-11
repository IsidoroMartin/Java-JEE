package cursosbasicos;

import java.io.File;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		Persona e = new Alumno((byte) 10, (byte) 25, "Juan", "Perez");
//		Alumno b = new Alumno((byte) 9, (byte) 9, "Juan", "Perez");
		// System.out.println(((Persona) e).toString());
//		System.out.println("--------------");
//		System.out.println(((Persona) e));
//		System.out.println(b.getNotaCualitativa());
//		System.out.println(e.getEdad());
		File f = new File("src/cursosbasicos/fich");
		Persona p = new Persona((byte) 20, "Pepe", "Rodriguez");
		Persona k = new Persona((byte) 15, "Pepe", "Rodriguez");
		Persona j = new Persona((byte) 40, "Juan", "perez");
//		p.sumarEdadMismaPersona((byte) 5);
//		Persona j = Persona.sumarEdadNuevaPersona(k, (byte) 5);
//		System.out.println(p.getEdad());
//		System.out.println(j.getEdad());
//		FicherosObject.escribirObjeto(j, f);
		ArrayList<Persona> personas = FicherosObject.leerObjetos(f);
		for (Persona  object : personas) {
			
		}
//		System.out.println(f1.getNombre());
//		System.out.println(f1.getApellido());

	}
}
