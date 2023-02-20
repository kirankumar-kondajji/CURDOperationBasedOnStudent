package com.techpalleaa;

import java.sql.SQLException;

public class MyProgramjdbc
{

	public static void main(String[] args) 
	{
	Student s1 =new Student();
	       // s1.creating();
	       try 
	        {
				//s1.inserting("kiran", "java", "kirankondajji03@gmail.com");
				//s1.inserting("Shankargouda","SQL", "Shankargouda26@gmail.com");
	    	   //s1.Updating(1, "hunter26@gmail.com", "corePython");
	    	  // s1.Deleting(4);
	    	   //s1.Deleting(5);
	    	   s1.read();
			} 
	        catch (ClassNotFoundException e) 
	        {
	        	e.printStackTrace();
			} 
	        catch (SQLException e)
	        {
				e.printStackTrace();
			}

	}
	
  }

