package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;

@WebServlet(description = "brisanje usera u bazi", urlPatterns = { "/DeleteUserServlet" })
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		
		boolean obrisiUsera = AdminDAO.obrisiUsera(userName);

			if(obrisiUsera) {
				response.sendRedirect("view/administrator.jsp");
			}else {
				response.sendRedirect("view/deleteUserError.jsp");
			}
		
	}

}
