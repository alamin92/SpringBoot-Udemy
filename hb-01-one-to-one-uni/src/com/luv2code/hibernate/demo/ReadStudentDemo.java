package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//get current session
		Session session = factory.getCurrentSession();		                 
		try {
			
			
			System.out.println("Creating the new the student...");
			
			// create a student obj
			Student tempStudent = new Student("testRe", "lastReN", "TestRed@gamil");
			
			//start the transcat
			session.beginTransaction();
			
			//save the transc
			session.save(tempStudent);
			System.out.println("Saving the session...");
			System.out.println(tempStudent);
			
			session.getTransaction().commit();
			
			// new code
			
			//find out the students id use: primary key
			System.out.println("Saved student iD. Generate id: " + tempStudent.getId());
			
			//now get a new session and start translation
			//mistake here: session obj is already is 
			// created so use created session to start again
			session = factory.getCurrentSession();
			session.beginTransaction();

			//retrive student based on the id
			System.out.println("\ngetting student with the id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
			
            System.out.println("Get complete: " + myStudent);

			//commit the trans. 
			session.getTransaction().commit();
			System.out.println("Done..");
			
		}
		
		finally {
			factory.close();
		}	
			
				
	}

}
