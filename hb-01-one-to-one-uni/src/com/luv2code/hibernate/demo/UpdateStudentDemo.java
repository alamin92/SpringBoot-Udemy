package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//get current session
		Session session = factory.getCurrentSession();		                 
		try {
			
			
			int studentId = 1;
			// new code
			

			// created so use created session to start again
			session = factory.getCurrentSession();
			session.beginTransaction();

			//retrive student based on the id
			System.out.println("\ngetting student with the id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
			
            System.out.println("updating student: ");
            myStudent.setFirstName("scobby");

			//commit the trans. 
			session.getTransaction().commit();
			
			//new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update eamil for all students
			System.out.println("update email for all students");
			session.createQuery("update Student set email='testUpdate@gmail.com'").executeUpdate();
			
			//commit the trasnction
			session.getTransaction().commit();
			System.out.println("Done..");
			
		}
		
		finally {
			factory.close();
		}	
			
				
	}

}
