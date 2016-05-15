package com.itcr.demoscratos.models;

public final class Option {
	
	private int id;
	private String topic;
	private String option;

	public Option(int id, String topic, String option) {
		setId(id); setTopic(topic); setOpt(option);	}

	public int getId() {
		return id; }

	public void setId(int id) {
		this.id = id; }

	public String getTopic() {
		return topic; }

	public void setTopic(String topic) {
		this.topic = topic;	}

	public String getOption() {
		return option; }

	public void setOpt(String option) {
		this.option = option; }

	@Override
	public String toString() {
		return "Option [id=" + id + ", topic=" + topic + ", option=" + option + "]"; } }
