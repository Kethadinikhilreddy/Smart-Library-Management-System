package org.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.UserDAO;
import org.dto.UserDetails;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	
	private UserDAO userDAO =new UserDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name").trim();
		String email=request.getParameter("email").trim();
		String password=request.getParameter("password").trim();
		long mobilenumber=Long.parseLong(request.getParameter("mobilenumber").trim());
		
		
		UserDetails userDetails=new UserDetails(name, email, password, mobilenumber);
		
		if(!userDAO.isEmailExists(email)) {
			userDAO.saveUser(userDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			request.setAttribute("error","Email Already Exists");
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.include(request, response);
		}
	
	}

}
