package org.demoscratos;

import org.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		RequestController request = new RequestController("cherif@linuxmail.org", "Ccarvajal1090");	
		request.deleteForum("christian"); } }
