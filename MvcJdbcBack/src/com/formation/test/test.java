package com.formation.test;

import java.util.List;

import com.formation.dao.ClientDaoJdbc;
import com.formation.dao.DaoFactory;
import com.formation.entity.Client;

public class test {

	public static void main(String[] args) {
		
		DaoFactory da = DaoFactory.getInstance();
		
		ClientDaoJdbc dao = new ClientDaoJdbc(da) ;	
		
//		List<Employee> employees=	dao.getEmployee();
//		
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}
			
		List<Client> clients = dao.getAll();
	
		
		for (Client client : clients) {
			
			System.out.println(client);
		}
		
		System.out.println("ok");
		
		
}
}