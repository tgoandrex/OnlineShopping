package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateTest {
	
	private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	public static Session getHibernateSession() {
		if(sessionFactory == null) {
			System.out.println("Building session factory");
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch(Exception e) {
				System.out.println("Could not build session factory from hibernate.cfg.xml properties");
				e.printStackTrace();
			}
		}
		if (session == null || !session.isOpen()) {
			System.out.println("Opening session");
			session = sessionFactory.openSession();
		}
		return session;
	}
}
