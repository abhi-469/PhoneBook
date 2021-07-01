package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.DbConnect;
import dao.ContactDAO;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int contactId=Integer.parseInt(req.getParameter("contactId"));
		ContactDAO dao=new ContactDAO(DbConnect.getConn());
		boolean f=dao.deleteContact(contactId);
		
		HttpSession session=req.getSession();
		if(f)
		{
			session.setAttribute("successMsg", "Contact deleted successfullly");
			resp.sendRedirect("viewContact.jsp");
		}
		else
		{
			session.setAttribute("errorMsg", "Something Went Wrong");
			resp.sendRedirect("viewContact.jsp");
		}
		
	}

	
	
}
