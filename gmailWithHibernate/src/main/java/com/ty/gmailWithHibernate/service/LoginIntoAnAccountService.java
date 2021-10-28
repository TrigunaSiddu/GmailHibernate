package com.ty.gmailWithHibernate.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.gmailWithHibernate.DAO.LoginIntoAnAccount;
import com.ty.gmailWithHibernate.DTO.Account;

public class LoginIntoAnAccountService {
	static Scanner scn=new Scanner(System.in);
	static LoginIntoAnAccount account=new LoginIntoAnAccount();
	public void login() {
		System.out.println("Enter email_id");
		
		String email=scn.next();
		
		System.out.println("Press A To Compose");
		System.out.println("Press B To Show Inbox");
		
		char ch=scn.next().charAt(0);
		
		if(ch=='A' || ch=='a') {
			compose(email);
			
		}
		else if(ch=='B' || ch=='b') {
			showInbox(email);
		}
		else {
			System.out.println("Enter valid input");
			
		}
		
		
	}
	
	
		public void compose(String email) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		int count=0;
		try {
			factory=Persistence.createEntityManagerFactory("gml");
			manager=factory.createEntityManager();
			String findAll="from Account";
			Query query=manager.createQuery(findAll);
			List<Account> list=query.getResultList();
			for(Account emailId : list) {
				if(emailId.getEmail().equals(email)) {
					account.compose(email);
				}
			}
			if(count<=0) {
				System.out.println("enter valid email Id");
			}
			
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		public void showInbox(String email) {
			EntityManagerFactory factory=null;
			EntityManager manager=null;
			int count=0;
			try {
				factory=Persistence.createEntityManagerFactory("gml");
				manager=factory.createEntityManager();
				String findAll="from Account";
				Query query=manager.createQuery(findAll);
				List<Account> list=query.getResultList();
				for(Account emailId : list) {
					if(emailId.getEmail().equals(email)) {
						count++;
						account.showInbox(email);
					}
					if(count<=0) {
						
							System.out.println("enter valid email Id");
					}
					
				}
				
						
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}


