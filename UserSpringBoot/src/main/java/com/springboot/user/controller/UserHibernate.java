package com.springboot.user.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "ForeignKeyAssUserHibernate")
@Table(name = "user_sb", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "User_ID"),
	    @UniqueConstraint(columnNames = "email_id")})
public class UserHibernate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID", unique = true, nullable = false)
	private Integer user_id;
	
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String name;
	
	@Column(name = "email_id", unique = false, nullable = false, length = 100)
	private String useremail;
	
	

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
