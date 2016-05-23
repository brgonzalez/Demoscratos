package com.itcr.demoscratos.models;

import java.util.ArrayList;

public final class Report {
	
	private int totalParticipants;
	private ArrayList<TotalVotes> totalVotes;
	
	public Report(int totalParticipants, ArrayList<TotalVotes> totalVotes) {
		setTotalParticipants(totalParticipants);
		setTotalVotes(totalVotes); }
	
	public int getTotalParticipants() {
		return totalParticipants; }
	
	public void setTotalParticipants(int totalParticipants) {
		this.totalParticipants = totalParticipants; }
	
	public ArrayList<TotalVotes> getTotalVotes() {
		return totalVotes; }
	
	public void setTotalVotes(ArrayList<TotalVotes> totalVotes) {
		this.totalVotes = totalVotes; }

	@Override
	public String toString() {
		return "Report [totalParticipants=" + totalParticipants + ", totalVotes=" + totalVotes + "]"; } }