package com.Jspiders.elibrary.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
			resp.setContentType("text/html");
			
	        PrintWriter out = resp.getWriter();
			
			String email = req.getParameter("Email");
			String password = req.getParameter("Password");
			if(email.equals("admin@jspiders.com") 
					&& password.equals("8055"))
			{
				req.getRequestDispatcher("navadmin.html").include(req,resp);
			}
			else
			{
				out.println("Invalid Email address and Password");
				req.getRequestDispatcher("index.html").include(req,resp);
				
			}
	}


}
