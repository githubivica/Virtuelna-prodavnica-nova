package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Artikal;
import model.Racun;
import model.User;

public class UserDAO {

	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public static List<Artikal> vratiSveArtikle(){				//metoda vrati artikle

		List<Artikal> listaArtikala = null;

		Session session = sf.openSession();
		session.beginTransaction();
			try {
				String upit = "FROM Artikal";				//vrati sve artikle u listi artikala
				Query query = session.createQuery(upit);
					listaArtikala = query.getResultList();
				session.getTransaction().commit();
				return listaArtikala;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
		}finally {
			session.close();
		}
	}
	
	public List<Artikal> artikliSaRacuna(String[]check){		//artikli sa racuna

		List<Artikal> listaArtikala = new ArrayList<Artikal>();

		Session session = sf.openSession();
		session.beginTransaction();
			try {
				for(int i = 0; i<check.length;i++) {
					Artikal artikal = new Artikal();
					long id = Long.parseLong(check[i]);				//uzima id od check[i]!
					artikal = session.get(Artikal.class,id);	//uzima vrednost od check[i]
					listaArtikala.add(artikal);
				}
				session.getTransaction().commit();
				return listaArtikala;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return listaArtikala;								//ovde vraca listaArtikala ako je Exception!
		}finally {
			session.close();
		}

	}

	public Racun sacuvajRacun(User user, Date date, List<Artikal>listaArtikala) {
																//sacuvaj Racun
		Racun racun = new Racun();
		racun.setUser(user);								//setuje user, date i listaArtikala
		racun.setDate(date);
		racun.setListaArtikala(listaArtikala);
		Session session = sf.openSession();
		session.beginTransaction();
			try {

				session.save(racun);
				session.getTransaction().commit();
				return racun;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
		}finally {
			session.close();
		}
	}

	public double iznosRacuna(List<Artikal>listaArtikala, List<String> listaKolicina) {
																	//iznos racuna
		double rez = 0.0;
		
			for(int i = 0; i<listaArtikala.size(); i++) {
				rez = rez + listaArtikala.get(i).getCena() * Integer.parseInt(listaKolicina.get(i)) * (100-listaArtikala.get(i).getPopust()) / 100;
			}
			return rez;
	}

	public void apdejtujNovcanik(User user, double totalPrice) {		//update novcanik
															
		user.setNovcanik(user.getNovcanik() - totalPrice);				//setuje  Novcanik

		Session session = sf.openSession();
		session.beginTransaction();
			try {
				session.update(user);
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}


	public void apdejtujStanje(List<Artikal> listaArtikala, List<String> listaKolicina) {
																		//update stanje
		Artikal artikal;
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				for(int i = 0; i<listaArtikala.size(); i++) {
					artikal = listaArtikala.get(i);						//uzima artikal
					artikal.setStanje(artikal.getStanje() - Integer.parseInt(listaKolicina.get(i)));
					session.update(artikal);
				}

				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	
	
	
}
