package com.itcr.demoscratos.models;

import org.json.JSONObject;

public final class Tag {
	
	private String id;
	private String name;

	public Tag(JSONObject json) {
		setId(json.getString("id"));
		setName(json.getString("name")); }

	public String getId() {
		return id; }

	public void setId(String id) {
		this.id = id; }

	public String getName() {
		return name; }

	public void setName(String name) {
		this.name = name; } }
