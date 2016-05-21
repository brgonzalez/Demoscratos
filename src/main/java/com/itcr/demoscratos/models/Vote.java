package com.itcr.demoscratos.models;

public final class Vote {
	
	private Option option;
	private String email;
		
	public Vote(Option option, String email) {
		setOption(option); setEmail(email); }

	public Option getOption() {
		return option; }

	public void setOption(Option option) {
		this.option = option; }

	public String getEmail() {
		return email; }

	public void setEmail(String email) {
		this.email = email; }

	@Override
	public String toString() {
		return "Vote [option=" + option.toString() + ", email=" + email + "]"; } }
	
	
