package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Department;
import model.service.DepartamentosService;

public class ListarDepartamentosServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DepartamentosService dptosService = new DepartamentosService();
		req.setAttribute("departamentos", dptosService.getDepartments());
		req.getRequestDispatcher("emplesPorDepartamento.jsp").forward(req, resp);
	}
}
