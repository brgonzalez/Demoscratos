package com.itcr.demoscratos.models;

public final class Vote {
	
	private int option;
	private String topic;
	private String email;
	private String stringOption;
		
	public Vote(int option, String topic, String email) {
		setOption(option); setTopic(topic); setEmail(email); }

	public int getOption() {
		return option; }

	public void setOption(int option) {
		this.option = option; }

	public String getTopic() {
		return topic; }

	public void setTopic(String topic) {
		this.topic = topic; }

	public String getEmail() {
		return email; }

	public void setEmail(String email) {
		this.email = email;	}
	
	public String getStringOption() {
		return stringOption; }

	public void setStringOption(String stringOption) {
		this.stringOption = stringOption; }

	@Override
	public String toString() {
		return "Vote [option=" + option + ", topic=" + topic + ", email=" + email + "]"; } }
