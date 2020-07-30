package com.Jspiders.elibrary.entity;

public class Librarian 
{
	private String name;
	private String email;
	private String password;
	private long mobile;
	

	public Librarian(String name, String email, String password, long mobile)
	{
		super();
		this.name=name;
		this.email=email;
		this.password=password;
		this.mobile=mobile;
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	public long getMobile()
	{
		return mobile;
	}
	
}
