package com.itcr.demoscratos.models;

public final class VisibleVote {
	
	private Option option;
	private User user;
		
	public VisibleVote(Option option, User user) {
		setOption(option); setUser(user); }

	public Option getOption() {
		return option; }

	public void setOption(Option option) {
		this.option = option; }
	
	public User getUser() {
		return user; }

	public void setUser(User user) {
		this.user = user; }

	@Override
	public String toString() {
		return "VisibleVote [option=" + option.toString() + ", user=" + user.toString() + "]"; } }
