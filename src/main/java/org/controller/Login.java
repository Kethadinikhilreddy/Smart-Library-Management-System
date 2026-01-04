package org.controller;

import java.io.IOException;
import javax.persistence.NoResultException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dao.UserDAO;
import org.dto.UserDetails;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO userDAO =new UserDAO();
		
		String email=request.getParameter("email").trim();
		String password=request.getParameter("password").trim();
		
		
		try {
			UserDetails result = userDAO.getUserByEmail(email);
			
			if(result.getPassword().equals(password)) {
				
				HttpSession session=request.getSession();
				session.setAttribute("id",result.getId());
				session.setAttribute("name",result.getName());
				session.setAttribute("email", result.getEmail());
				session.setAttribute("password",result.getPassword());
				session.setAttribute("mobilenumber",result.getMobilenumber());
				
				response.sendRedirect("home.html");
			}
			else {
				request.setAttribute("passwordError","Incorrect Password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		catch(NoResultException e) {
			request.setAttribute("emailError","Email Not Registered");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
		
	}

}
