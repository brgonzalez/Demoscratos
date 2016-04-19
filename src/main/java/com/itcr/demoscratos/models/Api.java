package com.itcr.demoscratos.models;

public final class Api {
	
	private String app;
	private String version;
	private String apiUrl;
	
	public String getApp() {
		return app; }
	
	public void setApp(String app) {
		this.app = app; }
	
	public String getVersion() {
		return version; }
	
	public void setVersion(String version) {
		this.version = version; }
	
	public String getApiUrl() {
		return apiUrl; }
	
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl; }

	@Override
	public String toString() {
		return "Api [app=" + app + ", version=" + version + ", apiUrl=" + apiUrl + "]"; }
}
