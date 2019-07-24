<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.User" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Artikal" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>user page</title>
</head>
<body background="../slike/bck.png" style="background-repeat: no-repeat; width: 100%; background-size: cover;">
	<%
		User user = (User)session.getAttribute("ovdeJeUserObjekat");		//iz LoginServlet
	%>
	
	<h2 style="text-align: center; color:white;">ZDRAVO <%=user.getUserName() %></h2><br>
	
	<a href="../index.html" class="btn btn-primary">Back to index page</a><br><br>

	<h3 style="text-align: center; color:red;">STANJE NA VASEM RACUNU JE: <%=user.getNovcanik() %> </h3>

	<%
		UserDAO userDAO = new UserDAO();
		List<Artikal> listaArtikala = userDAO.vratiSveArtikle();
	%>
	<form action="../PlatiRacunServlet" metod="get">
		<table border="1" style="color: red">
			<tr style="color: yellow">
				<th>id</th>
				<th>ime</th>
				<th>cena</th>
				<th>popust</th>
				<th>check</th>
				<th>kolicina</th>
			</tr>
			<% 
				for(Artikal a: listaArtikala){
			%>
				<tr style="color: yellow">
					<td><%=a.getIdArtikal() %></td>
					<td><%=a.getImeArtikla() %></td>
					<td><%=a.getCena()%></td>
					<td><%=a.getPopust()%></td>
					<td><input type="checkbox" name = "check" value="<%=a.getIdArtikal() %>"></td>
					<td>
						<select name="kolicina">
							<%
								for(int i = 0; i<= a.getStanje(); i++){
							%>
								<option value="<%=i %>"><%=i%></option>
							<% 
								}
							%>
						</select>
					</td>
				</tr>
			<%
				}
			%>	
		</table><br><br>
			<button type="submit" class="btn btn-primary">PLATI RACUN</button>
	</form>

	
	
</body>
</html>


