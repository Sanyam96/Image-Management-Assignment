package com.nagarro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public class HibernateUtilities {

    private static SessionFactory sessionFactory;

    public static Session getSessionInstance() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory.openSession();
    }

}
