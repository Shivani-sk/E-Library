package com.Jspiders.elibrary.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Jspiders.elibrary.crud.LibrarianCRUD;

public class LibrarianLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		
        PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("Email");
		String password = req.getParameter("Password");

		LibrarianCRUD librarianCRUD = new LibrarianCRUD();
		if(librarianCRUD.validation(email,password))
		{
			out.println("Librsrisn Login sucessful");
			req.getRequestDispatcher("navlibrarian.html").include(req,resp);
		}
		else
		{
			out.println("Invalid Email or Password");
			req.getRequestDispatcher("librarianloginform.html").include(req,resp);
		}
	}
}
