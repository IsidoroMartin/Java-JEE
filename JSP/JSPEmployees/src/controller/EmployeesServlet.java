package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Employee;
import model.beans.Employees;
import model.persistance.dao.hibernate.EmpHiberDAO;
import model.persistance.dao.jdbc.EmployeeDAO;
import model.persistance.interfaces.Recuperable;
import model.service.EmpleadoService;

public class EmployeesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String empIdStr = null;
		if (null != (empIdStr = (String) req.getParameter("employee_id"))) {
			int empId = Integer.parseInt(empIdStr);
			Recuperable daoJDBC = new EmployeeDAO();
			EmpleadoService service = new EmpleadoService(daoJDBC);
			service.setDao(new EmpHiberDAO());
			Employees emp = (Employees) service.obtenerEmpleado(empId);
			req.setAttribute("empleado", emp);
			req.getRequestDispatcher("GestorEmpleados.jsp").forward(req, resp);
		}

	}
}
