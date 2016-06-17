package com.itcr.demoscratos;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		System.out.println("Hello World!");	
		RequestController request = RequestController.getInstance();
		/*request.signUp("brgonzalezcr@gmail.com", "admin", "admin", "12345678");
		request.signUp("brarigoch@gmail.com", "Brayan", "González", "12345678");
		request.signUp("kmoragas@gmail.com", "Kevin", "Moraga", "12345678");
		request.signUp("enrique.jimenez94@gmail.com", "Enrique", "Jimémez", "12345678");
		request.signUp("andres.chaves78@gmail.com", "Andrés", "Chaves", "12345678");*/
		request.signUp("alvaradof620@gmail.com	", "Fernanda", "Alvarado", "12345678");


	
	}
}