package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LoginDAO;
import model.User;
@WebServlet(description = "ovaj uzima usera i salje u jsp", urlPatterns = { "/EditUserDugmeServlet" })
public class EditUserDugmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
		
		LoginDAO ld = new LoginDAO();
		
		boolean proveriUsername = ld.daLiPostojiUserUbazi(userName);
		
		if(proveriUsername) {
			User user = ld.vratiUsera(userName);				//ovde imam usera
			
			long idUser = user.getIdUser();						//ovde imam idUsera
			String password =  user.getPassword();
			double novcanik =  user.getNovcanik();

				request.setAttribute("user", user);				//u setAttribute postavljam usera
			/*	request.setAttribute("idUser", idUser);			//u setAttribute postavljam idUsera
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				request.setAttribute("novcanik", novcanik);	*/

				RequestDispatcher rd = request.getRequestDispatcher("view/editUserDugme2.jsp");
				rd.forward(request, response);
			
		}else {
			response.sendRedirect("view/administrator.jsp");
		}
	
	}
}