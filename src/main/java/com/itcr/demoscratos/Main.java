package com.itcr.demoscratos;

import java.util.ArrayList;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.FullTopic;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		// Ejemplo:
		RequestController rc = new RequestController();
		rc.signIn("alvaradof620@gmail.com", "12345678");
		FullTopic t =rc.getFullTopic("57408751566b08414b1c4bf4");




	}
}