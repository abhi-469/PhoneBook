<%@ page import="dao.ContactDAO,java.util.*,entity.Contact,conn.DbConnect" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="Component/allCss.jsp"%>
<style type="text/css">
	.crd-ho:hover{
		background-color:#f5f3f2;
	}
</style>
</head>
<body>
	<%@include file="Component/navbar.jsp"%>
	<%
	if (user == null) {
		session.setAttribute("errorMsg", "Please Login");
		response.sendRedirect("login.jsp");
	}
	%>

	<%
	String successMsg = (String) session.getAttribute("successMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");
	%>

	<%
	if (successMsg != null) {
	%>
	<p class="text-center text-success"><%=successMsg%></p>
	<%
	session.removeAttribute("successMsg");
	}
	%>

	<%
	if (errorMsg != null) {
	%>
	<p class="text-center text-success"><%=errorMsg%></p>
	<%
	session.removeAttribute("errorMsg");
	}
	%>

	<div class="container">
		<div class="row p-4">
		
		<% if(user!=null)
			{
			   ContactDAO dao=new ContactDAO(DbConnect.getConn());
			   List<Contact> contacts=dao.getAllContact(user.getId()); 
			   
			   
		   for(Contact contact:contacts)
		   {
		%>	 
			
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>Name:<%=contact.getName() %></h5>
						<p>Email:<%=contact.getEmail() %></p>
						<p>PhoneNo:<%=contact.getPhoneNo() %></p>
						<p>About:<%=contact.getAbout() %></p>
						<a href="editContact.jsp?contactId=<%=contact.getId()%>" class="btn btn-success">Edit</a>
						<a href="delete?contactId=<%=contact.getId()%>" class="btn btn-danger">Delete</a>
					</div>
				</div>
			</div>	
		<% 
		   	}
		   }
		%>
			
		</div>
	</div>




	<div style="margin-top: 600px"></div>

	<%@include file="Component/footer.jsp"%>

</body>
</html>