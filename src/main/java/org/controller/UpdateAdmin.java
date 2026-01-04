package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateadmin")
public class UpdateAdmin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        int id = (Integer) session.getAttribute("id");
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        long mobilenumber = (Long) session.getAttribute("mobilenumber");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Update Admin</title>");
        out.println("<link rel='stylesheet' href='css/updateadmin.css'>");
        out.println("</head>");
        out.println("<body>");

        
        out.println("<div class='top-nav'>");
        out.println("<a href='home.html' class='home-btn'>Back to Home</a>");
        out.println("</div>");

        /* Form container */
        out.println("<div class='form-container'>");
        out.println("<h2>Update Admin Details</h2>");

        out.println("<form action='updateadmindao' method='post'>");

        out.println("<label>ID</label>");
        out.println("<input type='number' name='id' value='" + id + "' readonly>");

        out.println("<label>Name</label>");
        out.println("<input type='text' name='name' value='" + name + "' required>");

        out.println("<label>Email</label>");
        out.println("<input type='email' name='email' value='" + email + "' required>");

        out.println("<label>Password</label>");
        out.println("<input type='password' name='password' value='" + password + "' required>");

        out.println("<label>Mobile Number</label>");
        out.println("<input type='tel' name='mobilenumber' value='" + mobilenumber + "' required>");

        out.println("<div class='action-buttons'>");
        out.println("<a href='profile'><button type='button' class='back-btn'>Back</button></a>");
        out.println("<button type='submit' class='update-btn'>Update</button>");
        out.println("</div>");

        out.println("</form>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
