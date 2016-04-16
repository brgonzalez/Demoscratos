package org.demoscratos.models;

public final class Notification {
	
	private boolean new_topic;
	private boolean replies;
	
	public boolean isNew_topic() {
		return new_topic; }
	
	public void setNew_topic(boolean new_topic) {
		this.new_topic = new_topic; }
	
	public boolean isReplies() {
		return replies; }
	
	public void setReplies(boolean replies) {
		this.replies = replies; }

	@Override
	public String toString() {
		return "Notification [new_topic=" + new_topic + ", replies=" + replies + "]"; } }


