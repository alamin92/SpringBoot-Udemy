package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
            // delete the studnt
//            System.out.println("deleting the student" + myStudent);
//            session.delete(myStudent);
          
      //delte with id 2 with alternate
            System.out.println("deleting student with id 2");
            session.createQuery("delete from Student where id=2").executeUpdate();
			//commit the trans. 
			session.getTransaction().commit();
			
			//new code
			
			System.out.println("Done..");
			
		}
		
		finally {
			factory.close();
		}	
			
				
	}

}
