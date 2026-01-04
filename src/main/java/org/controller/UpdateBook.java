package org.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.BookDAO;
import org.dto.BookDetails;

@WebServlet("/updatebook")
public class UpdateBook extends HttpServlet {

	
	 private BookDAO bookDAO = new BookDAO();
	 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String message = request.getParameter("message");

        

        BookDetails bookDetails = bookDAO.getBookById(id);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Update Book</title>");
        out.println("<link rel='stylesheet' href='css/updatebook.css'>");
        out.println("</head>");
        out.println("<body>");

        // Top bar
        out.println("<div class='top-bar'>");
        out.println("<a href='home.html' class='home-btn'> Back to Home</a>");
        out.println("</div>");

        if (bookDetails != null) {

            out.println("<div class='form-container'>");
            out.println("<h2>Update Book</h2>");

            out.println("<form action='updatebookdao' method='post'>");

            out.println("<label>Book ID</label>");
            out.println("<input type='number' name='id' value='" + bookDetails.getId() + "' readonly>");

            out.println("<label>Book Name</label>");
            out.println("<input type='text' name='name' value='" + bookDetails.getName() + "' required>");

            out.println("<label>Author Name</label>");
            out.println("<input type='text' name='author_name' value='" + bookDetails.getAuthor_name() + "' required>");

            out.println("<label>Author Email</label>");
            out.println("<input type='email' name='author_email' value='" + bookDetails.getAuthor_email() + "' required>");

            out.println("<label>Published Date</label>");
            out.println("<input type='date' name='date' value='" + bookDetails.getPublished_date() + "' required>");

            out.println("<label>Genre</label>");
            out.println("<input type='text' name='genre' value='" + bookDetails.getGenre() + "' required>");

            out.println("<input type='hidden' name='message' value='" + message + "'>");

            out.println("<button type='submit' class='update-btn'>Update Book</button>");
            out.println("</form>");
            out.println("</div>");

        } else {
            out.println("<h2>No Book Found</h2>");
        }

        out.println("</body>");
        out.println("</html>");

        
    }
}
