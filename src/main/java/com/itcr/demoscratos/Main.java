package com.itcr.demoscratos;

import java.util.ArrayList;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		// Ejemplo:
		RequestController rc = new RequestController();
		rc.signIn("brarigoch@gmail.com", "12345678");
		rc.postNegativeVote("573ab500c7eba5847691f1d1"); } }