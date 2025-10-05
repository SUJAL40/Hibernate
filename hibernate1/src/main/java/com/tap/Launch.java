package com.tap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure(); // reads hibernate.cfg.xml
        cfg.addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();  // ✅ start transaction first

        Employee e = new Employee(1, "tim", 20000, "tim@gmail.com");
        session.save(e);

        t.commit(); // ✅ commit after saving
        session.close();
        sessionFactory.close();

        System.out.println("✅ Employee saved successfully!");
    }
}
