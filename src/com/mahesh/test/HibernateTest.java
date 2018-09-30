package com.mahesh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mahesh.hibernate.Address;
import com.mahesh.hibernate.SetOfAddresses;

public class HibernateTest {
	public static void main(String[] args) {
		
		SetOfAddresses setOfAddresses = new SetOfAddresses();
		Address address = new Address();
		
		address.setCity("amalapuram");
		address.setState("AP");
		address.setStreet("amp");
		address.setPincode("533201");
			
		Address officeAddress = new Address();
		
		officeAddress.setCity("amalapuram");
		officeAddress.setState("AP");
		officeAddress.setStreet("amp");
		officeAddress.setPincode("533201");
		
		setOfAddresses.setId(1);
		setOfAddresses.setName("mahesh");
		setOfAddresses.getSetOfAddresses().add(address);
		setOfAddresses.getSetOfAddresses().add(officeAddress);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if(transaction.isActive()){
			transaction.commit();
		}
		transaction.begin();
		session.save(setOfAddresses);
		transaction.commit();
		session.close();	
//		if(transaction.isActive()){
//		transaction.rollback();
//	}
//		userDetails = null;
//		transaction.begin();
//		userDetails = (UserDetails)session.get(UserDetails.class, 1);
//		System.out.println(userDetails.getUserName());
//		transaction.commit();
//		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		SetOfAddresses addresses = (SetOfAddresses)session.get(SetOfAddresses.class, 1);
		System.out.println(addresses.getName());
		transaction.commit();
		session.close();
		System.out.println(addresses.getSetOfAddresses().size());
//		
	}

}
