package org.demoscratos.models;

import org.json.JSONObject;

public final class Forum {
	
	private String id;
	private String title;
	private String summary;
	private String avatar;
	private String displayName;
	
	public Forum(JSONObject json) {      
	    setId(json.getString("id"));
	    setTitle(json.getString("title"));
	    setSummary(json.getString("summary"));
	    JSONObject owner = json.getJSONObject("owner");
	    setDisplayName(owner.getString("displayName"));
	    setAvatar(owner.getString("avatar")); }

	public String getId() {
		return id; }

	public void setId(String id) {
		this.id = id; }

	public String getTitle() {
		return title; }

	public void setTitle(String title) {
		this.title = title; }

	public String getSummary() {
		return summary; }

	public void setSummary(String summary) {
		this.summary = summary; }

	public String getAvatar() {
		return avatar; }

	public void setAvatar(String avatar) {
		this.avatar = avatar; }

	public String getDisplayName() {
		return displayName; }

	public void setDisplayName(String displayName) {
		this.displayName = displayName; }

	@Override
	public String toString() {
		return "Forum [id=" + id + ", title=" + title + ", summary=" + summary + ", avatar=" + avatar + ", displayName="
				+ displayName + "]"; } }