package com.techpalleaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student 
{
	Statement s=null;
	Connection con=null;
	PreparedStatement ps=null;
	
	public static String url ="jdbc:mysql://localhost:3306/palle";
	public static String username="root";
	public static String password="admin";
	public void creating()
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
	        s=con.createStatement();
	        s.executeUpdate("create table Student(sno int primary key auto_increment,"
	        		+ "sname varchar(40) not null,sub varchar(40),email varchar(40) unique)");
	          
	    } 
		
		catch (ClassNotFoundException e) 
		{
		    e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(s!=null)
			try 
			{
				s.close();
				
			} 
			catch (SQLException e)
			{
			
				e.printStackTrace();
			}
			if(con!=null)
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
				e.printStackTrace();
				}
	    }
	}
	public void inserting(String name,String sub,String email) throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("insert into Student(sname,sub,email) values(?,?,?)");
		ps.setString(1,name);
        ps.setString(2,sub);
        ps.setString(3,email);
        
        ps.executeUpdate();
        
        ps.close();
        con.close();
	}
	public void Updating(int sno,String email,String sub) throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("update Student set sub=?,email=? where sno=?");
		ps.setString(1,sub);
        ps.setString(2,email);
        ps.setInt(3,sno);
        
        ps.executeUpdate();
        
        ps.close();
        con.close();
	}
	public void Deleting(int sno) throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("delete from Student where sno=?");
        ps.setInt(1,sno);
        
        ps.executeUpdate();
        
        ps.close();
        con.close();
	}
	public  void read() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		String qry ="select * from Student";
        s=con.createStatement();
        
        ResultSet rs =s.executeQuery(qry);
        while(rs.next()==true)
        {
            System.out.println(rs.getInt("sno"));	 
            System.out.println(rs.getString("sname"));
            System.out.println(rs.getString("sub"));
            System.out.println(rs.getString("email"));
            
        }
        rs.close();
        s.close();
        con.close();
	}
	
}
	
