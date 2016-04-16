package org.demoscratos.api;

public enum Resource {
	PATH("http://localhost:3000"),
	SINGIN("/signin/"),
	API("/api/"),
	FORUMS("/api/forum/all/"),
	FORUM("/api/forum/"),
	TOPICS("/api/topic/all?forum="),
	TOPIC("/api/topic/");
		
	private final String url;
	
	Resource(String url) {
		this.url = url; }

	public String getUrl() {
		return url; } }