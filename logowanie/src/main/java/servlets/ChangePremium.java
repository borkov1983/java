package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.User;
import user.repository.UserRepository;

@WebServlet("/changePremium")
public class ChangePremium extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserRepository userRepository = new UserRepository(session);
		
		String username = request.getParameter("username");
		User user = userRepository.getUserByUsername(username);
		User newerUser = new User(user);
		
		newerUser.tooglePremium();
		userRepository.updateUser(user, newerUser);
		
		response.sendRedirect("premium");
		
	}

}