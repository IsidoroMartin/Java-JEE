package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Employee;
import model.service.EmployeeService;

public class ListarEmpleadosServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmployeeService empService = new EmployeeService();
		String departamento = (String)req.getParameter("departamento");
		List<Employee> empleados = (ArrayList<Employee>) empService.getEmployeesByDepartmentName(departamento);
		req.setAttribute("empleados", empleados);
		req.getRequestDispatcher("listarEmpleados.jsp").forward(req, resp);
	}
}
