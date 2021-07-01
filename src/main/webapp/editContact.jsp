<%@page import="dao.ContactDAO,entity.Contact,conn.DbConnect" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="Component/allCss.jsp"%>
</head>
<body>
<%@include file="Component/navbar.jsp"%>
<% if(user==null)
	{
		session.setAttribute("errorMsg","Please Login");
		response.sendRedirect("login.jsp");
	}
%>

	<div class="container-fluid">
		<div class="row pt-5">
			<div class="col-md-5 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Edit Contact</h3>
						
						<%String successMsg=(String)session.getAttribute("successMsg");
						  String errorMsg=(String)session.getAttribute("errorMsg");
						%>
						
						<%if(successMsg!=null){
						%>
						<p class="text-center text-success"><%=successMsg %></p>
						<%
								session.removeAttribute("successMsg");
							}
						%>
						
						<%if(errorMsg!=null){
						%>
						<p class="text-center text-success"><%=errorMsg %></p>
						<%
								session.removeAttribute("errorMsg");
							}
						%>
						
						
						<form action="update" method="post">
						<%
							ContactDAO dao=new ContactDAO(DbConnect.getConn());
							int contactId=Integer.parseInt(request.getParameter("contactId"));
							
							Contact contact=dao.getContactById(contactId);
						%>
						
							<%if(user!=null)
							{
							%>
								<input name="userId" type="hidden" value="<%= user.getId() %>"/>
							<% 
							}
							%>
							<input name="contactId" type="hidden" value="<%= contactId %>"/>
							<div class="form-group">
								<label for="exampleInputName">Enter Name</label> 
								<input name="name" value="<%=contact.getName() %>" type="text" class="form-control" id="exampleInputName1" aria-describedby="emailHelp" >
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email address</label> 
								<input name="email" value="<%=contact.getEmail() %>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
							</div>
							
							<div class="form-group">
								<label for="exampleInputPhoneNo">Enter Phone No</label> 
								<input name="phoneNo"  value="<%=contact.getPhoneNo() %>" type="text" class="form-control" id="exampleInputPhoneNo1" aria-describedby="emailHelp" >
							</div>
							
							<div class="form-group">
								<label for="exampleInputAbout"></label> 
								<input name="about"  value="<%=contact.getAbout() %>" type="text" class="form-control" id="exampleInputAbout1" aria-describedby="emailHelp" placeholder="Enter About">
							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Save Contact</button>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	<div style="margin-top: 170px"></div>

	<%@include file="Component/footer.jsp"%>
</body>
</html>