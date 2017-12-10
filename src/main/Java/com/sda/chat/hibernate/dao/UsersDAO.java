package com.sda.chat.hibernate.dao;

import com.sda.chat.hibernate.model.Users;
import com.sda.chat.hibernate.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UsersDAO {

    private Session session = HibernateUtility.getHibernateSession();

    public Users getUser(int id) {
        Users result = null;

        try {
            session.beginTransaction();
            result = session.get(Users.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return result;
    }
}

