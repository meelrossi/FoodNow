package ar.edu.itba.it.paw.controllers;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.services.RegisterService;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
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
		
		if(!email.equals(reEmail)) {
			resp.sendRedirect("/FoodNow/Login#emailMissmatch");
		}
		
		if(!password.equals(rePassword)){
			resp.sendRedirect("/FoodNow/Login#passwordMissmatch");
		}
		
		RegisterService registerService = new RegisterService();
		
		int code = registerService.createUser(name, lastName, address, reEmail, birthday, rePassword, 2);
		
		if(code == 200){
			resp.sendRedirect("/FoodNow/Login#userCreationSuccess");
		} else {
			resp.sendRedirect("/FoodNow/Login#userCreationFail");
		}
		
	}
}
