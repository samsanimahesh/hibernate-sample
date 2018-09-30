package com.mahesh.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mahesh.hibernate.UserWithVehicle;
import com.mahesh.hibernate.Vehicle;

public class HibernateOneToOneTest {
	public static void main(String[] args) {
		UserWithVehicle userWithVehicle = new UserWithVehicle();
		userWithVehicle.setUserName("mahesh");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("mybike");
		
		Vehicle car = new Vehicle();
		car.setVehicleName("mycar");
		
//		vehicle.getUserWithVehicle().add(userWithVehicle);
//		car.getUserWithVehicle().add(userWithVehicle);
		
		userWithVehicle.getVehicle().add(vehicle);
		userWithVehicle.getVehicle().add(car);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(userWithVehicle);
		transaction.commit();
		session.close();
	}

}
