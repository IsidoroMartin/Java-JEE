package p;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.persistencia.dao.hibernate.beans.Inmueble;
import model.servicios.InmuebleService;

public class Servlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			InmuebleService pepe = new InmuebleService();
			System.out.println(((Inmueble)pepe.read(new Inmueble(1))).getEstado().getDescripcion());
			
			
	}
}
