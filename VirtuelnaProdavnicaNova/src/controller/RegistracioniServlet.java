package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validacija.ValidacijaZaRegistraciju;
import dao.RegistracijaDAO;

				//Servlet implementation class RegistracioniServlet
				//PutanjaServletaZaRegistraciju - ovo je mesto gde se nalazi server, ovo se kopira u klasu registracija u formi action
@WebServlet(description = "ovo je servlet za registraciju usera", urlPatterns = { "/PutanjaServletaZaRegistraciju" })
public class RegistracioniServlet extends HttpServlet {		//registracioni servlet
	private static final long serialVersionUID = 1L;	//serialVersionUID - vazano za serijalizaciju, long - dupli int

     			//Default constructor
    public RegistracioniServlet() {
        
    }

	 			//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    			//request - je formirao tomcat
	 			//response - je formirao tomcat
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegistracijaDAO registracijaDAO = new RegistracijaDAO();
		
		System.out.println("Pozdrav iz servleta");

		String userName = request.getParameter("userName");		//userName uzet iz klase registracija name = "userName"
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");

		System.out.println("Vas username je " + userName);
		System.out.println("Vas password je " + password);
		System.out.println("Vas repeatPassword je " + repeatPassword);
		

		boolean provera = ValidacijaZaRegistraciju.proveraPasworda(password, repeatPassword);
										//prvo proverava da li je ponovljen dobro password
		if (provera) {
			boolean upisanUbazu = registracijaDAO.upisiUseraUbazu(userName, password);	//upisuje usera u bazu
			if(upisanUbazu) {
				response.sendRedirect("index.html");		//salje ga na index stranu
			}else {
				response.sendRedirect("registracija.html");		//salje ga na registracija stranu
			}
		}
		else {
			response.sendRedirect("registracija.html");		//salje ga nazad na registraciju ako nije dobro ponovio password
		}

		
		
		
	}
	
	
	 			//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Pozdrav iz servleta doPost");
	}

}
