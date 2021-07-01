<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	

	<div class="container-fluid">
		<div class="row pt-5">
			<div class="col-md-5 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Login</h3>
						
						<%String errorMsg=(String)session.getAttribute("errorMsg");
						  if(errorMsg!=null)
						  {
						%>
							<p class="text-center text-danger"><%=errorMsg %></p>	  
						<% 
							session.removeAttribute("errorMsg");
						  }
						%>
						
						
						<%String logoutMsg=(String)session.getAttribute("logoutMsg");
						  if(logoutMsg!=null)
						  {
						%>
							<p class="text-center text-success"><%=logoutMsg%></p>	  
						<% 
							session.removeAttribute("logoutMsg");
						  }
						%>
						
						<form action="login" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> 
								<input name="email" type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> 
								<input name="password" type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div style="margin-top: 300px"></div>

	<%@include file="Component/footer.jsp"%>
</body>
</html>