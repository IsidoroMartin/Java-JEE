
<%@page import="java.util.Random"%>
<%!private int numAdivinar = -1;
	private Integer numMax;
	private Integer numMin;
	private boolean correcto = false;

	public void init() throws ServletException {
		numMax = 100;
		numMin = 0;
	}

	public boolean validarNum(int num) {
		return ((num < numMax) && (num > numMin));
	}

	public int generarRandom() {
		int rand = -1;
		do {
			rand = (int) (Math.random() * numMax) + numMin;
		} while (!validarNum(rand));
		return rand;
	}%>
<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%
	String respuesta = null;
	if (null != request.getParameter("reset")) {
		init();
		// 		request.removeAttribute("correcto");
		// 		request.removeAttribute("valor");
	}
	if (null != (String) (request.getParameter("correcto"))) {
		correcto = true;
	} else {
		if (null != (respuesta = (String) request.getParameter("valor"))) {
			if (respuesta.equals("mayor"))
				numMin = numAdivinar;
			else if (respuesta.equals("menor"))
				numMax = numAdivinar;
			numAdivinar = generarRandom();
		}
	}
%>
<html>
<head>
<title>Piensa en un número</title>
</head>
<body>
	<%=numAdivinar%>
	<%=numMax%>
	<%=numMin%>
	<%
		if (!correcto && numAdivinar != -1) {
	%>
	<h1>
		¿El número es<%=numAdivinar%>? <a href="index.jsp?correcto=si"><input
			type="button" value="Si"></a>
	</h1>
	<%
		}
		if (correcto) {
	%>
	<h1>Congratz!</h1>
	</br>
	<h2>
		El numero es<%=numAdivinar%></h2>

	<%
		}
		if (!correcto) {
	%>
	<form method="get" action="index.jsp">
		<select name="valor">
			<option>Seleccionar</option>
			<option>mayor</option>
			<option>menor</option>
		</select> <input type="submit" value="Adivinar">
	</form>

	<%
		}
	%>
	<a href="index.jsp?reset="><input type="button" value="Reset"></a>

</body>
</html>

