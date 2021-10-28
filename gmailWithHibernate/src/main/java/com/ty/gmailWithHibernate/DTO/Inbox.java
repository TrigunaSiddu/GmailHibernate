package com.ty.gmailWithHibernate.DTO;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;
@Data
@Entity
public class Inbox implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Message_id;
	private String Message;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_id")
	private Account account;
	
	
	

	
}
