package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.User;
import ar.edu.itba.it.paw.services.AddManagerService;
import ar.edu.itba.it.paw.services.RegisterService;

public class AddManagerController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

		AddManagerService addManagerService = new AddManagerService();
		
		User user = null;
		req.setAttribute("hasSearched", "false");
		
		if(email != null) {
			req.setAttribute("hasSearched", "true");
			try {
				user = addManagerService.getUser(email);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
	
				e.printStackTrace();
			}
		}
		
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/jsp/addManager.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String email = req.getParameter("email");
		String reEmail = req.getParameter("reEmail");
		String name = req.getParameter("name");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("adress");
		String password = req.getParameter("password");
		String rePassword = req.getParameter("rePassword");
		String birthday = req.getParameter("birthday");
		
		RegisterService registerService = new RegisterService();
		
		int code = registerService.createUser(name, lastName, address, reEmail, birthday, rePassword, 1);
		
		AddManagerService addManagerService = new AddManagerService();
		User user = null;
		try {
			user = addManagerService.getUser(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(code == 200){
			resp.sendRedirect("/FoodNow/asingRestaurant/" + user.getId());
		} else {
			resp.sendRedirect("/FoodNow/addManager#ErrorCreatingManager");
		}
		
	}

}
