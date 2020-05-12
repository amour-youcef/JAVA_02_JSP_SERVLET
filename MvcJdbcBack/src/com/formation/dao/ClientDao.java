package com.formation.dao;

import java.util.List;

import com.formation.entity.Client;

public interface ClientDao {
	
	public void ajouter(Client client);
	public List<Client> getAll();
	public void update (Client client);
	public void delete (Client client);
	public void getById (Client client);
}
