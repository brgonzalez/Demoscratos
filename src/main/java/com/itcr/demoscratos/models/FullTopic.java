package com.itcr.demoscratos.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public final class FullTopic extends Topic {
	
	private boolean votable;
	private boolean secret;
	private String question;
	private String source;
	private StringBuffer clauses;
	private ArrayList<String> participants = new ArrayList<String>();
	private ArrayList<String> upvotes = new ArrayList<String>();
	private ArrayList<String> downvotes = new ArrayList<String>();
	private ArrayList<String> abstentions = new ArrayList<String>();
	private ArrayList<Option> options = new ArrayList<Option>();
	private ArrayList<Vote> votes = new ArrayList<Vote>();

	public FullTopic(JSONObject json, boolean secret, String type) {
		super(json, type);
		setVotable(json.getBoolean("votable"));
		setSource(json.getString("source"));
		setClauses(json.getJSONArray("clauses"));
		setParticipants(json.getJSONArray("participants"));
		setUpvotes(json.getJSONArray("upvotes"));
		setDownvotes(json.getJSONArray("downvotes"));
		setAbstentions(json.getJSONArray("abstentions"));
		setSecret(secret); setType(type); }

	public boolean isVotable() {
		return votable; }

	private void setVotable(boolean votable) {
		this.votable = votable; }
	
	public boolean isSecret() {
		return secret; }

	private void setSecret(boolean secret) {
		this.secret = secret; }
	
	public String getQuestion() {
		return question; }

	public void setQuestion(String question) {
		this.question = question; }

	public String getSource() {
		return source; }

	private void setSource(String source) {
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
	
	public ArrayList<Option> getOptions() {
		return options;	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;	}
	
	public ArrayList<Vote> getVote() {
		return votes;	}

	public void setVotes(ArrayList<Vote> votes) {
		this.votes = votes;	}
	
	public boolean userAlreadyVoted (String email) {
		if (votes.isEmpty()) { return false; }
		
		for (Vote vote : votes) {
			if (vote.getEmail().equals(email)) {
				return true; } }
		
		return false; }

	@Override
	public String toString() {
		return super.toString()
				+ "FullTopic [votable=" + votable + ", secret=" + secret + ", question=" + question + ", source=" + source
				+ ", clauses=" + clauses + ", participants=" + participants + ", upvotes=" + upvotes + ", downvotes="
				+ downvotes + ", abstentions=" + abstentions + ", options=" + options + ", votes=" + votes + "]"; } }