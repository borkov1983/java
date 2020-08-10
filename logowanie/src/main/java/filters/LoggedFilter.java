package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/logowanie", "/logowanie.jsp", "/rejestracja", "/rejestracja.jsp"})
public class LoggedFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		boolean isLoggedIn = false;
		try {
			isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
		} catch(Exception e) {
			System.out.println("Użytkownik niezalogowany");
		}
		
		if(isLoggedIn) {
			httpResponse.sendRedirect("/profile");
		}
		chain.doFilter(httpRequest, httpResponse);
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	@Override 
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
