package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.services.LoginService;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		LoginService loginService = new LoginService();
		
		int code = loginService.validate(email, password);
		
		if (code == 200) {
			HttpSession session = req.getSession();
            session.setMaxInactiveInterval(30*60);

            resp.sendRedirect("/FoodNow/index");
		} else {
			resp.sendRedirect("/FoodNow/Login#wrongPasswordOrUser2");
		}
		
		
	}
	
}
