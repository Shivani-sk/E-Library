package com.Jspiders.elibrary.crud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.Jspiders.elibrary.db.DbOperations;
import com.Jspiders.elibrary.entity.Librarian;
import com.mysql.jdbc.Driver;

public class LibrarianCRUD 
{
	public boolean save(Librarian librarian)
	{
		boolean bool=false;
		PreparedStatement pstmt = null;
		Connection con = DbOperations.giveConnection();
		
		String query=" insert into librarian "
				     + " values(?,? ? ?) ";
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, librarian.getName());
				pstmt.setString(2, librarian.getEmail());
				pstmt.setString(3, librarian.getPassword());
				pstmt.setLong(4, librarian.getMobile());
				
				int update = pstmt.executeUpdate();
				if(update !=0)
				{
					bool=true;
				}
			}catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
				{
					try
					{
						if(con != null)
						{
							con.close();
						}
						if(pstmt != null)
						{
							pstmt.close();
						}
					}catch(SQLException e) 
					{
						e.printStackTrace();
					}
				}
			return bool;
	}
	
public void read()
{
	Statement stmt = null;
	ResultSet rs = null;
	try 
	{
		Connection con = DbOperations.giveConnection();
		String query="select * from e_librarian";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		while(rs.next())
		{
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			String email = rs.getString("Email");
			String password = rs.getString("Password");
			long mobile = rs.getLong("Mobile");
			
			System.out.println("ID:"+id);
			System.out.println("Name:"+name);
			System.out.println("Email:"+email);
			System.out.println("Password:"+password);
			System.out.println("Mobile:"+mobile);
			
		}
	    
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(stmt != null)
			{
				stmt.close();
			}
			if(rs != null)
			{
				rs.close();
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
public void Update(Librarian librarian)
{
	
	PreparedStatement pstmt = null;
	try 
	{   
		Connection con = DbOperations.giveConnection();
		String query ="insert into studentinfo values(?,?,?,?)";
		pstmt=con.prepareStatement(query);
		
		
		
		int res= pstmt.executeUpdate();
		if(res != 0) 
		{
			System.out.println("Record Inserted");
		}
	}
	catch(SQLException e1)
	{
		e1.printStackTrace();
	}
	finally 
	{
		try
		{
			if(pstmt != null)
			{
				pstmt.close();
			}
		}
		catch(SQLException e2) 
		{
			e2.printStackTrace();
		}
	}

}
public void delete(Librarian librarian) throws IOException
{
	File file = new File("C:\\Shivani\\J2EE Software\\MyProp.properties");
	FileReader reader = new FileReader(file);
	
	Properties prop = new Properties();
	prop.load(reader);
	
	Statement stmt = null;
	
	try {
		
		String dburl= prop.getProperty("url");
		Connection con = DbOperations.giveConnection();
		
		String query = " delete from studentsinfo where id=?";
		
		stmt = con.createStatement();
		
		int res = stmt.executeUpdate(query);
		if(res!=0)
		{
			System.out.println("Record Updated");
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	finally {
				try
				{
				if(stmt!=null)
				{
					stmt.close();
				}
					
				}catch(Exception e2)
				{
					e2.printStackTrace();
				}
	}
}

public boolean validation(String email, String password)
{
	boolean bool=false;
	PreparedStatement pstmt = null;
	Connection con = DbOperations.giveConnection();
	
	String query=" select * from librarian "
			     + " where email= ? and password = ? ";
	try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			int update = pstmt.executeUpdate();
			if(update != 0)
			{
				bool=true;
			}

		}catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				if(con != null)
				{
					con.close();
				}
				if(pstmt != null)
				{
					pstmt.close();
				}
			}catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
	return bool;
}

}



