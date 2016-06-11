<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.beans.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Department> departamentos = (ArrayList<Department>) request
	.getAttribute("departamentos");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Empleados por departamento</title>
<script type="text/javascript">
	var xmlHttp = null;
	function eliminarDepartamento() {
		var dep = document.getElementById("departamento");
		// 		var depName = dep.options[dep.selectedIndex].value;
		var depId = Math.floor(dep.options[dep.selectedIndex]
				.getAttribute("name"));
		xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange = procesarMensajeHttp;
		xmlHttp.open("DELETE", "http://localhost:8090/EliminarDepartamentoRest/rest/departamentosResource/departamentosResource", true);
		xmlHttp.send(depId);
	}
	function procesarMensajeHttp() {
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status ==200){
				alert("He recibido "+xmlHttp.responseText);
				
			}
		}
	}
</script>
</head>
<body>
	<select name="departamento" id="departamento">
		<c:forEach items="${departamentos}" var="item">
			<option name="${item.departmentId}">${item.departmentName}</option>
		</c:forEach>
	</select>
	<input type="button" value="Obtener Empleados" onclick="eliminarDepartamento();" />
</body>
</html>