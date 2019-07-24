package dao;
import java.util.List;
import javax.persistence.Index;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.Artikal;
import model.Rola;
import model.User;
import dao.LoginDAO;
public class AdminDAO {
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static List<User> vratiSveUsere(){			//vraca sve usere
		
		List<User> listaUsera = null;
		
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				String upit = "FROM User";				//vraca sve iz usera
				Query query = session.createQuery(upit);
					listaUsera = query.getResultList();
				session.getTransaction().commit();
				return listaUsera;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
		}finally {
			session.close();
		}
			
	}
	
	public static boolean dodajUnovcanik(User user, String balance) {
		double uplata = Double.parseDouble(balance);
		double staroStanjeUnovcaniku = user.getNovcanik();
		double konacno = uplata + staroStanjeUnovcaniku;
		if(user.getRola().equals(Rola.GAZDA)) {	//ako je administrator da ne moze sebi da poveca balance
			user.setNovcanik(0);
		}else { 
			user.setNovcanik(konacno);		//ako nije administrator podesava konacno stanje
		}
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				session.update(user);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return false;
		}finally {
			session.close();
		}
	}
	public static boolean ubaciArtikalUBazu(String imeArtikla, String cena, String stanje , String popust){
		Artikal artikal = new Artikal();
			artikal.setImeArtikla(imeArtikla);					//ubacije ime artikla
				double cenaArtikla = Double.parseDouble(cena);
			artikal.setCena(cenaArtikla);						//ubacije cenu artikla
				int stanjeUMagacinu = Integer.parseInt(stanje);
			artikal.setStanje(stanjeUMagacinu);					//ubacije stanje artikla
			if(popust.isEmpty()) {							//ako nije podesen popust onda je 0
				artikal.setPopust(0);				
			}else {
				double popustNaArtikal  = Double.parseDouble(popust);
				artikal.setPopust(popustNaArtikal);			//ako stavimo popust onda se setuje
			}
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				session.save(artikal);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return false;
		}finally {
			session.close();
		}
	}	
	
	public static boolean obrisiUsera(String userName) {		//brise usera
		
		LoginDAO loginDAO = new LoginDAO();
		User user = new User();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			
			boolean proveriUsera = loginDAO.daLiPostojiUserUbazi(userName);		//da li postoji user u bazi
			if(proveriUsera) {	
			
					String upit = "FROM User WHERE userName = :korisnickoIme";
					Query query = session.createQuery(upit);
					query.setParameter("korisnickoIme", userName);
		
					List<User> userKojiSeBrise = query.getResultList();		//uzimamo listu usera sa tim imenom
					user = userKojiSeBrise.get(0);
					
					session.delete(user);			//ovde treba da ga brise
					session.getTransaction().commit();
					
					return true;
			}else {											//ako ne postiji user vrati ga na login stranu		
				System.out.println("Ne postoji taj userName");		//ako ne postoji
				return false;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}					
	}

	public static boolean izmeniUsera(User user) {

		Session session = sf.openSession();
		session.beginTransaction();
			try {
				session.update(user);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return false;
		}finally {
			session.close();
		}
	}
	
	
}