package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.beans.User;
import model.services.UsersManagerService;

public class AutenticationServlet extends HttpServlet {
	private Logger log = LogManager.getRootLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username"), password = req
				.getParameter("password"), origen= null;;
		HttpSession session = null;
		User user = null;
		UsersManagerService ums = new UsersManagerService();
		user = ums.getUser(username, password);
		if (null != user) {
			session = req.getSession(true);
			session.setAttribute("user", user);
			req.setAttribute("session", session);
			req.setAttribute("notificacion", "¡Bienvenido " + user.getNombre()
					+ "!");
		} else {
			req.setAttribute("a", username);
			System.out.println(" PASS - " + password);
			req.setAttribute("notificacion",
					"El usuario y la contraseña no coinciden");
		}
		if (null != (origen = (String) req.getServletContext()
				.getAttribute("origen"))) {
			req.getRequestDispatcher(origen).forward(req, resp);
		}

	}
}
