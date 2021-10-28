package com.ty.gmailWithHibernate.main;

import java.util.Scanner;

import com.ty.gmailWithHibernate.DAO.CreatingAnAccount;
import com.ty.gmailWithHibernate.DAO.LoginIntoAnAccount;
import com.ty.gmailWithHibernate.service.LoginIntoAnAccountService;

public class MainForGmailLogin {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(" Press 1 To Login");
		System.out.println(" Press 2 To Register");
		int input=scn.nextInt();
		
		switch (input) {
		case 1:
			LoginIntoAnAccountService service=new LoginIntoAnAccountService();
			service.login();
			break;
			

		case 2:{
			CreatingAnAccount account=new CreatingAnAccount();
			account.createAccount();
		}
			break;
		}
	}


}
