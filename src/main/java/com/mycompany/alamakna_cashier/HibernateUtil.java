package com.mycompany.alamakna_cashier;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            
            // Registrasi class Admin secara eksplisit ke Hibernate 6
            config.addAnnotatedClass(Admin.class);
            
            sessionFactory = config.buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Gagal membuat SessionFactory Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}