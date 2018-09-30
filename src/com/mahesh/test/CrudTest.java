package com.mahesh.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mahesh.hibernate.UserDeta;

public class CrudTest {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		if(transaction.isActive()){
			System.out.println("transaction is already active");
			transaction.rollback();
		}
		transaction.begin();
		
		for(int i=0;i<10;i++){
			UserDeta userData = new UserDeta();
			userData.setUserName("User "+i);
			session.save(userData);
		}
		
		Query query = session.createQuery("from UserDeta");
		
		
		Criteria criteria = session.createCriteria(UserDeta.class);
		criteria.add(Restrictions.eq("p", "usr 10"));
		
		List<UserDeta> list = (List<UserDeta>)query.list();
		System.out.println(list.size());
		
		session.getTransaction().commit();
		session.close();
	}

}
