package com.itcr.demoscratos;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.User;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		RequestController request = new RequestController();
		request.signIn("brarigoch@gmail.com", "12345678");
		User u = request.getUserByEmail("brarigoch@gmail.com");
		System.out.println(u);
		
	} 
}
