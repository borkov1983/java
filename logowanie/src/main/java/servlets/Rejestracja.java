package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.User;
import user.repository.UserRepository;

@WebServlet("/rejestracja")
public class Rejestracja extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserRepository userRepository = new UserRepository(session);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		
		if(!password.equals(confirmPassword)) {
			request.setAttribute("error", "Podane hasła się różnią!");
			request.getRequestDispatcher("/rejestracja.jsp").forward(request, response);
		}
		
		boolean isAlreadyRegistered = userRepository.validateIfUserExists(username);
		
		if(!isAlreadyRegistered) {
			User newUser = new User(username, password, email);
			userRepository.addUser(newUser);
			response.sendRedirect("logowanie.jsp");
		} else {
			request.setAttribute("error", "Podany użytkownik już istnieje!");
	        request.getRequestDispatcher("/logowanie.jsp").forward(request, response);
		}
        
	}

}
