package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.DbConnect;
import dao.UserDAO;
import entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User user=new User(name,email,password);
		UserDAO dao=new UserDAO(DbConnect.getConn());
		boolean f=dao.userRegister(user);
		
		HttpSession session=request.getSession();
		
		if(f)
		{
			session.setAttribute("successMsg","User Register Successfully");
			response.sendRedirect("register.jsp");
		}
		else
		{
			session.setAttribute("errorMsg","Something went wrong");
			response.sendRedirect("register.jsp");
		}
		
	}
}
