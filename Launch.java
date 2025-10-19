package com.tap;

import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(CustomerDetails.class);
		cfg.addAnnotatedClass(Orders.class);
		Session session = cfg.buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		//CRUD Operation 
//		Orders o1 = new Orders(501,"noodles",100);
//		Orders o2 = new Orders(502,"fried_rice",150);
//		Orders o3 = new Orders(503,"momos",80);
//		
//		Customer c=session.get(Customer.class, 1);
//		o1.setCustomer(c);
//		o2.setCustomer(c);
//		o3.setCustomer(c);
//		
//		session.save(o1);
//		session.save(o2);
//		session.save(o3);
		
		//steve (id=2) ordered veg_biryani and chicken_biryani
//		Orders o1 = new Orders(504,"veg_biryani",20);
//		Orders o2 = new Orders(505,"chicken_biryani",350);
//		
//		Customer c=session.get(Customer.class, 2);
//		o1.setCustomer(c);
//		o2.setCustomer(c);
//		
//		session.save(o1);
//		session.save(o2);
		
		// add a new customer ankit and add his order
//		Customer ankit = new Customer(3,"Ankit");
//		CustomerDetails cd = new CustomerDetails(103, "ankit@gmail.com", 68768045, "kolhapur");
//		ankit.setCid(cd);
//		
//		//here we created object of ankit but we don't put ankit data in table but also data will inserted in table
//		//this is because of @ManyToOne(cascade = CascadeType.ALL)-> when data inserted in order data will inserted in customer table
//		
//		Orders o1 = new Orders(506,"veg_manchuriyan",220);
//		Orders o2 = new Orders(507,"Gulab_jamun",50);
//		
////		Customer c=session.get(Customer.class, 2);//no need bcz now object is not present in table
//		o1.setCustomer(ankit);
//		o2.setCustomer(ankit);
//		
//		session.save(o1);
//		session.save(o2);
//		
		
		//get data form orders table
//		Orders o1 = session.get(Orders.class, 501);
//		System.out.println();
//		System.out.println(o1);
//		System.out.println("Customer :: "+o1.getCustomer());
//		System.out.println("Customer Details:: "+o1.getCustomer().getCid().toString());
		
		//get orders of customer 1 
//		Customer c=session.get(Customer.class, 1);
//		System.out.println(c);
//		List<Orders> orders = c.getOrders();
//		for(Object o:orders) {
//			System.out.println(o);
//		}
		
		//delete the tim data
//		Customer c = session.get(Customer.class, 1);
//		session.delete(c);
		
		//delete the order of veg_biryani(id = 504)
		Orders o1 = session.get(Orders.class, 504);
		session.delete(o1);
		System.out.println("veg biryani is deleted");
		
		t.commit();
	}

}




