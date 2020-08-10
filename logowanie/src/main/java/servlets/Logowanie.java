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

@WebServlet("/logowanie")
public class Logowanie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserRepository userRepository = new UserRepository(session);
		User user = userRepository.findUser(request.getParameter("username"), request.getParameter("password"));
		
		if(user != null) {
			session.setAttribute("isLoggedIn", true);
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("profile");
		} else {
			this.setValueForForm("username", request);
	        request.getRequestDispatcher("/logowanie.jsp").forward(request, response);
		}
	}
	
	
	private void setValueForForm(String name, HttpServletRequest request) {		
		try {
			request.setAttribute(name, request.getParameter(name));
		} catch (Exception e) {
			System.out.println("Nie można pobrać wartości dla pola " + name);
		}
	}
}
