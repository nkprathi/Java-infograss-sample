package com.springboot.user.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springboot.user.model.User;
import com.springboot.user.controller.UserHibernate;

@Component
public class UserDAO {
	
	/*private JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	static final String DB_URL = "jdbc:mysql://localhost:3306/userspringboot";
	static final String USER = "root";
	static final String PASS = "Prathi@!23";

	public boolean createUser(User u) {
		//jdbc concept in creating user
		Connection conn = null;
		   System.out.println("******* SQL demo");
	     
	    	  try {
	    		  try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println(" Connection established.");
				
				PreparedStatement stmt=conn.prepareStatement("insert into user_sb values(?,?,?)");  
				stmt.setInt(1,u.getUser_id());
				stmt.setString(2,u.getName());
				stmt.setString(3,u.getEmail_id());
				stmt.executeUpdate();
				/* ResultSet rs = */ 
		        //rs.next();
				//conn.commit();
				conn.close(); 
				System.out.println("records inserted.");  

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return false;		
	}
	public boolean updateUser(User u) {
		
		//hibernate concept in update user
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Updating user
		UserHibernate uh=new UserHibernate();
		uh.setUser_id(u.getUser_id());
		System.out.println("updateuser userid:" + uh.getUser_id());
		uh.setName(u.getName());
		uh.setUseremail(u.getEmail_id());
		
		Session s=factory.openSession();

		Transaction tx=s.beginTransaction();
		s.update(uh);
		//s.save(uh);
		tx.commit();
		s.close();
		 
		factory.close();
		return false;
	}
	
	public List<User> readUser(User u) {
		
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDAO1 userDao = (UserDAO1)context.getBean("userDao");
		
		List<User> userDetailList = userDao.getAllUserDetails();
		
		for(User index : userDetailList) {
			 System.out.print("ID: " + index.getUser_id());
	         System.out.print(", Name: " + index.getName() );
	         System.out.println(", Department: " + index.getEmail_id());
		}
		return userDetailList;
	}
}

	
	

