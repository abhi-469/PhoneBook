package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Contact;

public class ContactDAO {
	private Connection conn;
	
	public ContactDAO(Connection conn)
	{
		this.conn=conn;
	}
	
	public boolean saveContact(Contact contact)
	{
		boolean f=false;
		try
		{
			String sql="insert into contact(name,email,phoneNo,about,userId) value(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getPhoneNo());
			ps.setString(4, contact.getAbout());
			ps.setInt(5, contact.getUserId());
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public List<Contact> getAllContact(int userId)
	{
		List<Contact> contacts=new ArrayList<Contact>();
		Contact contact=null;	
		try
		{
			String sql="select * from contact where userId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,userId);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				contact=new Contact(rs.getString("name"),rs.getString("email"),rs.getString("phoneNo"),rs.getString("about"),rs.getInt("userId"));
				contact.setId(rs.getInt("id"));
				contacts.add(contact);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return contacts;
	}
	
	public Contact getContactById(int userId)
	{
		Contact contact=new Contact();	
		try
		{
			String sql="select * from contact where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				contact=new Contact(rs.getString("name"),rs.getString("email"),rs.getString("phoneNo"),rs.getString("about"),rs.getInt("userId"));

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return contact;
	}
	
	public boolean updateContact(Contact contact)
	{
		boolean f=false;	
		try
		{
			String sql="update contact set name=?,email=?,phoneNo=?,about=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getPhoneNo());
			ps.setString(4, contact.getAbout());
			ps.setInt(5, contact.getId());
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteContact(int userId)
	{
		boolean f=true;
		
		try
		{
			String sql="delete from contact where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
}
