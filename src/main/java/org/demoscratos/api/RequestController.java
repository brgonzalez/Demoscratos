package org.demoscratos.api;

import java.io.IOException;
import java.util.ArrayList;

import org.demoscratos.models.Api;
import org.demoscratos.models.Forum;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class RequestController {
	
	private ApacheHttpClient client; 
	private ObjectMapper mapper;

	public RequestController() {
		setClient(new ApacheHttpClient(Resource.PATH.getUrl()));
		setMapper(new ObjectMapper()); }
	
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
	
	public ApacheHttpClient getClient() {
		return client; }

	private void setClient(ApacheHttpClient client) {
		this.client = client; }

	public ObjectMapper getMapper() {
		return mapper; }

	private void setMapper(ObjectMapper mapper) {
		this.mapper = mapper; } }