package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.User;
import user.repository.UserRepository;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserRepository userRepository = new UserRepository(session);
		
		String username = null;
		try {
			username = (String) session.getAttribute("username");
		} catch(Exception e) {
			System.out.println("Użytkownik niezalogowany");
		}
		
		User user = userRepository.getUserByUsername(username);
		
		request.setAttribute("user", user);		
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
		
	}

}
