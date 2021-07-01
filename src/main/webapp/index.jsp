<%@ page import="java.sql.*,conn.DbConnect" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="Component/allCss.jsp" %>
<style type="text/css">
.back-img{
	background: url("images/phonebook2.jpg");
	width: 100%;
	height: 90vh;
	background-repeat:no-repeat;
	background-size:cover;
}
</style>

</head>
<body>
	<%@include file="Component/navbar.jsp" %>
	
	
	
	<div class="container-fluid back-img text-center text-success" >
		<h1>Welcome to PhoneBook App</h1>
	</div>
	
	<%@include file="Component/footer.jsp" %>
</body>

</html>