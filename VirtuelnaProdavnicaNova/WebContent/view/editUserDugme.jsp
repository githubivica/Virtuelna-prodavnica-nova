<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>edit user dugme</title>
</head>
<body>
	<h2 style="text-align: center; color:black;">Unesi user name cije podatke zelis da menjas</h2><br>
	
	<a href = "administrator.jsp" class="btn btn-primary">Back </a><br><br>
	
	<form action="../EditUserDugmeServlet">
		Unesi User name: <input type="text" name = "userName">
			  			 <input style=" color:red; " type="submit"   value ="IZMENI">	
	</form>	
	
</body>
</html>