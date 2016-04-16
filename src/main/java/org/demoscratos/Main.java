package org.demoscratos;

import org.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		RequestController request = new RequestController();
		System.out.println(request.getForums().toString()); } }
