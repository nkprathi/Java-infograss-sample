package com.springboot.user.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;

import com.springboot.user.model.User;

public class UserDAO1impl {//implements UserDAO1{
	private DataSource dataSource;
	//private JdbcTemplate template;
	
//	public JdbcTemplate getTemplate() {
//		return template;
//	}
//
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}
//	public List<User> getAllUserDetails() {
//		
//		return template.query("select * from user_sb;", new RowMapper<User>() {
//
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//				User user = new User();
//				user.setUser_id(rs.getInt(1));
//				user.setName(rs.getString(2));
//				user.setEmail_id(rs.getString(3));
//
//				return user;
//				}
//			}
//		);
//	}
//
//	@Override
//	public void setDataSource(DataSource ds) {
//		// TODO Auto-generated method stub
//		this.dataSource = dataSource;
//	    this.template = new JdbcTemplate(dataSource);
//	}
}
