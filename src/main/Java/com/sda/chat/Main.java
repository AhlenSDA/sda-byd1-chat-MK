package com.sda.chat;

import com.sda.chat.hibernate.model.Messages;
import com.sda.chat.hibernate.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Users user1 = new Users();
        user1.setNick("Marcin");
        user1.setPassword("4444");
        user1.setId(1);

        Messages message1 = new Messages();
        message1.setUser_id(1);
        message1.setMessage("bbbbbbbbbbbbbbbbb");

        Messages message2 = new Messages();
        message2.setUser_id(1);
        message2.setMessage("cccccccccccc");

        user1.getMessagesList().add(message1);
        user1.getMessagesList().add(message2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user1);

        session.getTransaction().commit();
        session.close();

    }
}
