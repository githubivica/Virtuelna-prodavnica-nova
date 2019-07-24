<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User"%>
<%@ page import="model.Artikal"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>racun</title>
</head>

<body background="../slike/bck.png" style="background-repeat: no-repeat; width: 100%; background-size: cover;">
<%	User user = (User) session.getAttribute("ovdeJeUserObjekat");		//ovo uzima iz sesije - LoginServlet!
	double totalPrice = (double)request.getAttribute("totalPrice");		//uzima iz PlatiRacun Servlet!
	List<Artikal> listaArtikala = (List<Artikal>)request.getAttribute("listaArtikala");	//uzima iz PlatiRacun Servlet!
	List<String> listaKolicina = (List<String>)request.getAttribute("listaKolicina");	//uzima iz PlatiRacun Servlet!
%>

<h3 style="text-align: center; color:red;"> <%=user.getUserName() %> je narucio </h3>
<a href="view/user.jsp" class="btn btn-primary">Back to User</a><br><br>

Racun: 	<table border="1"style="color: red">
			<tr style="color: black">
				<th>ime artikla</th>
				<th>cena</th>
				<th>popust</th>
				<th>kolicina</th>
			</tr>
			<% for(int i = 0; i<listaArtikala.size() ; i++){ %>
				<tr style="color: black">
					<td><%=listaArtikala.get(i).getImeArtikla() %></td>
					<td><%=listaArtikala.get(i).getCena() %></td>
					<td><%=listaArtikala.get(i).getPopust() %></td>
					<td><%=listaKolicina.get(i)%></td>
				</tr>
			<%} %>
		</table>
		<br>

Total price: <%=totalPrice %> <br><br>

<a href="index.html" class="btn btn-primary">Back to index page</a>			
</body>
</html>