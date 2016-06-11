package view;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.dto.Employees;
import model.dto.Regions;
import model.persistencia.SessionManager;
import model.persistencia.dao.EmpleadosDAO;
import model.persistencia.dao.RegionsDAO;
import model.persistencia.services.EmpleadoService;

public class Main {
	public static void main(String[] args) {
		// BigDecimal porcentaje = new BigDecimal(1.2);
		// EmpleadosDAO ep = new EmpleadosDAO();
		// ep.modificarSalariosVentas(porcentaje);
		// RegionsDAO.getCountries();
		EmpleadoService empService = new EmpleadoService();
		try {
//			empService.modificarSalariosVentas(new BigDecimal(0.8),"Sales");
			System.out.println(empService.obtenerEmpleado(new Employees(100)));
//			System.out.println(empService.obtenerEmpleado(new Employees(100))); 
//			empService.mostrarEmpleadosMayorSalarioPorDepartmento();
//			empService.obtenerEmpleadosPorDepartmento("Sales");
//			Employees e = new Employees(100);
//			e = empService.obtenerEmpleado(e);
//			e.setSalary(new BigDecimal(1));
			
			SessionManager.factoryClose();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
