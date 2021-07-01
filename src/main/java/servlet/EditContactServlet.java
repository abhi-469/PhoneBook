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
import entity.Contact;

@WebServlet("/update")
public class EditContactServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phoneNo=req.getParameter("phoneNo");
		String about=req.getParameter("about");
		int userId=Integer.parseInt(req.getParameter("userId"));
		
		Contact contact=new Contact(name,email,phoneNo,about,userId);
		contact.setId(Integer.parseInt(req.getParameter("contactId")));
		ContactDAO dao=new ContactDAO(DbConnect.getConn());		
		boolean f=dao.updateContact(contact);
		HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("successMsg", "Contact upated successfullly");
			resp.sendRedirect("editContact.jsp?contactId="+req.getParameter("contactId"));
		}
		else
		{
			session.setAttribute("errorMsg", "Something Went Wrong");
			resp.sendRedirect("editContact.jsp?contactId="+req.getParameter("contactId"));
		}
		
	}
	
}
