package com.itcr.demoscratos;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		RequestController request = new RequestController("cherif@linuxmail.org", "Ccarvajal1090");
		System.out.println(request.isLogIn()); } }
