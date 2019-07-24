<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>
<%@ page import="model.Artikal" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>   
<%@page import="dao.AdminDAO"%>
<%@page import="dao.UserDAO"%>     
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>administrator page</title>
</head>
<body>
	
	<%
	User user = (User)session.getAttribute("ovdeJeUserObjekat");
	%>
	<h1 style="text-align: center; font-size: 25px;">DOBRODOŠLI <%=user.getUserName() %> </h1>
		
		<p style="text-align: left; font-size: 20px;">Ovde mozes podesavati usere i artikle administratorskih poslova</p>
		
		<a href="../index.html" class="btn btn-primary">Back to index page</a><br>
	<%
		List<User> listaUsera = new ArrayList<User>();
		listaUsera = AdminDAO.vratiSveUsere();
	%>
	
	<hr>
		<a href = "addBalance.jsp"><button>ADD BALANCE</button></a>
		<a href = "deleteUser.jsp"><button>DELETE USER</button></a>
		<a href = "editUserDugme.jsp"><button>EDIT USER</button></a>
		<br><br>
		
	<table border="1">
		<tr>
			<th> ID        </th>
			<th> USER NAME </th>
			<th> PASSWORD  </th>
			<th> NOVCANIK  </th>
			<th> ULOGA  </th>
		</tr>
		<%
			for(User u: listaUsera){
		%>
			<tr>
				<td> <%= u.getIdUser()   %> </td>
				<td> <%= u.getUserName() %> </td>
				<td> <%= u.getPassword() %> </td>
				<td> <%= u.getNovcanik() %> </td>
				<td> <%= u.getRola() %> </td>
			</tr>
		<%
			}
		%>
	</table>
	
	<hr>
		<a href = "addArtikal.jsp"><button>ADD ARTIKAL</button></a><br><br>
	
	<%
		List<Artikal> listaArtikala = new ArrayList<Artikal>();
		listaArtikala = UserDAO.vratiSveArtikle();
	
	%>
	<table border="1">
		<tr>
			<th> ID ARTIKAL  </th>
			<th> IME ARTIKLA </th>
			<th>    CENA     </th>
			<th>   STANJE    </th>
			<th>   POPUST    </th>
		</tr>
		<%
			for(Artikal u: listaArtikala){
		%>
			<tr>
				<td> <%= u.getIdArtikal()   %> </td>
				<td> <%= u.getImeArtikla() %> </td>
				<td> <%= u.getCena() %> </td>
				<td> <%= u.getStanje() %> </td>
				<td> <%= u.getPopust() %> </td>
			</tr>
		<%
			}
		%>
	</table><br>

</body>
</html>


