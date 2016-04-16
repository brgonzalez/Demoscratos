package org.demoscratos.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public final class FullTopic extends Topic {
	
	private boolean votable;
	private String source;
	private StringBuffer clauses;
	private ArrayList<String> participants = new ArrayList<String>();
	private ArrayList<String> upvotes = new ArrayList<String>();
	private ArrayList<String> downvotes = new ArrayList<String>();
	private ArrayList<String> abstentions = new ArrayList<String>();

	public FullTopic(JSONObject json) {
		super(json);
		setVotable(json.getBoolean("votable"));
		setSource(json.getString("source"));
		setClauses(json.getJSONArray("clauses"));
		setParticipants(json.getJSONArray("participants"));
		setUpvotes(json.getJSONArray("upvotes"));
		setDownvotes(json.getJSONArray("downvotes"));
		setAbstentions(json.getJSONArray("abstentions")); }

	public boolean isVotable() {
		return votable; }

	public void setVotable(boolean votable) {
		this.votable = votable; }

	public String getSource() {
		return source; }

	public void setSource(String source) {
		this.source = source; }
	
	public String getClauses() {
		return clauses.toString(); }

	private void setClauses(JSONArray clauses) {
		this.clauses = new StringBuffer(); JSONObject json;
		for (int index = 0; index < clauses.length(); index ++) {
			json = clauses.getJSONObject(index);
			this.clauses.append(json.getString("markup") + "\n"); } }

	public ArrayList<String> getParticipants() {
		return participants; }

	private void setParticipants(JSONArray participants) {
		this.participants.clear();
		for (int index = 0; index < participants.length(); index ++) {
			this.participants.add(participants.get(index).toString()); } }

	public ArrayList<String> getUpvotes() {
		return upvotes; }

	private void setUpvotes(JSONArray upvotes) {
		this.upvotes.clear();
		for (int index = 0; index < upvotes.length(); index ++) {
			this.upvotes.add(upvotes.get(index).toString()); } }

	public ArrayList<String> getDownvotes() {
		return downvotes; }

	private void setDownvotes(JSONArray downvotes) {
		this.downvotes.clear();
		for (int index = 0; index < downvotes.length(); index ++) {
			this.downvotes.add(downvotes.get(index).toString()); } }

	public ArrayList<String> getAbstentions() {
		return abstentions; }

	private void setAbstentions(JSONArray abstentions) {
		this.abstentions.clear();
		for (int index = 0; index < abstentions.length(); index ++) {
			this.abstentions.add(abstentions.get(index).toString()); } }

	@Override
	public String toString() {
		return "FullTopic [votable=" + votable + ", source=" + source + ", clauses=" + clauses + ", participants="
				+ participants + ", upvotes=" + upvotes + ", downvotes=" + downvotes + ", abstentions=" + abstentions
				+ "]"; } }