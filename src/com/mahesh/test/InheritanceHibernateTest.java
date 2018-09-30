package com.mahesh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mahesh.hibernate.FourWheeler;
import com.mahesh.hibernate.TwoWheeler;
import com.mahesh.hibernate.Vehicle;

public class InheritanceHibernateTest {
	
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("mybike");
		bike.setStreeringHandle("steeringhandle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("mycar");
		car.setSteeringWheel("steeringwheel");
		
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(tx.isActive()){
			tx.rollback();
		}
		tx.begin();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		tx.commit();
		session.disconnect();
		session.close();
		
	}

}
