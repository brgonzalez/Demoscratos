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
	private User currentUser;
	private ArrayList<String> participants = new ArrayList<String>();
	private ArrayList<String> upvotes = new ArrayList<String>();
	private ArrayList<String> downvotes = new ArrayList<String>();
	private ArrayList<String> abstentions = new ArrayList<String>();
	private ArrayList<User> ringMembers = new ArrayList<User>();
	private ArrayList<Option> options = new ArrayList<Option>();
	private ArrayList<Vote> votes = new ArrayList<Vote>();
	private ArrayList<GivenVote> givenVotes = new ArrayList<GivenVote>();

	public FullTopic(JSONObject json, boolean secret, String type, User currentUser, ArrayList<GivenVote> givenVotes) {
		super(json, type);
		setVotable(json.getBoolean("votable"));
		setSource(json.getString("source"));
		setClauses(json.getJSONArray("clauses"));
		setParticipants(json.getJSONArray("participants"));
		setUpvotes(json.getJSONArray("upvotes"));
		setDownvotes(json.getJSONArray("downvotes"));
		setAbstentions(json.getJSONArray("abstentions"));
		setSecret(secret); setType(type);
		setCurrentUser(currentUser); setGivenVotes(givenVotes); }
	
	public Report getReportSimple() {
		int totalParticipants = participants.size();
		Option optionPositive = new Option(1, super.getId(), "positivo");
		Option optionNegative = new Option(2, super.getId(), "negativo");
		Option optionAbstention = new Option(3, super.getId(), "abstención");
		TotalVotes totalPositive = new TotalVotes(optionPositive, upvotes.size());
		TotalVotes totalNegative = new TotalVotes(optionNegative, downvotes.size());
		TotalVotes totalAbstention = new TotalVotes(optionAbstention, abstentions.size());
		ArrayList<TotalVotes> totalVotes = new ArrayList<TotalVotes>();
		totalVotes.add(totalPositive);
		totalVotes.add(totalNegative);
		totalVotes.add(totalAbstention);
		return new Report(totalParticipants, totalVotes); }

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

	private void setCurrentUser(User currentUser) {
		this.currentUser = currentUser; }

	private void setParticipants(JSONArray participants) {
		this.participants.clear();
		for (int index = 0; index < participants.length(); index ++) {
			this.participants.add(participants.get(index).toString()); } }

	private void setUpvotes(JSONArray upvotes) {
		this.upvotes.clear();
		for (int index = 0; index < upvotes.length(); index ++) {
			this.upvotes.add(upvotes.get(index).toString()); } }

	private void setDownvotes(JSONArray downvotes) {
		this.downvotes.clear();
		for (int index = 0; index < downvotes.length(); index ++) {
			this.downvotes.add(downvotes.get(index).toString()); } }

	private void setAbstentions(JSONArray abstentions) {
		this.abstentions.clear();
		for (int index = 0; index < abstentions.length(); index ++) {
			this.abstentions.add(abstentions.get(index).toString()); } }

	public void setRingMembers(ArrayList<User> ringMembers) {
		this.ringMembers = ringMembers;	}

	public ArrayList<Option> getOptions() {
		return options;	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;	}

	public void setVotes(ArrayList<Vote> votes) {
		this.votes = votes;	}
	
	public ArrayList<GivenVote> getGivenVotes() {
		return givenVotes; }

	private void setGivenVotes(ArrayList<GivenVote> givenVotes) {
		this.givenVotes = givenVotes; }

	private boolean userAlreadyVotedSimple() {
		return participants.contains(currentUser.getId()); }
	
	private boolean userAlreadyVotedUnique() {
		for (Vote vote: votes) {
			if (vote.getUserEmail().equals(currentUser.getEmail())) {
				return true; } }
		return false; }
	
	public boolean userAlreadyVoted(int option) {
		for (Vote vote: votes) {
			if ( (vote.getUserEmail().equals(currentUser.getEmail()))
					&& (vote.getOption().getId() == option)) {
				return true; } }
		return false; }
	
	public boolean userAlreadyVoted() {
		if (super.getType().equals("simple")) {
			System.out.println("Es simple");
			return userAlreadyVotedSimple(); }
		else {
			return userAlreadyVotedUnique(); } }
	
	private ArrayList<VisibleVote> getVisibleVotesSimple() {
		ArrayList<VisibleVote> votes = new ArrayList<VisibleVote>();
		Option option;
		System.out.println("Ring desde getVisibles Full topic "+ringMembers); 
		for (User user : ringMembers) {
			if (upvotes.contains(user.getId())) {
				option = new Option(1, super.getId(), "positivo");
				votes.add(new VisibleVote(option, user)); }
			else if (downvotes.contains(user.getId())) {
				option = new Option(2, super.getId(), "negativo");
				votes.add(new VisibleVote(option, user)); }
			else if (abstentions.contains(user.getId())) {
				option = new Option(3, super.getId(), "abstención");
				votes.add(new VisibleVote(option, user)); } }
		return votes; }
	
	private ArrayList<VisibleVote> getVisibleVotesOther() {
		ArrayList<VisibleVote> vvotes = new ArrayList<VisibleVote>();
		Option option;
		for (User user : ringMembers) {
			for (Vote vote : votes) {
				if (vote.getUserEmail().equals(user.getEmail())) {
					option = vote.getOption();
					vvotes.add(new VisibleVote(option, user)); } } } 
		return vvotes; }
	
	public ArrayList<VisibleVote> getVisibleVotes() {
		if (!secret) { 
			if (super.getType().equals("simple")) {
				return getVisibleVotesSimple(); }
			else {
				return getVisibleVotesOther(); } }
		else {
			System.err.println("No es posible obtener los votos puesto que el tema es secreto");
			return new ArrayList<VisibleVote>(); } }

	@Override
	public String toString() {
		return super.toString()
				+ "FullTopic [votable=" + votable + ", secret=" + secret + ", question=" + question + ", source=" + source
				+ ", clauses=" + clauses + ", currentUser=" + currentUser + ", participants=" + participants
				+ ", upvotes=" + upvotes + ", downvotes=" + downvotes + ", abstentions=" + abstentions
				+ ", ringMembers=" + ringMembers + ", options=" + options + ", votes=" + votes + "]"; } }