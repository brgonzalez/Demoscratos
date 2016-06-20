package com.itcr.demoscratos;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		System.out.println("Hello World!");	
		RequestController request = RequestController.getInstance();
		request.signUp("brgonzalezcr@gmail.com", "admin", "admin", "12345678");
		request.signUp("brarigoch@gmail.com", "Brayan", "González", "12345678");
		request.signUp("kmoragas@gmail.com", "Kevin", "Moraga", "12345678");
		request.signUp("enrique.chaves94@gmail.com", "Enrique", "Chaves", "12345678");
		request.signUp("andrey.chaves78@gmail.com", "Andrey", "Chaves", "12345678");
		request.signUp("alvaradof620@gmail.com	", "Fernanda", "Alvarado", "12345678");
		request.signUp("fernando.salazar67@gmail.com", "Fernando", "Salazar", "12345678");
		request.signUp("melisa.alfaro48@gmail.com", "Melisa", "Alfaro", "12345678");
		request.signUp("randall.chaves68@gmail.com", "Randall", "Chaves", "12345678");
		request.signUp("marco.chaves@gmail.com", "Marco", "Chaves", "12345678");

	
	}
}