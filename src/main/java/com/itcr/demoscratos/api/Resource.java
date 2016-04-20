package com.itcr.demoscratos.api;

enum Resource {
	PATH("http://localhost:3000"),
	SINGIN("/signin/"),
	API("/api/"),
	FORUMS("/api/forum/all/"),
	FORUM("/api/forum/"),
	TOPICS("/api/topic/all?forum="),
	TOPIC("/api/topic/"),
	USER("/api/user/"),
	SEARCH_USER("/api/user/search?q=");
		
	private final String url;
	
	Resource(String url) {
		this.url = url; }

	String getUrl() {
		return url; } }