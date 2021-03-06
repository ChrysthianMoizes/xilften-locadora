package dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            
            sessionFactory = new AnnotationConfiguration().configure("dao/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
