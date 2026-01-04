package org.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.BookDAO;
import org.dao.UserDAO;
import org.dto.BookDetails;
import org.dto.UserDetails;

@WebServlet("/delete")
public class DeleteBookAndAdmin extends HttpServlet {

	private UserDAO userDAO = new UserDAO();
    private BookDAO bookDAO = new BookDAO();
	
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        int id = Integer.parseInt(request.getParameter("id"));
        String message = request.getParameter("message");
        String supermessage = request.getParameter("super");

        if ("deleteadmin".equals(supermessage)) {
            boolean deleted = userDAO.deleteUserById(id);
            if (deleted) {
                response.sendRedirect("login.jsp");
            } else {
                response.getWriter().println("User not found");
            }
        } 
        else if ("deletebook".equals(supermessage)) {
            boolean deleted = bookDAO.deleteBookById(id);
            if (deleted) {
                response.sendRedirect("displayallbooks");
            } else {
                response.getWriter().println("Book not found");
            }
        }
    }
}
