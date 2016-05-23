package com.itcr.demoscratos.models;

public final class TotalVotes {
	
	private Option option;
	private int total;
	
	public TotalVotes(Option option, int total) {
		setOption(option); setTotal(total); }
	
	public Option getOption() {
		return option; }
	
	public void setOption(Option option) {
		this.option = option; }
	
	public int getTotal() {
		return total; }
	
	public void setTotal(int total) {
		this.total = total; }

	@Override
	public String toString() {
		return "TotalVotes [option=" + option.toString() + ", total=" + total + "]"; } }
