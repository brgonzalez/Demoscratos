package com.itcr.demoscratos.models;

import java.util.ArrayList;

import org.json.JSONObject;

public class Forums {
	
	private ArrayList<Forum> forums = new ArrayList<Forum>();
	
	public Forums(ArrayList<Forum> forums) { 
		
		this.forums = forums;
	}
	
	public ArrayList<Forum> getForums(){
		return forums;
		
	}

}
