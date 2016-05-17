package com.itcr.demoscratos;

import java.util.ArrayList;

import com.itcr.demoscratos.api.RequestController;

public abstract class Main {

	public Main() {	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		// Ejemplo:
		RequestController rc = new RequestController();
		rc.signIn("kenny@mail.com", "123456789");
		ArrayList<String> options = new ArrayList<String>();
		String idForum = "5714763e52cded882d511e46";
		String title = "Prueba de tema";
		String closingAt = "2016-07-30T10:00:00.000Z";
		String source = "http://www.webmail.net/";
		String content = "contenido del tema...";
		String tag = "Internet";
		String question = "¿Pregunta?";
		boolean multiple = false; 
		boolean secret = true;
		
		options.add("Opción 1");
		options.add("Opción 2");
		options.add("Opción 3");
		
		String idTopic = rc.postTopic(idForum, title, tag, closingAt, source, content, multiple, secret, question, options); 
		System.out.println(rc.getFullTopic(idTopic)); } }