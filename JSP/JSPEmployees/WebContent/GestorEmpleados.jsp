<%@page import="model.beans.Employees"%>
<%!Employees emp = null;%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (null !=  request.getAttribute("empleado")) {
		emp = (Employees) request.getAttribute("empleado");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

${empleado.employeeId}. ${empleado.firstName} ${empleado.lastName}
</body>
</html>
<%-- <jsp:useBean id="empleado" type="model.beans.Employees" scope="request"/> --%>
<%-- <jsp:getProperty property="employeeId" name="empleado"/> --%>
<%-- <jsp:getProperty property="firstName" name="empleado"/> --%>
<%-- <jsp:getProperty property="lastName" name="empleado"/> --%>