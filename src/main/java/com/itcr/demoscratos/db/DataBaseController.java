package com.itcr.demoscratos.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itcr.demoscratos.models.GivenVote;
import com.itcr.demoscratos.models.Option;
import com.itcr.demoscratos.models.Report;
import com.itcr.demoscratos.models.Ring;
import com.itcr.demoscratos.models.TotalVotes;
import com.itcr.demoscratos.models.Vote;

public final class DataBaseController {
	
	private ConnectionDB connection; 

	public DataBaseController() {
		String driver = Settings.DRIVER.getValue();
		String url = Settings.URL.getValue();
		String username = Settings.USERNAME.getValue();
		String password = Settings.PASSWORD.getValue();
		setConnection(new ConnectionDB(driver, url, username, password)); }
	
	public String selectTopicAttr(String topicId, String column) {
		connection.connect();
		String query = "SELECT "+column+" FROM topics WHERE id='"+ topicId +"'";
		ResultSet result = connection.executeQuery(query);
		String type = "";
		try {
			if (result.next()) {
				type = result.getString(column); }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return type; }
	
	public ArrayList<String> selectRingMembers(String email) {
		connection.connect();
		String query = "SELECT id from rings where member1 = '"+email+"' or member2 = '"+email+"' or member3 = '"+email+"'";
		ResultSet result = connection.executeQuery(query);
		ArrayList<String> members = new ArrayList<String>();
		try {
			while (result.next()) {
				members.add(result.getString("id")); }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return members; }
	
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
	
	public boolean selectGivenVote(String topicId, String userEmail) {
		connection.connect();
		String query = "SELECT * FROM given_votes WHERE topic='"+ topicId +"' AND email_user = '"+userEmail+"'";
		ResultSet result = connection.executeQuery(query);
		boolean value = false; 
		try {
			if (result.next()) {
				value = true; }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return value; }
	
	public ArrayList<Option> selectOptions(String topicId) {
		connection.connect();
		String query = "SELECT * FROM options WHERE topic='"+ topicId +"'";
		ResultSet result = connection.executeQuery(query);
		ArrayList<Option> options = new ArrayList<Option>();
		String topic = topicId;
		String option; int id;
		try {
			while (result.next()) {
				id = result.getInt("id");
				option = result.getString("opt");
				options.add(new Option(id, topic, option)); }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return options; }
	
	public ArrayList<Vote> selectVotes(String topicId, String type) {
		connection.connect();
		String query = "SELECT t1.id, t1.opt, t2.email FROM options AS t1, (SELECT * FROM "+type+"_votes WHERE topic = '"+topicId+"') AS t2 WHERE t1.id = t2.opt";
		ResultSet result = connection.executeQuery(query);
		ArrayList<Vote> votes = new ArrayList<Vote>();
		String email, option; int id;
		try {
			while (result.next()) {
				id = result.getInt("id");
				option = result.getString("opt");
				email = result.getString("email");
				votes.add(new Vote(new Option(id, topicId, option), email)); }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return votes; }
	
	public ArrayList<GivenVote> selectGivenVotes(String topicId, String memberEmail) {
		connection.connect();
		String query = "SELECT id, email_user FROM given_votes WHERE topic = '"+topicId+"' AND email_member = '"+memberEmail+"' AND opt = 4";
		ResultSet result = connection.executeQuery(query);
		ArrayList<GivenVote> votes = new ArrayList<GivenVote>();
		String userEmail; int id;
		try {
			while (result.next()) {
				id = result.getInt("id");
				userEmail = result.getString("email_user");
				votes.add(new GivenVote(id, null, userEmail, memberEmail)); }
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return votes; }
	
	public Report selectReport(String topicId, String type) {
		connection.connect();
		String query = "SELECT t2.id, t2.opt, t1.cnt FROM "
				+ "(SELECT opt, count(*) AS 'cnt' FROM "
				+ "(SELECT topic, opt FROM given_votes UNION ALL SELECT topic, opt FROM "+type+"_votes) AS t3 "
				+ "WHERE topic = '"+topicId+"' GROUP BY opt) AS t1, options AS t2 WHERE t2.id = t1.opt";
		ResultSet result = connection.executeQuery(query);
		ArrayList<TotalVotes> totalVotes = new ArrayList<TotalVotes>();
		String option; int id, cnt, total = 0;
		Report report = new Report(total, totalVotes);
		try {
			while (result.next()) {
				id = result.getInt("id");
				option = result.getString("opt");
				cnt = result.getInt("cnt");
				totalVotes.add(new TotalVotes(new Option(id, topicId, option), cnt));
				total += cnt; }
			report = new Report(total, totalVotes);
			connection.disconnect(); }
		catch (SQLException e) { e.printStackTrace(); } 
		return report; }
	
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
	
	public void insertTopic(String topicId, String secret, String type) {
		connection.connect();
		String query = "INSERT INTO topics(id, private, type) VALUES('"+topicId+"', '"+secret+"', '"+type+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void insertGivenVote(String topicId, String userEmail, String memberEmail) {
		connection.connect();
		String query = "INSERT INTO given_votes(topic, opt, email_user, email_member) VALUES ('"+topicId+"', 4, '"+userEmail+"', '"+memberEmail+"')";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void updateGivenVote(int givenVoteId, int optionId) {
		connection.connect();
		String query = "UPDATE given_votes SET opt = "+optionId+" WHERE id = '"+givenVoteId+"'";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void updateTopicApproval(String topicId, String value) {
		connection.connect();
		String query = "UPDATE topics SET approved = '"+value+"' WHERE id = '"+topicId+"'";
		connection.executeUpdate(query);
		connection.disconnect(); }
	
	public void updateQuestion(String topicId, String question) {
		connection.connect();
		String query = "UPDATE topics SET question = '"+question+"' WHERE id = '"+topicId+"'";
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