package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.Artikal;
import model.Racun;
import model.User;
import validacija.UserValidacija;

@WebServlet(description = "servlet za placanje racuna", urlPatterns = { "/PlatiRacunServlet" })
public class PlatiRacunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserValidacija uv = new UserValidacija();
		UserDAO ud = new UserDAO();

		String [] check = request.getParameterValues("check");				//pravi niz checkova
		String[] kolicina = request.getParameterValues("kolicina");			//pravi niz kolicina

		List<String> listaKolicina = uv.urediKolicinu(kolicina);			//pravi listaKolicina
		List<Artikal> listaArtikala = ud.artikliSaRacuna(check);			//pravi listaArtikala

		double totalPrice = ud.iznosRacuna(listaArtikala, listaKolicina);

		HttpSession session = request.getSession();						//zove sesiju iz LoginServlet!
		User user = (User)session.getAttribute("ovdeJeUserObjekat");	//ovo uzima iz sesije - LoginServlet!
		Date date = new Date();
		Racun racun = ud.sacuvajRacun(user, date, listaArtikala);

		request.setAttribute("totalPrice", totalPrice);					//setuje totalPrice da bi ga prosledio kroz request!
		request.setAttribute("listaArtikala", listaArtikala);
		request.setAttribute("listaKolicina", listaKolicina);

		if(user.getNovcanik()>=totalPrice) {

			ud.apdejtujNovcanik(user, totalPrice);
			ud.apdejtujStanje(listaArtikala, listaKolicina);
			RequestDispatcher rd = request.getRequestDispatcher("view/racun.jsp");
			rd.forward(request, response);								//prosledjuje request i response
		}else {
			response.sendRedirect("view/user.jsp");
		}

		
	}

}
