<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>dodaj artikal</title>
</head>
<body background="../slike/bck.png" style="background-repeat: no-repeat; width: 100%; background-size: cover;">

<h3 style="text-align: center; color: white;">Dodajte artikal</h3><br>
<a href  ="administrator.jsp" class="btn btn-primary">Back to admin page</a><br>

	<form action="../AddArtikalServlet">
		<p style=" color:white;">Ime artikla:</p>  <input type="text" 	name = "imeArtikla"><br><br>
		<p style=" color:white;">Cena: </p>		 <input type="text" 	name = "cena"><br><br>
		<p style=" color:white;">Stanje:</p>	 	 <input type="text" 	name = "stanje"><br><br>
		<p style=" color:white;">Popust:</p>  	 <input type="text" 	name = "popust"><br><br>
		<button type="submit" class="btn btn-primary">DODAJ</button>
	</form>
	
</body>
</html>