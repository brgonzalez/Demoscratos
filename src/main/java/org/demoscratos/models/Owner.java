package org.demoscratos.models;

public final class Owner {

	private String _id;
	private String email;
	private String firstName;
	private String lastName;
	private String locale;
	private int __v;
	private Notification notifications;
	private String createdAt;
	private boolean emailValidated;
	private String avatar;
	private boolean staff;
	private String displayName;
	private String fullName;
	private String id;
	
	public String get_id() {
		return _id; }
	
	public void set_id(String _id) {
		this._id = _id; }
	
	public String getEmail() {
		return email; }
	
	public void setEmail(String email) {
		this.email = email; }
	
	public String getFirstName() {
		return firstName; }
	
	public void setFirstName(String firstName) {
		this.firstName = firstName; }
	
	public String getLastName() {
		return lastName; }
	
	public void setLastName(String lastName) {
		this.lastName = lastName; }
	
	public String getLocale() {
		return locale; }
	
	public void setLocale(String locale) {
		this.locale = locale; }
	
	public int get__v() {
		return __v; }
	
	public void set__v(int __v) {
		this.__v = __v; }
	
	public Notification getNotifications() {
		return notifications; }
	
	public void setNotifications(Notification notifications) {
		this.notifications = notifications; }
	
	public String getCreatedAt() {
		return createdAt; }
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt; }
	
	public boolean isEmailValidated() {
		return emailValidated; }
	
	public void setEmailValidated(boolean emailValidated) {
		this.emailValidated = emailValidated; }
	
	public String getAvatar() {
		return avatar; }
	
	public void setAvatar(String avatar) {
		this.avatar = avatar; }
	
	public boolean isStaff() {
		return staff; }
	
	public void setStaff(boolean staff) {
		this.staff = staff; }
	
	public String getDisplayName() {
		return displayName; }
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName; }
	
	public String getFullName() {
		return fullName; }
	
	public void setFullName(String fullName) {
		this.fullName = fullName; }
	
	public String getId() {
		return id; }
	
	public void setId(String id) {
		this.id = id; }

	@Override
	public String toString() {
		return "Owner [_id=" + _id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", locale=" + locale + ", __v=" + __v + ", notifications=" + notifications + ", createdAt="
				+ createdAt + ", emailValidated=" + emailValidated + ", avatar=" + avatar + ", staff=" + staff
				+ ", displayName=" + displayName + ", fullName=" + fullName + ", id=" + id + "]"; }
}