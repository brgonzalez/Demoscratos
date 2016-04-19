package com.itcr.demoscratos.models;

import org.json.JSONObject;

public final class User {
	
	private String id;
	private String email;
	private String displayName;
	private String avatar;

	public User(JSONObject json, String email) {
		setId(json.getString("id"));
		setEmail(email);
		setDisplayName(json.getString("displayName"));
		setAvatar(json.getString("avatar")); }

	public String getId() {
		return id; }

	public void setId(String id) {
		this.id = id; }

	public String getEmail() {
		return email; }

	public void setEmail(String email) {
		this.email = email; }

	public String getDisplayName() {
		return displayName; }

	public void setDisplayName(String displayName) {
		this.displayName = displayName; }

	public String getAvatar() {
		return avatar; }

	public void setAvatar(String avatar) {
		this.avatar = avatar; }

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", displayName=" + displayName + ", avatar=" + avatar + "]"; } }