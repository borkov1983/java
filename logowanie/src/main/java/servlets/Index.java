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

@WebServlet("/")
public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isLoggedIn = false;
		String username = null;
		try {
			isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
			username = (String) session.getAttribute("username");
		} catch(Exception e) {
			System.out.println("Użytkownik niezalogowany");
		}

		if(isLoggedIn) {
			response.sendRedirect("profile");
		} else {
			response.sendRedirect("logowanie.jsp");
		}
	}

}
