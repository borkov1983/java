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

import user.model.User;
import user.repository.UserRepository;

@WebFilter({"/premium", "premium.jsp"})
public class PremiumFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		UserRepository userRepository = new UserRepository(session);
		
		String username = null;
		try {
			username = (String) session.getAttribute("username");
		} catch(Exception e) {
			System.out.println("Użytkownik niezalogowany");
		}
		User user = userRepository.getUserByUsername(username);
		if(!user.getIsPremium()) {
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
