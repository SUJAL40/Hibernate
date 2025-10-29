package com.tap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// Create Hibernate Configuration object
		Configuration cfg = new Configuration();
				
		// Load configuration details from hibernate.cfg.xml file
		cfg.configure();
				
		// Tell Hibernate about the entity classes
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Project.class);
			
		// Build SessionFactory and open a new session (connection to DB)
		Session session = cfg.buildSessionFactory().openSession();
				
		// Begin a new transaction (so all DB actions are done safely)
		Transaction t = session.beginTransaction();
		
		System.out.println();
				
		// ------------------ CRUD (Create) Lecture 8 ------------------
				
		// Create Employee objects
//		Employee raj = new Employee(1, "raj");
//		Employee kumar = new Employee(2, "kumar");
//			
//		// Create Project objects
//		Project googleDocx = new Project(1, "google_docx");
//		Project googleSlides = new Project(2, "google_slides");
//			
//		// Create a list of projects and add both projects to it
//		ArrayList<Project> al1 = new ArrayList<Project>();
//		al1.add(googleDocx);
//		al1.add(googleSlides);				
//			
//		// Assign same list of projects to both employees
//		raj.setProjects(al1);
//		kumar.setProjects(al1);
//			
//		// Save all objects (Hibernate will handle the mapping and join table)
//		session.save(raj);
//		session.save(kumar);
//		session.save(googleDocx);
//		session.save(googleSlides);		
//			
			
		//lecture 9
		
		//CRUD Operation get details of employee ->project
//		Employee raj = session.get(Employee.class, 1);
//		System.out.println(raj);
//		List<Project> projects = raj.getProjects();
//		//Iterator is cursor like function (cursor based logic)
//		Iterator<Project> itr = projects.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		//get which project works on which emp
//		Project googleSlides = session.get(Project.class, 2);
//		List<Employee> emp = googleSlides.getEmployees();
//		ListIterator<Employee> litr = emp.listIterator();
//		while(litr.hasNext()) {
//			System.out.println(litr.next());
//		}
//		
		
		//if we want the emp in reverse direction
//		ListIterator<Employee> litrRev = emp.listIterator(emp.size());
//		while(litrRev.hasPrevious()) {
//			System.out.println(litrRev.previous());
//		}
	
		//delete the employee data -> raj
//		Employee raj = session.get(Employee.class, 1);
//		session.delete(raj);
		
		//delete googleSlides project form project table
//		Project googleSlides = session.get(Project.class, 2);
//		session.delete(googleSlides);
		
		Employee e = session.get(Employee.class, 2);
		System.out.println(e);
		
		
		
		
		
		
		// Commit the transaction (final save to DB)
		t.commit();
	
	}

}
