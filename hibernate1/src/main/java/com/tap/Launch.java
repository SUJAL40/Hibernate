package com.tap;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Launch {

    private static final String Employee = null;

	public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure(); // reads hibernate.cfg.xml
        cfg.addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();  // ✅ start transaction first
        
        //here we added new Employee details 
//        Employee e = new Employee(4, "omi", 25000, "omi@gmail.com");
//        session.save(e);
        
        // here we get the data from database
        //Employee e = session.get(Employee.class, 2);
        //System.out.println(e);
        
        
        //here we update data of database
        //Employee e = session.get(Employee.class, 1);
        //e.setSalary(30000);
        //session.update(e);
        
        //delete row from database
//        Employee e = session.get(Employee.class, 1);
//        session.delete(e);
        
        //get batch data/get bunch of data
//        Query query = session.createQuery("from Employee e");
//        List list = query.getResultList();
//        for(Object o:list) {
//        	System.out.println(o);
//        }
        
        //update the batch data
//        Query query = session.createQuery("update Employee e SET e.salary = e.salary + 5000 where e.salary > 30000");
//        int UpdateRow = query.executeUpdate();
//        System.out.println(UpdateRow);
        
        
        //delete data
        Query query = session.createQuery("delete from Employee e where e.name='ven'");
        int n = query.executeUpdate();
        System.out.println("no. of row update : "+n);
        
        //commit bcz auto-commit by default in hibernate her we forcefully committed
        t.commit(); // ✅ commit after saving
        session.close();
        sessionFactory.close();

//        System.out.println("✅ Employee saved successfully!");
//        System.out.println("Row is deleted ");
    }
}
