<%@page import="model.beans.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
// 	ArrayList<Employee> empleados = (ArrayList<Employee>) request
// 			.getAttribute("empleados");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de empleados</title>
<style type="text/css">
#empleados {
	margin-left: 5%;
}

h1 {
	font-size: 50px;
}

body {
	width: 100%;
	text-align: center;
}

table {
	text-align: center;
	border-radius: 10px 10px 10px 10px;
	-moz-border-radius: 10px 10px 10px 10px;
	-webkit-border-radius: 10px 10px 10px 10px;
	border: 0px solid #000000;
}

td, th {
	width: 300px;
}

th {
	font-size: 40px;
}

td {
	font-size: 30px;
}
</style>
</head>
<body>
	<h1>Empleados</h1>
	<table id="empleados">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Department ID</th>
			<th>Salario</th>
		</tr>
		<c:forEach items="${empleados}" var="empleado">
			<tr>
				<td>${empleado.employeeId}</td>
				<td>${empleado.firstName} ${empleado.lastName}</td>
				<td>${empleado.departmentId}</td>
				<td>${empleado.salary}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>