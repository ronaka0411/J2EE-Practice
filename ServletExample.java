package com.example.tutorial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExample
 */
@WebServlet("/servletexample")
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello JAVA");
//		out.println("<html>");
//		out.println("ROnak");
//		out.println("</html>");
		if (request.getParameter("FirstName") == null || request.getParameter("LastName") == null) {
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		return;
		}
		String firstname = request.getParameter("FirstName");
		String Lastname = request.getParameter("LastName");
		
		request.setAttribute("firstname", firstname);
		request.setAttribute("lastname", Lastname);
		
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
		
		//out.println(firstname + " " + Lastname);
	}

}
