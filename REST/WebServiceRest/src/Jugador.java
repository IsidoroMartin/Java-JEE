import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.google.gson.Gson;

@Path("/jugador")
public class Jugador {
	String nombre;
	String apellidos;
	int posicion;

	public Jugador (){}
	public Jugador(String nombre, String apellidos, int posicion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	@PUT
	@Path("/modifyJugador")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarJugador(String json) {
		System.out.println("Hola");
		boolean modificado = false;
		Gson gson = new Gson();
		Jugador j = gson.fromJson(json, Jugador.class);
		j.setNombre("Pepe");
		j.setApellidos("Lopez Blah Blah..");
		System.out.println(j.toString());
		modificado = true;
		System.out.println(modificado);
		String result = "Ha ido bien, chaval ;)";
		return Response.status(200).entity(result).build();
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", posicion=" + posicion + "]";
	}
	
}
