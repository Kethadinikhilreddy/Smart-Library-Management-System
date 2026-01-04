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

@WebServlet("/getbook")
public class GetBookById extends HttpServlet {

	private BookDAO bookDAO=new BookDAO();
	
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            response.getWriter().println("<h2>Invalid Request: Book ID is missing</h2>");
            response.getWriter().println("<a href='getbookbyid.html'>Go Back</a>");
            return;
        }

        int id = Integer.parseInt(idParam);
        
        BookDetails bookDetails = bookDAO.getBookById(id);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Details</title>");
        out.println("<link rel='stylesheet' href='css/displaybookbyid.css'>");
        out.println("</head>");
        out.println("<body>");

        
        out.println("<div class='top-nav'>");
        out.println("<a href='home.html' class='home-btn'>Back to Home</a>");
        out.println("</div>");

        
        out.println("<div class='book-container'>");

        if(bookDetails != null) {
            out.println("<div class='book-card'>");
            out.println("<h2>Book Details</h2>");
            out.println("<p><strong>ID:</strong> " + bookDetails.getId() + "</p>");
            out.println("<p><strong>Name:</strong> " + bookDetails.getName() + "</p>");
            out.println("<p><strong>Author Name:</strong> " + bookDetails.getAuthor_name() + "</p>");
            out.println("<p><strong>Author Email:</strong> " + bookDetails.getAuthor_email() + "</p>");
            out.println("<p><strong>Published Date:</strong> " + bookDetails.getPublished_date() + "</p>");
            out.println("<p><strong>Genre:</strong> " + bookDetails.getGenre() + "</p>");

            out.println("<div class='action-buttons'>");
            out.println("<a href='getbookbyid.html'><button>Back</button></a>");
            out.println("<a href='updatebook?message=getbook&id=" +id+ "'><button class='update-btn'>Update</button></a>");
            out.println("<a href='delete?super=deletebook&message=displayall&id=" + bookDetails.getId() + "'><button class='delete-btn'>Delete</button></a>");
            out.println("</div>"); 

            out.println("</div>"); 
        } else {
            out.println("<h2>No Book Found with ID: " + id + "</h2>");
        }

        out.println("</div>"); 
        out.println("</body>");
        out.println("</html>");
    }
}
