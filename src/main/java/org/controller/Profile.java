package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false);
		
		if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect("login.jsp"); // redirect if user not logged in
            return;
        }
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Profile</title>");
		out.println("<link rel='stylesheet' href='css/profile.css'>");
		out.println("</head>");
		out.println("<body>");
		
		
		out.println("<div class='profile-container'>");

		out.println("<h1>ID : " + session.getAttribute("id") + "</h1>");
		out.println("<h1>Name : " + session.getAttribute("name") + "</h1>");
		out.println("<h1>Email : " + session.getAttribute("email") + "</h1>");
		out.println("<h1>Password : " + session.getAttribute("password") + "</h1>");
		out.println("<h1>Mobile : " + session.getAttribute("mobilenumber") + "</h1>");

		out.println("<div class='action-buttons'>");
		
		out.println("<a href='home.html'><button class='home-btn'>Back To Home</button></a>");

		out.println("<a href='updateadmin'><button class='update-btn'>Update</button></a>");

		out.println("<a href='delete?super=deleteadmin&message=displayall&id=" +
		        session.getAttribute("id") +
		        "'><button class='delete-btn'>Delete</button></a>");

		out.println("</div>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

}
