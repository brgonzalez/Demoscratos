package com.itcr.demoscratos.api;

enum Resource {
	PATH("http://localhost:3000"),
	SINGIN("/signin/"),
	SINGUP("/signup/"),
	API("/api/"),
	FORUMS("/api/forum/all/"),
	FORUM("/api/forum/"),
	TOPICS("/api/topic/all?forum="),
	TOPIC("/api/topic/"),
	TOPIC_CREATE("/api/topic/create"),
	USER("/api/user/"),
	SEARCH_USER("/api/user/search?q="),
	PROFILE("/settings/profile"),
	PASSWORD("/settings/password"),
	NOTIFICATIONS("/settings/notifications");
		
	private final String url;
	
	Resource(String url) {
		this.url = url; }

	String getUrl() {
		return url; } }