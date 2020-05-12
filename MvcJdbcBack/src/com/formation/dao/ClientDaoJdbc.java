package com.formation.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.formation.entity.Client;


public class ClientDaoJdbc implements ClientDao {
	private DaoFactory daoFactory;
	public ClientDaoJdbc(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	@Override
	public void ajouter(Client client) {
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO noms(nom,prenom,adresse,poste) VALUES( \"youcef\", \"amour\",\"paris\",\"r\")");
			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(1, client.getPrenom());
			preparedStatement.setString(1, client.getAdresse());
			preparedStatement.setString(1, client.getPoste());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM client ;");
		
		while (resultat.next()){
			Client client = new Client();
			client.setId(resultat.getInt("id"));
			client.setNom(resultat.getString("nom"));
			client.setPrenom(resultat.getString("id"));
			client.setAdresse(resultat.getString("id"));
			client.setPoste(resultat.getString("id"));
	
			clients.add(client);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getById(Client client) {
		// TODO Auto-generated method stub
		
	}
	

}