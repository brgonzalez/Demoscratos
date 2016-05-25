package com.itcr.demoscratos.models;

public class Vote {
	
	private Option option;
	private String userEmail;
		
	public Vote(Option option, String userEmail) {
		setOption(option); setUserEmail(userEmail); }

	public Option getOption() {
		return option; }

	public void setOption(Option option) {
		this.option = option; }

	public String getUserEmail() {
		return userEmail; }

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail; }

	@Override
	public String toString() {
		return "Vote [option=" + option.toString() + ", userEmail=" + userEmail + "]"; } }