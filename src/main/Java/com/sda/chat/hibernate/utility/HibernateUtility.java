package com.sda.chat.hibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private final static SessionFactory SESSION_FACTORY = new Configuration()
            .buildSessionFactory();

    private static Session session = SESSION_FACTORY.openSession();

    private HibernateUtility() {
    }

    public static Session getHibernateSession() {
        if (session == null) {
            session = (Session) new HibernateUtility();
        }
        return session;
    }
}