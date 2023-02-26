package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {		
		public static void main(String[] args) {
			
			//create session factory
			SessionFactory factory = new Configuration()
					                 .configure("hibernate.cfg.xml")
					                 .addAnnotatedClass(Student.class)
					                 .buildSessionFactory();
			
			//get current session
			Session session = factory.getCurrentSession();		                 
			try {
				 
				
				System.out.println("Creating 3 student...");
				
				// create a student obj
				Student tempStudent1 = new Student("testf1", "lastN1", "test1@gamil");
				Student tempStudent2 = new Student("testf2", "lastN2", "test2@gamil");
				Student tempStudent3 = new Student("testf3", "lastN3", "test3@gamil");
				
				//start the transcat
				session.beginTransaction();
				
				//save the transc
				session.save(tempStudent1);
				session.save(tempStudent2);
				session.save(tempStudent3);
				System.out.println("Saving the session...");
				
				//commit the trans. 
				session.getTransaction().commit();
				System.out.println("Done..");
				
			}
			
			finally {
				factory.close();
			}	
				

	}

}
