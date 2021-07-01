package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.DbConnect;
import dao.UserDAO;
import entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDAO dao=new UserDAO(DbConnect.getConn());
		try 
		{
			User user=dao.userLogin(email, password);
			
			HttpSession session=request.getSession();
			if(user!=null)
			{
				session.setAttribute("user", user);
				response.sendRedirect("index.jsp");
				
//				session.setAttribute("id", user.getId());
//				session.setAttribute("name", user.getName());
//				session.setAttribute("email", user.getEmail());
//				session.setAttribute("password", user.getPassword());
			}
			else
			{
				session.setAttribute("errorMsg","Invalid Email or Password");
				response.sendRedirect("login.jsp");
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}
}
