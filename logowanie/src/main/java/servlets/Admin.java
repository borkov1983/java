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

@WebServlet("/admin")
public class Admin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserRepository userRepository = new UserRepository(session);
		List<User> users = userRepository.getAllUsers();
		
		request.setAttribute("users", users);
		
		String username = null;
		try {
			username = (String) session.getAttribute("username");
		} catch(Exception e) {
			System.out.println("Użytkownik niezalogowany");
		}
		
		User loggedUser = userRepository.getUserByUsername(username);
		request.setAttribute("loggedUser", loggedUser);
		request.getRequestDispatcher("/admin.jsp").forward(request, response);
		
	}

}
