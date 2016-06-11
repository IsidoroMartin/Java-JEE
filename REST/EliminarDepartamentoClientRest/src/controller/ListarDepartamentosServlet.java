package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Department;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ListarDepartamentosServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Client cliente = Client.create();
		Gson gson = new Gson();
		WebResource wResource2 = cliente.resource("http://localhost:8090/EliminarDepartamentoRest/rest/departamentosResource/getDepartments");
		String r = wResource2.get(String.class);
		ArrayList<Department> listaDepartamentos = gson.fromJson(r, ArrayList.class);
		req.setAttribute("departamentos", listaDepartamentos);
		req.getRequestDispatcher("removeDepartments.jsp").forward(req, resp);
	}
}
