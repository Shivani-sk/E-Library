package com.Jspiders.elibrary.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Jspiders.elibrary.crud.LibrarianCRUD;
import com.Jspiders.elibrary.entity.Librarian;

public class AddLibrarian extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
		
        String name=req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String smobile = req.getParameter("mobile");
		long mobile= Long.parseLong(smobile);
		
		Librarian librarian = new Librarian( name, email, password, mobile);
		LibrarianCRUD librarianCRUD = new LibrarianCRUD();
		boolean bool = librarianCRUD.save(librarian);
		if(bool==true)
		{
			out.print("Librarian added sucessfully");
			req.getRequestDispatcher("addlibrarianform.html").include(req, resp);
		}
		else {
			out.print("Librarian details are not added");
			req.getRequestDispatcher("addlibrarianform.html").include(req, resp);
		}
	}
}
