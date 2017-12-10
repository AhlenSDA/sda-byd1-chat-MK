package com.sda.chat.hibernate.dao;

import com.sda.chat.hibernate.model.Messages;
import com.sda.chat.hibernate.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class MessagesDAO {

    private Session session = HibernateUtility.getHibernateSession();

    public void createMessage(Messages msg) {
        try {
            session.beginTransaction();
            session.save(msg);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Messages readMessage(int id) {
        Messages result = null;

        try {
            session.beginTransaction();
            result = session.get(Messages.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public void updateMessage(Messages msg) {
        try {
            session.beginTransaction();
            session.update(msg);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteMessage(Messages msg) {
        try {
            session.beginTransaction();
            session.remove(msg);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Messages> getMessagesList() {
        List<Messages> tweets = null;

        try {
            session.beginTransaction();
            tweets = session.createQuery("FROM Messages").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }

        return tweets;
    }
}