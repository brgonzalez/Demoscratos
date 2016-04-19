package com.itcr.demoscratos;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		RequestController request = new RequestController("brarigoch@gmail.com", "12345678");
		System.out.println(request.isLoggedIn());
		
	} 
}
