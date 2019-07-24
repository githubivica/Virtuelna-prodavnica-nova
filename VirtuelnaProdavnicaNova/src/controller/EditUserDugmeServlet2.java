package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.LoginDAO;
//import dao.LoginDAO;
import model.User;

@WebServlet(description = "ovaj servlet unete vrednosti upisuje u bazu", urlPatterns = { "/EditUserDugmeServlet2" })
public class EditUserDugmeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//User user = (User)request.getAttribute("user");			//preko getAttribute sam uzeo usera iz EditUserDugmeServlet
		String idUser =  request.getParameter("idUser");

		long idUser2 = Long.parseLong(idUser);

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String novcanik = request.getParameter("novcanik");

		double novcanikDouble = Double.parseDouble(novcanik);

		LoginDAO ld = new LoginDAO();				//ne treba posto sam usera useo preko getAttribute
		User user = ld.vratiUseraPoId(idUser2);
		user.setUserName(userName);
		user.setPassword(password);
		user.setNovcanik(novcanikDouble);

		boolean izmeniUsera = AdminDAO.izmeniUsera(user);
			if (izmeniUsera) {
				response.sendRedirect("view/administrator.jsp");
			}else {
				response.sendRedirect("view/administrator.jsp");
			}
		
	
	}
}