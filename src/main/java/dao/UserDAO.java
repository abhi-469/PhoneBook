package dao;

import java.sql.*;
import entity.User;

public class UserDAO {
	private Connection conn;
	
	public UserDAO(Connection conn)
	{
		super();
		this.conn=conn;
	}
	
	public boolean userRegister(User u)
	{
		boolean f=false;
		
		try
		{
			String sql="insert into user(name,email,password) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return f;
	}
	
	
	public User userLogin(String email,String password) throws SQLException
	{
		User u=null;
		try
		{
			String sql="select * from user where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				u=new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return u;
	}
}
