package com.manish.javadev.manager;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manish.javadev.model.CustomerEntity;
import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.util.HibernateUtil;

public class InsertManager {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Create OrderEntity
		AccountEntity accountEntity1 = new AccountEntity("Joint Account",
				new Date());

		// Create OrderEntity
		AccountEntity accountEntity2 = new AccountEntity("Personal Account",
				new Date());

		// Create CustomerEntity
		CustomerEntity customerEntity1 = new CustomerEntity("Manish",
				"Srivastava", 30);
		// Create CustomerEntity
		CustomerEntity customerEntity2 = new CustomerEntity("Dviya",
				"Srivastava", 30);

		customerEntity1.getAccountEntity().add(accountEntity1);
		customerEntity2.getAccountEntity().add(accountEntity1);
		
		customerEntity2.getAccountEntity().add(accountEntity2);

		session.save(customerEntity1);
		session.save(customerEntity2);

		tx.commit();
		session.close();
		System.out.println("Done");
	}
}
