package com.itcr.demoscratos.models;

import com.itcr.demoscratos.api.RequestController;

public final class GivenVote extends Vote {
	
	private int id;
	private String memberEmail;
	private User user;
	

	public GivenVote(int id, Option option, String userEmail, String memberEmail) {
		super(option, userEmail); setId(id);
		setMemberEmail(memberEmail);
		setUser(userEmail);}
	
	public int getId() {
		return id; }

	public void setId(int id) {
		this.id = id; }

	public String getMemberEmail() {
		return memberEmail;	}
	
	public User getUser(){
		return user;}
	
	public void setUser(String userEmail){
		RequestController request = RequestController.getInstance();
		this.user = request.getUserByEmail(userEmail);
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;	}
	
	public boolean isAlreadyVoted() {
		return (super.getOption() == null); }

	@Override
	public String toString() {
		return "GivenVote [id=" + id + ", memberEmail=" + memberEmail + "]"; } }