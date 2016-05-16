// Paquete:
package com.itcr.demoscratos.api;

// Bibliotecas:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

final class ApacheHttpClient {
	
	// Atributos:
	private HttpClient client;
	private HttpGet getRequest;
	private HttpPost postRequest;
	private HttpDelete deleteRequest;
	private HttpResponse response;
	private String path;
	private String token;
	private BufferedReader br;
	private StringBuffer output;
	
	protected ApacheHttpClient(String path) {
		setPath(path); token = ""; }
		
	protected StatusLine getHttpRequest(String resource) {
		setClient();
		setGetRequest(resource);
		setResponse(getRequest);
		setBr(); setOutput();
		return response.getStatusLine(); }
	
	protected StatusLine deleteHttpRequest(String resource) {
		setClient();
		setDeleteRequest(resource);
		setResponse(deleteRequest);
		setBr(); setOutput();
		return response.getStatusLine(); }
	
	protected StatusLine postHttpRequest(String resource, String json) {
		setClient();
		setPostRequest(resource, json);
		setResponse(postRequest);
		setBr(); setOutput();
		return response.getStatusLine(); }
	
	private void setClient() {
		client = HttpClientBuilder.create().build(); }
		
	private void setGetRequest(String resource) {
		getRequest =  new HttpGet(path + resource);
		getRequest.addHeader("Accept", "application/json");
		getRequest.addHeader("Accept-Language", "es-419,es;q=0.8");
		getRequest.addHeader("Cookie", token); }
	
	private void setPostRequest(String resource, String json) {
		postRequest = new HttpPost(path + resource);
		StringEntity input = null;
		try { input = new StringEntity(json); }
		catch (UnsupportedEncodingException e) { e.printStackTrace(); } 
		input.setContentType("application/json");
		postRequest.setEntity(input);
		postRequest.addHeader("Accept", "application/json");
		postRequest.addHeader("Accept-Language", "es-419,es;q=0.8");
		postRequest.addHeader("Cookie", token); }
	
	private void setDeleteRequest(String resource) {
		deleteRequest = new HttpDelete(path + resource);
		deleteRequest.addHeader("Accept", "application/json");
		deleteRequest.addHeader("Accept-Language", "es-419,es;q=0.8");
		deleteRequest.addHeader("Cookie", token); }
		
	private void setResponse(HttpGet getRequest) {
		try { response = client.execute(this.getRequest); }
		catch (ClientProtocolException e) {	e.printStackTrace(); }
		catch (IOException e) {	e.printStackTrace(); } }
	
	private void setResponse(HttpPost postRequest) {
		try { response = client.execute(this.postRequest); }
		catch (ClientProtocolException e) {	e.printStackTrace(); }
		catch (IOException e) {	e.printStackTrace(); } }
	
	private void setResponse(HttpDelete deleteRequest) {
		try { response = client.execute(this.deleteRequest); }
		catch (ClientProtocolException e) {	e.printStackTrace(); }
		catch (IOException e) {	e.printStackTrace(); } }
		
	private void setPath(String path) {
		this.path = path; }
	
	protected void removeToken() {
		token = ""; }
	
	protected boolean tokenExists() {
		return !token.isEmpty(); }
	
	protected void setToken() {
		token = response.getFirstHeader("Set-Cookie").getValue().split(";")[0];
		System.out.println(token); }
	
	private void setBr() {
		try { br = new BufferedReader(new InputStreamReader((response.getEntity().getContent()))); }
		catch (UnsupportedOperationException e) { e.printStackTrace(); }
		catch (IOException e) {	e.printStackTrace(); } }
	
	protected String getOutput() {
		return output.toString(); }
	
	private void setOutput() {
		output = new StringBuffer(); String line = "";
		try { while ((line = br.readLine()) != null) { output.append(line); } }
		catch (IOException e) {	e.printStackTrace(); } } }