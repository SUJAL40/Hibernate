package com.example;

import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        User u = new User("Sujal", "sujal@example.com");
        session.persist(u);
        session.getTransaction().commit();

        User fetched = session.get(User.class, u.getId());
        System.out.println("Fetched: " + fetched.getName() + " - " + fetched.getEmail());

        session.close();
        factory.close();
    }
}
