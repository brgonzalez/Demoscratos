package com.itcr.demoscratos.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itcr.demoscratos.models.Ring;

public final class DataBaseController {
	
	private ConnectionDB connection; 

	public DataBaseController() {
		String driver = Settings.DRIVER.getValue();
		String url = Settings.URL.getValue();
		String username = Settings.USERNAME.getValue();
		String password = Settings.PASSWORD.getValue();
		setConnection(new ConnectionDB(driver, url, username, password)); }
	
	public String selectTopicType(String topicId) {
		connection.connect();
		String query = "SELECT type FROM topics WHERE id='"+ topicId +"'";
		ResultSet result = connection.executeQuery(query);
		String type = "";
		try {
			if (result.next()) {
				type = result.getString("type"); }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return type; }
	
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
				ring = new Ring(userId, member1, member2, member3);	}
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return ring; }
	
	public ArrayList<String> selectOptions(String topicId) {
		connection.connect();
		String query = "SELECT opt FROM options WHERE topic='"+ topicId +"'";
		ResultSet result = connection.executeQuery(query);
		ArrayList<String> options = new ArrayList<String>();
		try {
			while (result.next()) {
				options.add(result.getString("opt")); }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return options; }
	
	public void deleteRing(String userId) {
		connection.connect();
		String query = "DELETE FROM rings WHERE id='"+userId+"'";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void deleteTopic(String topicId) {
		connection.connect();
		String query = "DELETE FROM topics WHERE id='"+topicId+"'";
		connection.executeUpdate(query);
		connection.disconnect(); }
		
	public void updateRing(String userId, String member1, String member2, String member3) {
		deleteRing(userId);
		insertRing(userId, member1, member2, member3); }
	
	private void insertRing(String userId, String member1, String member2, String member3) {
		connection.connect();
		String query = "INSERT INTO rings(id, member1, member2, member3) VALUES('"+userId+"', '"+member1+"', '"+member2+"', '"+member3+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void insertTopic(String topicId, String type) {
		connection.connect();
		String query = "INSERT INTO topics(id, type) VALUES('"+topicId+"', '"+type+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void insertOption(String topicId, String option) {
		connection.connect();
		String query = "INSERT INTO options(topic, opt) VALUES('"+topicId+"', '"+option+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void insertMultipleVote(String topicId, int opt, String userEmail) {
		connection.connect();
		String query = "INSERT INTO multiple_votes(topic, opt, email) VALUES('"+topicId+"', "+String.valueOf(opt)+", '"+userEmail+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void insertUniqueVote(String topicId, int opt, String userEmail) {
		connection.connect();
		String query = "INSERT INTO unique_votes(topic, opt, email) VALUES('"+topicId+"', "+String.valueOf(opt)+", '"+userEmail+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	private void setConnection(ConnectionDB connection) {
		this.connection = connection; } }