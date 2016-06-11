package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserAutenticationValidateFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain fChain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		String origen= null;
		if ((httpReq.getRequestURI().contains("static"))
				|| (null != httpReq.getSession(false))
				|| (httpReq.getRequestURI().contains("AutenticationServlet"))) {
			fChain.doFilter(req, resp);
		} else {
			req.setAttribute("notificacion",
					"Debe estar logueado para acceder al recurso solicitado");
			if (null != (origen = (String) req.getServletContext()
					.getAttribute("origen"))) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
