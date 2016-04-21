package com.itcr.demoscratos.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itcr.demoscratos.models.Ring;

public final class DataBaseController {
	
	private ConnectionDB connection; 

	public DataBaseController() {
		String driver = Settings.DRIVER.getValue();
		String url = Settings.URL.getValue();
		String username = Settings.USERNAME.getValue();
		String password = Settings.PASSWORD.getValue();
		setConnection(new ConnectionDB(driver, url, username, password)); }
	
	public Ring selectRing(String userId) {
		connection.connect();
		String query = "SELECT * FROM rings WHERE id='"+ userId +"'";
		ResultSet result = connection.executeQuery(query);
		String member1, member2, member3; Ring ring = null;
		try {
			if (result.next()) {
				member1 = result.getString("member1");
				member2 = result.getString("member2");
				member3 = result.getString("member3");
				connection.disconnect();
				ring = new Ring(userId, member1, member2, member3);	} }
		catch (SQLException e) { e.printStackTrace(); } 
		return ring; }
	
	public void deleteRing(String userId) {
		connection.connect();
		String query = "DELETE FROM rings WHERE id='"+userId+"'";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	private void insertRing(String userId, String member1, String member2, String member3) {
		connection.connect();
		String query = "INSERT INTO rings(id, member1, member2, member3) VALUES('"+userId+"', '"+member1+"', '"+member2+"', '"+member3+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void updateRing(String userId, String member1, String member2, String member3) {
		deleteRing(userId);
		insertRing(userId, member1, member2, member3); }
	
	private void setConnection(ConnectionDB connection) {
		this.connection = connection; } }