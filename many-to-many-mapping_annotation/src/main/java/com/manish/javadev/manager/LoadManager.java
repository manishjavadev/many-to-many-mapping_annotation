package com.manish.javadev.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manish.javadev.model.CustomerEntity;
import com.manish.javadev.util.HibernateUtil;

public class LoadManager {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		CustomerEntity customerEntity = (CustomerEntity) session.get(
				CustomerEntity.class, new Long(1));
		System.out.println(customerEntity);
		System.out.println("================");
		System.out.println(customerEntity.getAccountEntity());

		tx.commit();
		session.close();
		System.out.println("Done");
	}
}
