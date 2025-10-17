package com.tap;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(CustomerDetails.class);
		Session session = cfg.buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		//add the data in customer table
//		Customer c = new Customer(2, "sujal");
//		CustomerDetails cd = new CustomerDetails(102, "sk@gmail.com", 862045789, "Pune");
//		c.setCid(cd);
//		session.save(c);
		//we not need to session.save(cd) bcz of mapping customer_dtls data will inserted automatically
		
		// get customer details
//		Customer c = session.get(Customer.class, 1);
//		System.out.println(c);
//		CustomerDetails cd = c.getCid();
//		System.out.println(cd);
		
		
		//using customer_dtl fetch customer data
		CustomerDetails cd= session.get(CustomerDetails.class,101);
		Customer c = cd.getCustomer();
		System.out.println(c + " "+cd);
		
		t.commit();
	}

}
