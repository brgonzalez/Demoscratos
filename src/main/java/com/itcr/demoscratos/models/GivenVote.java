package com.itcr.demoscratos.models;

public final class GivenVote extends Vote {
	
	private String memberEmail;

	public GivenVote(Option option, String userEmail, String memberEmail) {
		super(option, userEmail);
		setMemberEmail(memberEmail); }

	public String getMemberEmail() {
		return memberEmail;	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;	}
	
	public boolean isAlreadyVoted() {
		return (super.getOption() == null); }

	@Override
	public String toString() {
		return super.toString() + "GivenVote [memberEmail=" + memberEmail + "]"; } }
