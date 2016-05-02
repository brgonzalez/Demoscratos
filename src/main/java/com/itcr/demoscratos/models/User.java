package com.itcr.demoscratos.models;

import org.json.JSONObject;

public final class User {
	
	private String id;
	private String email;
	private String name;
	private String lastName;
	private String avatar;

	public User(JSONObject json, String email) {
		setId(json.getString("id"));
		setEmail(email);
		String[] fullName = json.getString("displayName").split(" ");
		setName(fullName[0]);
		setLastName(fullName[1]);
		setAvatar(json.getString("avatar")); }

	public String getId() {
		return id; }

	public void setId(String id) {
		this.id = id; }

	public String getEmail() {
		return email; }

	public void setEmail(String email) {
		this.email = email; }

	public String getName() {
		return name; }

	public void setName(String name) {
		this.name = name; }
	
	public String getLastName() {
		return lastName; }

	public void setLastName(String lastName) {
		this.lastName = lastName; }

	public String getAvatar() {
		return avatar; }

	public void setAvatar(String avatar) {
		this.avatar = avatar; }

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", lastName=" + lastName + ", avatar=" + avatar + "]"; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; }
		if (obj == null) {
			return false; }
		if (getClass() != obj.getClass()) {
			return false; }
		User other = (User) obj;
		if (id == null) {
			if (other.id != null) {
				return false; } }
		else if (!id.equals(other.id)) {
			return false; }
		return true; } }