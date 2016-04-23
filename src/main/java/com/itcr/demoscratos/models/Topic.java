package com.itcr.demoscratos.models;

import org.json.JSONObject;

public class Topic {
	
	private String id;
	private String title;
	private boolean closed;
	private Object closingAt;

	public Topic(JSONObject json) {
		setId(json.getString("id"));
		setTitle(json.getString("mediaTitle"));
		setClosed(json.getBoolean("closed"));
		setClosingAt(json.get("closingAt")); }

	public String getId() {
		return id; }

	public void setId(String id) {
		this.id = id; }

	public String getTitle() {
		return title; }

	public void setTitle(String title) {
		this.title = title; }

	public boolean isClosed() {
		return closed; }

	public void setClosed(boolean closed) {
		this.closed = closed; }

	public Object getClosingAt() {
		return closingAt; }

	public void setClosingAt(Object closingAt) {
		this.closingAt = closingAt; }

	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", closed=" + closed + ", closingAt=" + closingAt + "]"; } }
