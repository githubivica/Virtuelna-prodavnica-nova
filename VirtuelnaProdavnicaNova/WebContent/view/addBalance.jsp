<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add balance</title>

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body background="../slike/bck.png" style="background-repeat: no-repeat; width: 100%; background-size: cover;">

<h4 style="text-align: center; color: white;">Podesite balans usera u novcaniku</h4>

<a href="administrator.jsp" class="btn btn-primary">Back to admin page</a><br><br>

<form action="../AddBalanceServlet">
	<p style=" color:red;">User name: </p>  <input type="text" name = "userName"><br><br>
	<p style=" color:red;">Balance:  </p>   <input type="text" name = "balance"> <br><br>
	<button type="submit" class="btn btn-primary">DODAJ</button><br><br>	
</form>
 	
</body>
</html> 