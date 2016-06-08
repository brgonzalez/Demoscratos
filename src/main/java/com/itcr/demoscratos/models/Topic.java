package com.itcr.demoscratos.models;

import org.json.JSONObject;

public class Topic {
	
	private String id;
	private String title;
	private String type;
	private boolean closed;
	private Object createdAt;
	private Object closingAt;	

	public Topic(JSONObject json, String type) {
		setId(json.getString("id"));
		setTitle(json.getString("mediaTitle"));
		setClosed(json.getBoolean("closed"));
		setClosingAt(json.get("closingAt"));
		setCreatedAt("createdAt");
		setType(type); }

	public String getId() {
		return id; }

	public void setId(String id) {
		this.id = id; }

	public String getTitle() {
		return title; }

	public void setTitle(String title) {
		this.title = title; }
	
	public String getType() {
		return type; }

	public void setType(String type) {
		this.type = type; }

	public boolean isClosed() {
		return closed; }

	public void setClosed(boolean closed) {
		this.closed = closed; }
	
	public Object getCreatedAt() {
		return createdAt; }

	public void setCreatedAt(Object createdAt) {
		this.createdAt = createdAt; }

	public Object getClosingAt() {
		return closingAt; }

	public void setClosingAt(Object closingAt) {
		this.closingAt = closingAt; }

	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", type=" + type + ", closed=" + closed + "]"; } }