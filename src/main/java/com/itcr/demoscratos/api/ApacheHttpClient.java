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

public final class ApacheHttpClient {
	
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
	
	public ApacheHttpClient(String path) {
		setPath(path); token = ""; }
		
	public void getHttpRequest(String resource) {
		setClient();
		setGetRequest(resource);
		setResponse(getRequest);
		setBr(); setOutput(); }
	
	public void deleteHttpRequest(String resource) {
		setClient();
		setDeleteRequest(resource);
		setResponse(deleteRequest);
		setBr(); setOutput(); }
	
	public StatusLine postHttpRequest(String resource, String json) {
		setClient();
		setPostRequest(resource, json);
		setResponse(postRequest);
		setBr(); setOutput();
		return response.getStatusLine(); }
	
	public HttpClient getClient() {
		return client; }
	
	private void setClient() {
		client = HttpClientBuilder.create().build(); }
	
	public HttpGet getGetRequest() {
		return getRequest; }
	
	private void setGetRequest(String resource) {
		getRequest =  new HttpGet(path + resource);
		getRequest.addHeader("Accept", "application/json");
		getRequest.addHeader("X-Access-Token", token); }
	
	public HttpPost getPostRequest() {
		return postRequest; }
	
	private void setPostRequest(String resource, String json) {
		postRequest = new HttpPost(path + resource);
		StringEntity input = null;
		try { input = new StringEntity(json); }
		catch (UnsupportedEncodingException e) { e.printStackTrace(); } 
		input.setContentType("application/json");
		postRequest.setEntity(input);
		postRequest.addHeader("X-Access-Token", token); }
	
	public HttpDelete getDeleteRequest() {
		return deleteRequest; }
	
	private void setDeleteRequest(String resource) {
		deleteRequest = new HttpDelete(path + resource);
		deleteRequest.addHeader("Accept", "application/json");
		deleteRequest.addHeader("X-Access-Token", token); }
	
	public HttpResponse getResponse() {
		return response; }
	
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
	
	public String getPath() {
		return path; }
	
	private void setPath(String path) {
		this.path = path; }
	
	public String getToken() {
		return token; }
	
	public void setToken() {
		token = response.getAllHeaders()[1].getValue().split(";")[0].replace("token=", "");
		if (token.equals("application/json")) { token = ""; } }

	public BufferedReader getBr() {
		return br; }
	
	private void setBr() {
		try { br = new BufferedReader(new InputStreamReader((response.getEntity().getContent()))); }
		catch (UnsupportedOperationException e) { e.printStackTrace(); }
		catch (IOException e) {	e.printStackTrace(); } }
	
	public String getOutput() {
		return output.toString(); }
	
	private void setOutput() {
		output = new StringBuffer(); String line = "";
		try { while ((line = br.readLine()) != null) { output.append(line); } }
		catch (IOException e) {	e.printStackTrace(); } } }