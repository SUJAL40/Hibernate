package com.tap;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

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
				
				
		// ------------------ CRUD (Create) ------------------
				
		// Create Employee objects
		Employee raj = new Employee(1, "raj");
		Employee kumar = new Employee(2, "kumar");
			
		// Create Project objects
		Project googleDocx = new Project(1, "google_docx");
		Project googleSlides = new Project(2, "google_slides");
			
		// Create a list of projects and add both projects to it
		ArrayList<Project> al1 = new ArrayList<Project>();
		al1.add(googleDocx);
		al1.add(googleSlides);				
			
		// Assign same list of projects to both employees
		raj.setProjects(al1);
		kumar.setProjects(al1);
			
		// Save all objects (Hibernate will handle the mapping and join table)
		session.save(raj);
		session.save(kumar);
		session.save(googleDocx);
		session.save(googleSlides);		
			
			
		// Commit the transaction (final save to DB)
		t.commit();
	
	}

}
