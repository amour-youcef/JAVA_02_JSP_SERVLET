package com.formation.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoFactory {

	private String url;
	private String username;
	private String password;
	
	private static DaoFactory instance = null;
	
	private DaoFactory(String url, String username, String password){
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			
		}

		if(instance == null){
			instance = new DaoFactory("jdbc:mysql://localhost:3306/test", "root", "");
		}

		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	public ClientDao getClientDao(){
		return new ClientDaoJdbc(this);
	}
	
	
}
