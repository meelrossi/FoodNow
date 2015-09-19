package ar.edu.itba.it.paw.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.dao.UserDao;

public abstract class Controller extends HttpServlet {
	
	public static final int ADMINISTRATOR = 0;
	public static final int MANAGER = 1;
	public static final int CUSTOMER = 2;

	
	public void userLvlCheck(Integer userId, int userLvl, HttpServletResponse resp, HttpServletRequest req) {
		
		if(userId == null) { //User is not logged in
			try {
				resp.sendRedirect("/FoodNow/loginRequest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int hasUserLvl = -1;
		
		try {
			hasUserLvl = UserDao.getInstance().getUserLevel(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(hasUserLvl == -1){ //Error requesting user lvl
			try {
				resp.sendRedirect("/FoodNow/error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(hasUserLvl > userLvl) { //User has no permission to view the page
			try {
				resp.sendRedirect("/FoodNow/notAllowed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void manageException(Exception e) {}

}
