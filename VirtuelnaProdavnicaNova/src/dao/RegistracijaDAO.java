package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Rola;
import model.User;
import validacija.ValidacijaZaRegistraciju;

public class RegistracijaDAO {			//ovde se registruje  korisnik

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public SessionFactory getSf() {		//getsf
		return sf;
	}

	public void setSf(SessionFactory sf) {		//setsf
		this.sf = sf;
	}
										//upisuje usera u bazu
	public boolean upisiUseraUbazu(String userName, String password) {

		User user = new User();
			user.setUserName(userName);		//upisuje ime
			user.setPassword(password);		//upisuje password
			
			Rola rola;
			
			if(ValidacijaZaRegistraciju.daLiJeAdmin(userName, password)) {
				rola = Rola.GAZDA;		//ako je admin onda je administrator
			}
			else {
				rola = Rola.MUSTERIJA;			//ako nije admin onda je korisnik
			}
		
			user.setRola(rola);
			
		Session session = sf.openSession();
			session.beginTransaction();

			try {
				session.save(user);					//snima usera u sessiju
				session.getTransaction().commit();
				System.out.println("Uspesno je ubacen user");
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Nije ubacen user");
				return false;
			}finally {
				session.close();
			}

	}


	
	
}
