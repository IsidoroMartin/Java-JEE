package model.persistencia.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import model.dto.Employees;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEmpleadoService {
	private static EmpleadoService tester = null;
	private static Logger log = Logger.getLogger("mylog");
	@BeforeClass
	public static void iniciaClase() {
		tester = new EmpleadoService();
	}

	@Test
	public void testEmpleadoServiceNotNull() {
		assertThat(tester, is(not(nullValue())));
	}

	@Test
	public void testEmpleadoServiceInstanceOfEmpleadoService() {
		assertThat(tester, instanceOf(EmpleadoService.class));
	}

	@Test
	public void testAlmacenarEmpleado() {
		Employees e1 = null;
		Employees e2 = null;
		Random rnd = new Random();
		try {
			e1 = tester.obtenerEmpleado(new Employees(100));
			e1.setSalary(new BigDecimal(524));
			e1.setEmployeeId(rnd.nextInt(99999));
			e1.setFirstName("BLABLABLABLA");
			e1.setLastName("BLABLABLABLA");
			e1.setEmail("BLABLABLABLA");
			tester.almacenarEmpleado(e1);
			e2 = tester.obtenerEmpleado(e1);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(e2, is(not(nullValue())));
		assertThat(e2, is(equalTo(e1)));
	}

	@Test
	public void testObtenerEmpleado() {
		Employees e1 = null;
		int id = 100;
		try {
			e1 = tester.obtenerEmpleado(new Employees(id));
			assertThat(e1, is(not(nullValue())));
			assertThat(e1.getEmployeeId(), is(id));
		} catch (Throwable e) {

		}
	}

	@Test
	public void testActualizarEmpleado() {
		Employees empAactualizar = null;
		Employees empActualizado = null;

		try {
			empAactualizar = tester.obtenerEmpleado(new Employees(100));
			empAactualizar.setFirstName("Pepe");
			empAactualizar.setLastName("Rodriguez");
			tester.actualizarEmpleado(empAactualizar);
			empActualizado = tester.obtenerEmpleado(empAactualizar);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(empActualizado, is(equalTo(empAactualizar)));
	}
	@Test
	public void testBorrarEmpleado() {
		Employees emp = null;
		Employees empVal = null;
		try {
			emp = tester.obtenerEmpleado(new Employees(3598));
			tester.borrarEmpleado(emp);
			empVal = tester.obtenerEmpleado(emp);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(empVal, is(nullValue()));
	}
	 @Test
	public void testObtenerEmpleados() {
		 List<Employees> empleados = null;
		 try {
			empleados = tester.obtenerEmpleados();
			for (Employees employees : empleados) {
				assertThat(employees, instanceOf(Employees.class));
				assertThat(employees, is(not(nullValue())));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		 assertThat(empleados, is(not(nullValue())));
		 assertThat(empleados.isEmpty(), equalTo(false));
	 }
	 @Test
	 public void testObtenerEmpleadosPorDepartmentoString() {
		 List<Employees> empleados = null;
		 String departamento = "Sales";
		 try {
			empleados = tester.obtenerEmpleadosPorDepartmento(departamento);
			for (Employees employees : empleados) {
				assertThat(employees, instanceOf(Employees.class));
				assertThat(employees, is(not(nullValue())));
				assertThat(employees.getDepartments().getDepartmentName().toUpperCase(), is(departamento.toUpperCase()));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		 assertThat(empleados, is(not(nullValue())));
		 assertThat(empleados.isEmpty(), equalTo(false));
	 }
	 @Test
	 public void testObtenerEmpleadosPorDepartmentoInt() {
		 List<Employees> empleados = null;
		 int departamento = 80;
		 try {
			 empleados = tester.obtenerEmpleadosPorDepartmento(departamento);
			 for (Employees employees : empleados) {
				assertThat(employees, instanceOf(Employees.class));
				assertThat(employees, is(not(nullValue())));
				assertThat(employees.getDepartments().getDepartmentId(), is(departamento));
			 }
		 } catch (Throwable e) {
			 e.printStackTrace();
		 }
		 assertThat(empleados, is(not(nullValue())));
		 assertThat(empleados.isEmpty(), equalTo(false));
	 }



}
