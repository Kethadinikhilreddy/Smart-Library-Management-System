package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.BookDAO;
import org.dto.BookDetails;


@WebServlet("/displayallbooks")
public class DisplayAllBooks  extends HttpServlet{
	
	 private BookDAO bookDAO=new BookDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<BookDetails> resultList = bookDAO.getAllBooks();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Display Books</title>");
		out.println("<link rel='stylesheet' href='css/displayall.css'>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class='top-bar'>");
		out.println("<a href='home.html' class='home-btn'>Back to Home</a>");
		out.println("</div>");


		
		
		if(resultList.isEmpty()) {
			out.println("<h1>No Books To Display</h1>");
		}
		
		else {
			out.println("<table>");
			out.println("<tr>");
			out.println("<th> ID</th>");
			out.println("<th> NAME</th>");
			out.println("<th> AUTHOR_NAME</th>");
			out.println("<th> AUTHOR_EMAIL</th>");
			out.println("<th> PUBLISHED DATE</th>");
			out.println("<th> BOOK_GENRE</th>");
			out.println("<th> Update</th>");
			out.println("<th> Delete</th>");
			out.println("</tr>");
			
			for(BookDetails book:resultList) {
				
				out.println("<tr>");
				out.println("<td>"+book.getId()+"</td>");
				out.println("<td>"+book.getName()+"</td>");
				out.println("<td>"+book.getAuthor_name()+"</td>");
				out.println("<td>"+book.getAuthor_email()+"</td>");
				out.println("<td>"+book.getPublished_date()+"</td>");
				out.println("<td>"+book.getGenre()+"</td>");
				out.println("<td><a href='updatebook?message=displayall&id=" + book.getId() +
				        "'><button class='update-btn'>Update</button></a></td>");

				out.println("<td><a href='delete?super=deletebook&message=displayall&id=" + book.getId() +
				        "'><button class='delete-btn'>Delete</button></a></td>");

				out.println("</tr>");
				
			}
			out.println("</table>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
