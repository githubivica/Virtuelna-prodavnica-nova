<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>obrisi usera</title>
</head>
<body>
<h2 style="text-align: center; color: black;">Obrisite usera</h2><br>

<a href = "administrator.jsp" class="btn btn-primary" id="btnNazad" style="position: relative; left: 66px;">Nazad</a><br><br>

	<form action="../DeleteUserServlet">
		<p style=" color:red; position: relative; left: 66px;">User name: <input type="text" 	name = "userName"><br><br>
				<input style=" color:red; position: relative;" type="submit"   value ="OBRISI">
	</form>
</body>
</html>