package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//get current session
		Session session = factory.getCurrentSession();		                 
		try {
			
			
			session.beginTransaction();
		    
			//query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			//query students using last name
			theStudents = session.createQuery("from Student s where s.lastName = 'lastN1'").list();
			
             //display students
			System.out.println("\n\n Students who have last name lastN1");
			displayStudents(theStudents);
			
			//query students: lastName="doe" or firstName='dffy'
			theStudents = session.createQuery("from Student s where "
					+ " s.lastName='lastN1' OR s.firstName='testf'").list();

			System.out.println("\n\n Students who have last name lastN1 or first something");
			displayStudents(theStudents);
			//commit the trans. 
			session.getTransaction().commit();
			System.out.println("Done..");
			
		}
		
		finally {
			factory.close();
		}	
			
				
	}

	private static void displayStudents(List<Student> theStudents) {
		//display students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
