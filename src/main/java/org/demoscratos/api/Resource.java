package org.demoscratos.api;

public enum Resource {
	PATH("http://localhost:3000"),
	API("/api"),
	FORUMS("/api/forum/all");
		
	private final String url;
	
	Resource(String url) {
		this.url = url; }

	public String getUrl() {
		return url; } }
