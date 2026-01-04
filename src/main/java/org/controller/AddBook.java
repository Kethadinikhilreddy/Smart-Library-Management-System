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

@WebServlet("/addbook")
public class AddBook extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 BookDAO bookDAO = new BookDAO();
		
		String book_name=request.getParameter("book_name");
		String author_name=request.getParameter("author_name");
		String author_email=request.getParameter("author_email");
		String genre=request.getParameter("book_genre");
		String stringDate=request.getParameter("date");
		Date date=Date.valueOf(stringDate);
		
		BookDetails bookDetails=new BookDetails(book_name, author_name, author_email, date, genre);
		
		
		bookDAO.save(bookDetails);
		
		
		response.sendRedirect("displayallbooks");
		
		
		
		
	}

}
