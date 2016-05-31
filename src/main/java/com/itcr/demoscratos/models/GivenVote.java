package com.itcr.demoscratos.models;

public final class GivenVote extends Vote {
	
	private int id;
	private String memberEmail;

	public GivenVote(int id, Option option, String userEmail, String memberEmail) {
		super(option, userEmail); setId(id);
		setMemberEmail(memberEmail); }
	
	public int getId() {
		return id; }

	public void setId(int id) {
		this.id = id; }

	public String getMemberEmail() {
		return memberEmail;	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;	}
	
	public boolean isAlreadyVoted() {
		return (super.getOption() == null); }

	@Override
	public String toString() {
		return "GivenVote [id=" + id + ", memberEmail=" + memberEmail + "]"; } }