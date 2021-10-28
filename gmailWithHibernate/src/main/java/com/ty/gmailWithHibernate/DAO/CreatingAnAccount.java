package com.ty.gmailWithHibernate.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.gmailWithHibernate.DTO.Account;

public class CreatingAnAccount {
	static Scanner scn=new Scanner(System.in);
	public void createAccount() {
		System.out.println("Enter username");
		String user_name=scn.next();
		System.out.println("Enter password");
		String password=scn.next();
		System.out.println("Enter email");
		String email=scn.next();
		Account account=new Account();
		account.setUser_name(user_name);
		account.setPassword(password);
		account.setEmail(email);
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory=Persistence.createEntityManagerFactory("gml");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			manager.persist(account);
			transaction.commit();
			System.out.println("Account Created successfully");
			
		}
		catch(Exception e1) {
			e1.printStackTrace();
			if(transaction!=null)
				transaction.rollback();
		}
		finally {
			if(factory!=null)
				factory.close();
			if(manager!=null)
				manager.close();
			
		}
	}
	

}
