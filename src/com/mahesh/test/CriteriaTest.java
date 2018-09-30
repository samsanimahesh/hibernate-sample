package com.mahesh.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mahesh.hibernate.UserDeta;

public class CriteriaTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(int i=0;i<10;i++){
			UserDeta userData = new UserDeta();
			userData.setUserName("User "+i);
			session.save(userData);
		}
		
		Criteria criteria = session.createCriteria(UserDeta.class);
//		criteria.add((Restrictions.eq("userId", 1)));
		criteria.setProjection(Projections.property("userId"));
		List<Integer> listOfUserDeta = criteria.list();
		for(Integer userDeta : listOfUserDeta){
			System.out.println(userDeta);
//			System.out.println(userDeta.getUserName());
		}
		session.getTransaction().commit();
		session.close();
	}

}
