package com.formation.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DaoFactory {

	private String url;
	private String username;
	private String password;
	
	private static DaoFactory instance = null ;

	public DaoFactory(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public static DaoFactory getInstance() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {}
			// TODO: handle exception
			
			if(instance == null ) {
				instance = new DaoFactory("jdbc:mysql://localhost:3306/test", "root", "");
			}
		
		return instance;
	}
	
	
	
	public Connection getConnection() throws SQLException {
	
		return null;
		
	}
}
