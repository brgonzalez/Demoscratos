package com.itcr.demoscratos.api;

import java.io.IOException;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcr.demoscratos.models.Api;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Topic;

public final class RequestController {
	
	private ApacheHttpClient client; 
	private ObjectMapper mapper;

	public RequestController(String email, String password) {
		setClient(new ApacheHttpClient(Resource.PATH.getUrl()));
		signIn(email, password);
		setMapper(new ObjectMapper()); }
	
	private void signIn(String email, String password) {
		String json = "{ \"email\": \""+ email +"\", \"password\": \""+ password +"\" }";
		client.postHttpRequest(Resource.SINGIN.getUrl(), json).getStatusCode();
		client.setToken(); }
	
	public boolean isLoggedIn() {
		return !client.getToken().isEmpty(); }
	
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
	
	public FullTopic getFullTopic(String topic) {
		client.getHttpRequest(Resource.TOPIC.getUrl() + topic);
		JSONObject json = new JSONObject(client.getOutput());
		FullTopic fullTopic = new FullTopic(json);
		return fullTopic; }
	
	public void deleteForum(String forum) {
		client.deleteHttpRequest(Resource.FORUM.getUrl() + forum); }
	
	public void postForum(String name, String title, String summary) {
		String json = "{ \"name\":\""+name+"\", \"title\":\""+title+"\", \"summary\":\""+summary+"\" }";
		client.postHttpRequest(Resource.FORUM.getUrl(), json); }
	
	public ApacheHttpClient getClient() {
		return client; }

	private void setClient(ApacheHttpClient client) {
		this.client = client; }

	public ObjectMapper getMapper() {
		return mapper; }

	private void setMapper(ObjectMapper mapper) {
		this.mapper = mapper; } }