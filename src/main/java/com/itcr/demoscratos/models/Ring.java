package com.itcr.demoscratos.models;

public final class Ring {
	
	private String user;
	private String member1;
	private String member2;
	private String member3;	

	public Ring(String user, String member1, String member2, String member3) {
		setUser(user); setMember1(member1);
		setMember2(member2); setMember3(member3);	}

	public String getUser() {
		return user; }

	public void setUser(String user) {
		this.user = user; }

	public String getMember1() {
		return member1; }

	public void setMember1(String member1) {
		this.member1 = member1; }

	public String getMember2() {
		return member2; }

	public void setMember2(String member2) {
		this.member2 = member2; }

	public String getMember3() {
		return member3; }

	public void setMember3(String member3) {
		this.member3 = member3; }

	@Override
	public String toString() {
		return "Ring [user=" + user + ", member1=" + member1 + ", member2=" + member2 + ", member3=" + member3 + "]"; } }