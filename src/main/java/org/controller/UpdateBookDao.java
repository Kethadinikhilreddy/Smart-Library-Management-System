package org.controller;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.BookDAO;
import org.dto.BookDetails;

@WebServlet("/updatebookdao")
public class UpdateBookDao extends HttpServlet {
	
	private BookDAO bookDAO = new BookDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name").trim();
		String author_name=request.getParameter("author_name").trim();
		String author_email=request.getParameter("author_email").trim();
		String stringDate=request.getParameter("date").trim();
		Date date=Date.valueOf(stringDate);
		String genre=request.getParameter("genre").trim();
		String message=request.getParameter("message");
		
		
		BookDetails updatedBook = new BookDetails();
		
        updatedBook.setId(id);
        updatedBook.setName(name);
        updatedBook.setAuthor_name(author_name);
        updatedBook.setAuthor_email(author_email);
        updatedBook.setPublished_date(date);
        updatedBook.setGenre(genre);
		
		
        boolean success = bookDAO.updateBook(updatedBook);

        if (success) {
            if ("displayall".equals(message)) {
                response.sendRedirect("displayallbooks");
            } else if ("getbook".equals(message)) {
                response.sendRedirect("getbook?id=" + id);
            }
        }else {
            response.getWriter().println("<h1>Book not found or update failed</h1>");
        }
        
		
	}
	

}
