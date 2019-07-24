<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>novi podaci</title>
</head>
<body>
	
	<h2 style="text-align: center; color:black;">NOVI PODACI</h2><br>
	
	<a href = "administrator.jsp" class="btn btn-primary">Back to admin page</a><br><br>
	
	 <% 
	 	/*long idUser = (long)request.getAttribute("idUser");	
	 	String userName = (String)request.getAttribute("userName");
		String password = (String)request.getAttribute("password");
		double novcanik = (double)request.getAttribute("novcanik");*/
		User user = (User)request.getAttribute("user");
	%>
	
	<p>Unesi nove podatke za usera!!!</p>
		<form action="EditUserDugmeServlet2"  method="get">
						   <input type="hidden" value="<%= user.getIdUser()%>" name="idUser"/>
				USER NAME: <input type="text" placeholder= " <%= user.getUserName() %>" name = "userName"><br>
				PASSWORD : <input type="text" placeholder= " <%= user.getPassword() %>" name = "password"><br>
				NOVCANIK : <input type="text" placeholder= " <%= user.getNovcanik() %>" name = "novcanik"><br><br>
						   <input style=" color:red; " type="submit"   value ="IZMENI">		
		</form>
	
	
</body>
</html>