package com.itcr.demoscratos.api;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.StatusLine;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcr.demoscratos.db.DataBaseController;
import com.itcr.demoscratos.models.Api;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.GivenVote;
import com.itcr.demoscratos.models.Report;
import com.itcr.demoscratos.models.Ring;
import com.itcr.demoscratos.models.Tag;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;
import com.itcr.demoscratos.mongodb.ConnectionMongo;

public final class RequestController {
	
	private ApacheHttpClient client; 
	private ObjectMapper mapper;
	private DataBaseController database;
	private ConnectionMongo mongodb = new ConnectionMongo();
	private User currentUser;
	private String adminEmail = "brgonzalezcr@gmail.com";
	
	private static RequestController instance = null;
	
	public RequestController() {
		setClient(new ApacheHttpClient(Resource.PATH.getUrl()));
		setMapper(new ObjectMapper());
		setDataBase(new DataBaseController()); }
	
	public static synchronized RequestController getInstance() {
		if (instance == null) {
			instance = new RequestController(); }
		return instance; }
	
	public User getCurrentUser(){
		return currentUser; }
			
	public void signIn(String email, String password) {
		String json = "{ \"email\": \""+ email +"\", \"password\": \""+ password +"\" }";
		client.postHttpRequest(Resource.SINGIN.getUrl(), json);
		client.setToken();
		if (isLoggedIn()) { setCurrentUser(getUserByEmail(email)); }
		else { System.err.println("El correo electrónico o la contraseña no existen"); } }
	
	public void signUp(String email, String firstName, String lastName, String password) {
		String json = "{ \"email\": \""+email+"\", \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"password\":\""+password+"\", \"re_password\":\""+password+"\" }";
		client.postHttpRequest(Resource.SINGUP.getUrl(), json); }
	
	public void signOut() {
		client.removeToken();
		setCurrentUser(null); } 
	
	public boolean isLoggedIn() {
		return client.tokenExists(); }
	
	public Api getApi() {
		client.getHttpRequest(Resource.API.getUrl()); Api api = null;
		try { api = mapper.readValue(client.getOutput(), Api.class); }
		catch (JsonParseException e) { e.printStackTrace(); }
		catch (JsonMappingException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		return api;	}
	
	public ArrayList<Forum> getForums() {
		ArrayList<Forum> forums = new ArrayList<Forum>();
		client.getHttpRequest(Resource.FORUMS.getUrl());
		JSONArray array = new JSONArray(client.getOutput());
		JSONObject json;
		for (short index = 0; index < array.length(); index++) {
			json = array.getJSONObject(index);
			forums.add(new Forum(json)); }
		return forums; }
	
	public ArrayList<Topic> getTopicsAdmin(String idForum) {
		ArrayList<Topic> topics = new ArrayList<Topic>();
		client.getHttpRequest(Resource.TOPICS.getUrl() + idForum);
		JSONArray array = new JSONArray(client.getOutput());
		String type, idTopic;
		JSONObject json;
		for (short index = 0; index < array.length(); index++) {
			json = array.getJSONObject(index);
			idTopic = json.getString("id");
			type = database.selectTopicAttr(idTopic, "type");
			topics.add(new Topic(json, type)); }
		return topics; }
	
	public ArrayList<Topic> getTopics(String idForum) {
		ArrayList<Topic> topics = new ArrayList<Topic>();
		client.getHttpRequest(Resource.TOPICS.getUrl() + idForum);
		JSONArray array = new JSONArray(client.getOutput());
		String type, idTopic, approved;
		JSONObject json;
		for (short index = 0; index < array.length(); index++) {
			json = array.getJSONObject(index);
			idTopic = json.getString("id");
			approved = database.selectTopicAttr(idTopic, "approved");
			type = database.selectTopicAttr(idTopic, "type");
			if (approved.equals("true")) { topics.add(new Topic(json, type)); } }
		return topics; }
	
	public ArrayList<Tag> getTags() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		client.getHttpRequest(Resource.TAGS.getUrl());
		JSONArray array = new JSONArray(client.getOutput());
		JSONObject json;
		for (short index = 0; index < array.length(); index++) {
			json = array.getJSONObject(index);
			tags.add(new Tag(json)); }
		return tags; } 
	
	public FullTopic getFullTopic(String idTopic) {
		client.getHttpRequest(Resource.TOPIC.getUrl() + idTopic);
		JSONObject json = new JSONObject(client.getOutput());
		String type = database.selectTopicAttr(idTopic, "type");
		String secret = database.selectTopicAttr(idTopic, "private");
		ArrayList<GivenVote> givenVotes = database.selectGivenVotes(idTopic, currentUser.getEmail());
		FullTopic fullTopic = new FullTopic(json, Boolean.valueOf(secret), type, currentUser, givenVotes);
		ArrayList<String> ringEmails = database.selectRingMembers(currentUser.getEmail());
		ArrayList<User> ringUsers = new ArrayList<User>();
		if (!ringEmails.isEmpty()) {
			for (String email : ringEmails) {
				ringUsers.add(getUserByEmail(email)); }	}
		fullTopic.setRingMembers(ringUsers);
		if (!fullTopic.getType().equals("simple")) {
			fullTopic.setQuestion(database.selectTopicAttr(idTopic, "question"));
			fullTopic.setOptions(database.selectOptions(idTopic));
			fullTopic.setVotes(database.selectVotes(idTopic, type)); }
		return fullTopic; }
	
	public User getUserByEmail(String email) {
		client.getHttpRequest(Resource.SEARCH_USER.getUrl() + email);
		JSONArray array = new JSONArray(client.getOutput());
		User user = null;
		boolean admin = ((email.equals(adminEmail)) ? true : false);
		if (array.length() == 1) { user = new User(array.getJSONObject(0), email, admin); }
		return user; }
			
	public ArrayList<User> getRing() {
		ArrayList<User> users = new ArrayList<User>(); 
		Ring ring = database.selectRing(currentUser.getEmail());
		if (ring != null) {	
			User member1 = getUserByEmail(ring.getMember1());
			User member2 = getUserByEmail(ring.getMember2());
			User member3 = getUserByEmail(ring.getMember3());
			users.add(member1); users.add(member2); users.add(member3);	}
		else {
			System.err.println("El usuario actual aún no ha definido un anillo de confianza.");	}
		return users; }
	
	public Report getReport(String idTopic) {
		FullTopic topic = getFullTopic(idTopic);
		if (topic.getType().equals("simple")) {
			return topic.getReportSimple(); }
		else {
			return database.selectReport(topic.getId(), topic.getType()); }	}
		
	public void postRing(String email1, String email2, String email3) {
		User member1 = getUserByEmail(email1);
		User member2 = getUserByEmail(email2);
		User member3 = getUserByEmail(email3);
		if (checkRing(member1, member2, member3)) {
			database.updateRing(currentUser.getEmail(), member1.getEmail(), member2.getEmail(), member3.getEmail()); } }
	
	public String postTopic(String idForum, String title, String tag, String closingAt, String source, String content, boolean votable, boolean secret) {
		String type = "simple";
		return postTopic(idForum, title, tag, closingAt, source, content, type, votable, secret); }
	
	private String postTopic(String idForum, String title, String tag, String closingAt, String source, String content, String type, boolean votable, boolean secret) {
		boolean flag = !isThereOwnForum();
		if (flag) { postForum("temporal", "Temporal", "Temporal"); }
		String json = "{ \"topicId\": \"\", \"author\": \"\", \"authorUrl\": \"\", \"forum\": \""+idForum+"\", \"mediaTitle\": \""+title+"\", \"source\": \""+source+"\", \"tag\": { \"name\": \""+tag+"\" }, \"closingAt\":\""+closingAt+"\", \"votable\": "+votable+", \"clauses\": [ { \"markup\": \""+content+"\" } ] }";
		client.postHttpRequest(Resource.TOPIC_CREATE.getUrl(), json);
		JSONObject object = new JSONObject(client.getOutput());
		String idTopic = object.getString("id");
		client.postHttpRequest(Resource.TOPIC.publish(idTopic), "");
		database.insertTopic(idTopic, String.valueOf(secret), type);
		if (flag) { mongodb.updateTopic(idTopic, idForum); deleteForum("temporal"); }
		return idTopic; }
	
	private boolean isThereOwnForum() {
		StatusLine status = client.getHttpRequest(Resource.FORUM_MINE.getUrl());
		return (status.getStatusCode() != 404); }
	
	public String postTopic(String idForum, String title, String tag, String closingAt, String source, String content, boolean multiple, boolean secret, String question, ArrayList<String> options) {
		String type = (multiple) ? "multiple":"unique";
		String idTopic = postTopic(idForum, title, tag, closingAt, source, content, type, true, secret);
		database.updateQuestion(idTopic, question);
		for (String option: options) { database.insertOption(idTopic, option); }
		return idTopic; }
			
	public void postMultipleVote(String idTopic, int idOption) {
		database.insertMultipleVote(idTopic, idOption, currentUser.getEmail()); }
	
	public void postUniqueVote(String idTopic, int idOption) {
		database.insertUniqueVote(idTopic, idOption, currentUser.getEmail()); }
	
	public void postGivenVote(int idGivenVote, int idOption ) {
		database.updateGivenVote(idGivenVote, idOption); }
	
	public boolean doesGivenVoteExist(String idTopic) {
		return database.selectGivenVote(idTopic, currentUser.getEmail()); }
	
	public void postGiveVote(String idTopic, String memberEmail) {
		database.insertGivenVote(idTopic, currentUser.getEmail(), memberEmail); }
	
	public String postForum(String name, String title, String summary) {
		String json = "{ \"name\":\""+name+"\", \"title\":\""+title+"\", \"summary\":\""+summary+"\" }";
		client.postHttpRequest(Resource.FORUM.getUrl(), json);
		JSONObject object = new JSONObject(client.getOutput());
		return object.getString("name"); }
	
	public void postPassword(String currentPassword, String newPassword) {
		String json = "{ \"current_password\":\""+currentPassword+"\", \"password\":\""+newPassword+"\" }";
		client.postHttpRequest(Resource.PASSWORD.getUrl(), json); }
	
	public void postProfile(String firstName, String lastName, String pictureUrl) {
		String json = "{ \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"profilePictureUrl\":\""+pictureUrl+"\" }";
		client.postHttpRequest(Resource.PROFILE.getUrl(), json); }
	
	public void postNotifications(boolean replies, boolean newTopic) {
		String json = "{ \"replies\": "+replies+", \"new-topic\": "+newTopic+" }";
		client.postHttpRequest(Resource.PASSWORD.getUrl(), json); }
	
	public void postPositiveVote(String idTopic) {
		postVote(idTopic, "positive"); }
	
	public void postNegativeVote(String idTopic) {
		postVote(idTopic, "negative"); }
	
	public void postAbstentionVote(String idTopic) {
		postVote(idTopic, "abstention"); }
	
	private void postVote(String idTopic, String value) {
		String json = "{ \"value\":\""+value+"\" }";
		client.postHttpRequest(Resource.TOPIC.vote(idTopic), json);	}
	
	public void postTag(String idTag, String name) {
		String json = "{ \"name\":\""+name+"\" }";
		client.postHttpRequest(Resource.TAG.getUrl()+idTag, json); }
	
	public void postTag(String name) {
		String json = "{ \"hash\":\""+name.toLowerCase()+"\", \"name\":\""+name+"\", \"image\": \"internet\"}";
		client.postHttpRequest(Resource.TAG_CREATE.getUrl(), json); }
	
	public void postTopicApproved(String idTopic) {
		database.updateTopicApproval(idTopic, "true"); }
	
	public boolean isTopicApprove(String idTopic) {
		String string  = database.selectTopicAttr(idTopic, "approved");
		return string.equals("true"); }
	
	public void postTopicDisapprove(String idTopic) {
		database.updateTopicApproval(idTopic, "false"); }
		
	public void deleteForum(String nameForum) {
		client.deleteHttpRequest(Resource.FORUM.getUrl() + nameForum); }
	
	public void deleteTopic(String idTopic) {
		client.deleteHttpRequest(Resource.TOPIC.getUrl() + idTopic);
		database.deleteTopic(idTopic); }
	
	public void deleteRing() {
		database.deleteRing(currentUser.getId()); }
		
	private boolean checkRing(User member1, User member2, User member3) {
		if (member1 != null && member2 != null && member3 != null) {
			if (!member1.equals(member2) && !member1.equals(member3) && !member2.equals(member3)) {
				if (!currentUser.equals(member1) && !currentUser.equals(member2) && !currentUser.equals(member3)) {
					return true; }
				else {
					System.err.println("No es posible agregarse a usted mismo al anillo de confianza");
					return false; }	}
			else {
				System.err.println("Todos los correos deben ser distintos");
				return false; } }
		else {
			System.err.println("Alguno de los correos ingresados no existe");
			return false; } }
	
	private void setClient(ApacheHttpClient client) {
		this.client = client; }

	private void setMapper(ObjectMapper mapper) {
		this.mapper = mapper; }

	private void setDataBase(DataBaseController database) {
		this.database = database; }
	
	private void setCurrentUser(User currentUser) {
		this.currentUser = currentUser; } }
