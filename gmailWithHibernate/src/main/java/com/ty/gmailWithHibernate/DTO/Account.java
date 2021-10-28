package com.ty.gmailWithHibernate.DTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int User_id;
	private String User_name;
	private String Password;
	private String Email;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
	private List<Inbox> inbox;
	
	

}
