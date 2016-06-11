package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidateUsernameAndPasswordFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		Logger log = LogManager.getRootLogger();
		boolean isEmpty = false, containsInvalidCharacters = false, isNull = isNull(
				req.getParameter("username"), req.getParameter("password"));
		String username = null, password = null, origen = null;
		String errores = "";
		if (isNull) {
			req.setAttribute("notificacion",
					"Sólo se puede acceder a través de la pag</br>");
			errores += "Intento de acceso externo \n";
		} else {
			username = req.getParameter("username");
			password = req.getParameter("password");
			if (isEmpty = isEmpty(username, password)) {
				req.setAttribute("notificacion",
						"Debe rellenar ambos campos</br>");
				errores += "Debe rellenar ambos campos\n";
			} else {
				if (containsInvalidCharacters = ((containsInvalidCharacters(username)) || (containsInvalidCharacters(password)))) {
					req.setAttribute("notificacion",
							"Ha introducido algún carácter no permitido en alguno de los campos ( \' , \" )");
					errores += "Carácter inválido introducido";
				}
			}
		}

		if (!isNull && !isEmpty && !containsInvalidCharacters) {
			chain.doFilter(req, resp);
		} else {
			log.error(errores);
			if (null != (origen = (String) req.getServletContext()
					.getAttribute("origen"))) {
				req.getRequestDispatcher(origen).forward(req, resp);
			}
		}

	}

	private boolean isNull(String username, String password) {

		// ((username.equals("") && (password.equals(""))||
		// ((username.equals("")) && (!password.equals(""))) ||
		// ((!username.equals("")) && (password.equals("")))));
		return (null == username) && (null == password);
	}

	private boolean isEmpty(String username, String password) {
		return ((username.equals("") && (password.equals(""))
				|| ((username.equals("")) && (!password.equals(""))) || ((!username
				.equals("")) && (password.equals("")))));
	}

	private boolean containsInvalidCharacters(String cadena) {
		boolean containsInvalidCharacters = false;
		int i = 0;
		int longitud = cadena.length();
		while ((!containsInvalidCharacters) && (i < longitud)) {
			switch (cadena.charAt(i)) {
			case '\'':
			case '\"':
				containsInvalidCharacters = true;
				break;
			}
			i++;
		}

		return containsInvalidCharacters;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
