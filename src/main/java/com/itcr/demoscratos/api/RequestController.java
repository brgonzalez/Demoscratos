package com.itcr.demoscratos.api;

import java.io.IOException;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcr.demoscratos.db.DataBaseController;
import com.itcr.demoscratos.models.Api;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;

public final class RequestController {
	
	private ApacheHttpClient client; 
	private ObjectMapper mapper;
	private DataBaseController database;

	public RequestController(String email, String password) {
		setClient(new ApacheHttpClient(Resource.PATH.getUrl()));
		signIn(email, password);
		setMapper(new ObjectMapper()); }
	
	public void signIn(String email, String password) {
		String json = "{ \"email\": \""+ email +"\", \"password\": \""+ password +"\" }";
		client.postHttpRequest(Resource.SINGIN.getUrl(), json);
		client.setToken(); }
	
	public void signOut() {
		client.removeToken(); } 
	
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
	
	public ArrayList<Topic> getTopics(String idForum) {
		ArrayList<Topic> topics = new ArrayList<Topic>();
		client.getHttpRequest(Resource.TOPICS.getUrl() + idForum);
		JSONArray array = new JSONArray(client.getOutput());
		JSONObject json;
		for (short index = 0; index < array.length(); index++) {
			json = array.getJSONObject(index);
			topics.add(new Topic(json)); }
		return topics; }
	
	public FullTopic getFullTopic(String idTopic) {
		client.getHttpRequest(Resource.TOPIC.getUrl() + idTopic);
		JSONObject json = new JSONObject(client.getOutput());
		FullTopic fullTopic = new FullTopic(json);
		return fullTopic; }
	
	public User getUserByEmail(String email) {
		client.getHttpRequest(Resource.SEARCH_USER.getUrl() + email);
		JSONArray array = new JSONArray(client.getOutput());
		User user = null;
		if (array.length() == 1) { user = new User(array.getJSONObject(0), email); }
		return user; }
		
	public void postRing(String idUser, String email1, String email2, String email3) {
		if (!email1.equals(email2) && !email1.equals(email3) && !email2.equals(email3)) {
			User member1 = getUserByEmail(email1);
			User member2 = getUserByEmail(email2);
			User member3 = getUserByEmail(email3);
			if (member1 != null && member2 != null && member3 != null) {
				database.insertRing(idUser, member1.getId(), member2.getId(), member3.getId()); } }
		}
	
	public void postForum(String name, String title, String summary) {
		String json = "{ \"name\":\""+name+"\", \"title\":\""+title+"\", \"summary\":\""+summary+"\" }";
		client.postHttpRequest(Resource.FORUM.getUrl(), json); }
	
	public void deleteForum(String idForum) {
		client.deleteHttpRequest(Resource.FORUM.getUrl() + idForum); }
	
	public void deleteRing(String idUser) {
		database.deleteRing(idUser); }
	
	public void updateRing(String idUser, String email1, String email2, String email3) {
		if (!email1.equals(email2) && !email1.equals(email3) && !email2.equals(email3)) {
			User member1 = getUserByEmail(email1);
			User member2 = getUserByEmail(email2);
			User member3 = getUserByEmail(email3);
			if (member1 != null && member2 != null && member3 != null) {
				database.updateRing(idUser, member1.getId(), member2.getId(), member3.getId()); } }
		}

	private void setClient(ApacheHttpClient client) {
		this.client = client; }

	private void setMapper(ObjectMapper mapper) {
		this.mapper = mapper; } }