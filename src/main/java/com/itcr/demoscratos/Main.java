package com.itcr.demoscratos;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		RequestController request = new RequestController("brarigoch@gmail.com", "12345678");
		System.out.println(request.isLogIn());
		System.out.println(request.getTopics(request.getTopics("57092bb2b732ab3e1f533d4a").toString()));
		
	} 
}
