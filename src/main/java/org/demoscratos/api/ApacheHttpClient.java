// Paquete:
package org.demoscratos.api;

// Bibliotecas:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public final class ApacheHttpClient {
	
	// Atributos:
	private HttpClient client;
	private HttpGet getRequest;
	private HttpResponse response;
	private String path;
	private BufferedReader br;
	private StringBuffer output;
	
	public ApacheHttpClient(String path) { setPath(path); }
		
	public void getHttpRequest(String resource) {
		setClient();
		setGetRequest(resource);
		setResponse();
		setBr();
		setOutput(); }
	
	public HttpClient getClient() {
		return client; }
	
	private void setClient() {
		client = HttpClientBuilder.create().build(); }
	
	public HttpGet getGetRequest() {
		return getRequest; }
	
	private void setGetRequest(String resource) {
		getRequest =  new HttpGet(path + resource);
		getRequest.addHeader("accept", "application/json");	}
	
	public HttpResponse getResponse() {
		return response; }
	
	private void setResponse() {
		try { response = client.execute(getRequest); }
		catch (ClientProtocolException e) {	e.printStackTrace(); }
		catch (IOException e) {	e.printStackTrace(); } }
	
	public String getPath() {
		return path; }
	
	private void setPath(String path) {
		this.path = path; }

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