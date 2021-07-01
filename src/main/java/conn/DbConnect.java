package conn;

import java.sql.*;

public class DbConnect {
	private static Connection conn;
	
	public static Connection getConn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","password");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}
}
