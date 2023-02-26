package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Instructor.class)
				                 .buildSessionFactory();
		
		//get current session
		Session session = factory.getCurrentSession();		                 
		try {
			
			
			System.out.println("Creating instructor and instructor details ...");
			
			// create a instructor and instructordetailsj
//			Instructor tempInstructor = new Instructor("alamain", "hossain", "alamin@gamil");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("alamin@youtibe", "hiking");
			
			Instructor tempInstructor = new Instructor("rabi", "askt", "rabi@gamil");
			InstructorDetail tempInstructorDetail = new InstructorDetail("rabi_youtibe", "jumpimg");
				
			//associate the obj
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start the transcat
			session.beginTransaction();
			
			//save the instructor
			//note: this will save the details objcet becasie of cascasdeall
			session.save(tempInstructor);
			
			//commit the trans. 
			session.getTransaction().commit();
			System.out.println("Done..");
			
		}
		
		finally {
			factory.close();
		}	
			
				
	}

}
