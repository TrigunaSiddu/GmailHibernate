package com.ty.gmailWithHibernate.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.gmailWithHibernate.DTO.Account;
import com.ty.gmailWithHibernate.DTO.Inbox;

public class LoginIntoAnAccount {
	static Scanner scn=new Scanner(System.in);
	
	public void compose(String email) {
		
		System.out.println("Enter Message");
		String message=scn.next();
		Account account=new Account();
		Inbox box=new Inbox();
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory=Persistence.createEntityManagerFactory("gml");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			String findAll="from Account";
			Query query=manager.createQuery(findAll);
			List<Account> list=query.getResultList();
			for(Account emailId : list) {
				if(emailId.getEmail().equals(email)) {
					int id=account.getUser_id();
					box.setMessage(message);
					box.setAccount(emailId);
				}
			}
			
				
				transaction.begin();
				manager.persist(box);
				transaction.commit();
				
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
	
	
	public void showInbox(String email) {
		Account account=new Account();
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory=Persistence.createEntityManagerFactory("gml");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			int id=0;
			String findAll="from Account";
			
			Query query=manager.createQuery(findAll);
			List<Account> list=query.getResultList();
			for(Account emailId : list) {
				if(emailId.getEmail().equals(email)) {
					id=emailId.getUser_id();
				}
			}
			
			String find="from Inbox where User_id=:id";
			Query query2=manager.createQuery(find);
			query2.setParameter("id", id);
			List<Inbox> list2=query2.getResultList();
			System.out.println("******************************");
			for(Inbox in : list2) {
				
				System.out.println(in.getMessage());
				
			}
			System.out.println("******************************");
			
		
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
