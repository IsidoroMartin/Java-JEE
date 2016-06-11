package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EjPageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 PrintWriter pw = resp.getWriter();
		 resp.setContentType("text/html");
		 Date d = new Date();
		pw.println("<html><head><title>Hola Mundo</title></head><body><p>Hola, esto es una página JSP.</p><p>La hora del servidor es "+d.toString()+"</p></body></html>");

	}
}
