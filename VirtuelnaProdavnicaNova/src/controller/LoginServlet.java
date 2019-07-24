package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.User;
import model.Rola;

@WebServlet(description = "Servlet za logovanje", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		LoginDAO loginDAO = new LoginDAO();
		User user = new User();

		boolean proveriUsera = loginDAO.daLiPostojiUserUbazi(userName);		//da li postoji user u bazi

			if(proveriUsera) {
																	
				boolean proveriPassword = loginDAO.daLiPasswordOdgovaraUseru(userName, password); //da li je dobar password

					if(proveriPassword) {						//ako je dobar password
						user = loginDAO.vratiUsera(userName);
						HttpSession session = request.getSession();
						session.setAttribute("ovdeJeUserObjekat", user);	//ovo uzima iz sesije - LoginServlet
							if(user.getRola().equals(Rola.GAZDA)) {			//ako je administrator
								response.sendRedirect("view/administrator.jsp");	//posalji ga na administrator page
							}else {													//ako nije administrator
								response.sendRedirect("view/user.jsp");				//posalji ga na user page
							}
					}else {										//ako nije dobar password vrati ga na login stranu
						response.sendRedirect("login.html");
					}

			}else {											//ako ne postiji user vrati ga na login stranu		
				response.sendRedirect("login.html");
			}


		
		
		
		
	}

}
