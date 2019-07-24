package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class LoginDAO {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public boolean daLiPostojiUserUbazi(String userName) { 
														//dali postoji user koji se trazi
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String upit = "FROM User WHERE userName = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", userName);
			
			List<User> listaUsera = query.getResultList();
				
				if(listaUsera.isEmpty()) {
					session.getTransaction().commit();
					System.out.println("Ne postoji taj user");		//ako ne postoji
					return false;
				}else {
					session.getTransaction().commit();
					System.out.println("Dobar je user name");		//ako postoji
					return true;
				}
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nije dobar user name");
			return false;
		}finally {
			session.close();
		}
	}
		
	public boolean daLiPasswordOdgovaraUseru(String userName, String password) {
														//da li odgovara password useru
		Session session = sf.openSession();
		session.beginTransaction();
		boolean vrati = false;
		
		try {
			String upit = "FROM User WHERE userName = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", userName);
			
			List<User> listaUsera = query.getResultList();		//uzimamo listu usera sa tim imenom
			
			for(User userIzBaze: listaUsera) {
				
				if(userIzBaze.getPassword().equals(password)) {		//ako pasword odgovara vrati true
					System.out.println("Pustaj!!!");
					session.getTransaction().commit();
					vrati = true;
				}else {												//ako pasword neodgovara vrati false
					System.out.println("NEEEEEEEEEEEE!!!");
					session.getTransaction().commit();
					vrati = false;
				}
			}
			return vrati;		
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	public User vratiUsera(String userName) {		//vrati usera sa tim userName
		
		User user = new User();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String upit = "FROM User WHERE userName = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", userName);
			
			List<User> listaUsera = query.getResultList();		//vraca listu usera sa tim podacima
			
			user = listaUsera.get(0);
			
			return user;		
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	public User vratiUseraPoId(long idUser) {		//vrati usera sa tim userName

			User user = null;

			Session session = sf.openSession();
			session.beginTransaction();

			try {

				user = (User) session.get(User.class, idUser);

				session.getTransaction().commit();
				return user;		
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
			}finally {
				session.close();
			}
	
		}
	
	
}
