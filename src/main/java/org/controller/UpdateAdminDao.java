package org.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dao.UserDAO;
import org.dto.UserDetails;

@WebServlet("/updateadmindao")
public class UpdateAdminDao extends HttpServlet{

	private UserDAO userDAO = new UserDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name").trim();
		String email=request.getParameter("email").trim();
		String password=request.getParameter("password").trim();
		long mobilenumber=Long.parseLong(request.getParameter("mobilenumber").trim());
		
		
		UserDetails userDetails = new UserDetails();
			userDetails.setId(id);
			userDetails.setName(name);
			userDetails.setEmail(email);
			userDetails.setPassword(password);
			userDetails.setMobilenumber(mobilenumber);
			
			boolean success=userDAO.updateUser(userDetails);
			
			if (success) {
	            // Update session attributes
	            HttpSession session = request.getSession();
	            session.setAttribute("name", name);
	            session.setAttribute("email", email);
	            session.setAttribute("password", password);
	            session.setAttribute("mobilenumber", mobilenumber);

	            response.sendRedirect("profile");
	        } else {
	            response.getWriter().println("<h1>User not found or update failed</h1>");
	        }	
		
	}
}
