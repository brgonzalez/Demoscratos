package com.itcr.demoscratos.services;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	
	public void sendEmail(String emailAdmin,String emailUser,String forumName, String topicName){
		
		
		
		 	String msgBody = "Se ha creado un nuevo tema en la democracia "+ forumName+"\n\n"+"El tema se llama "+topicName+"\n\nPara que sea visto por los usuarios se debe de aprobar y publicar";

	         
	        Properties props = new Properties();
	        // Nombre del host de correo, es smtp.gmail.com
	        props.setProperty("mail.smtp.host", "smtp.gmail.com");
	        // TLS si está disponible
	        props.setProperty("mail.smtp.starttls.enable", "true");
	        // Puerto de gmail para envio de correos
	        props.setProperty("mail.smtp.port","587");
	        // Nombre del usuario
	        props.setProperty("mail.smtp.user", "Libreria Virtual");
	        // Si requiere o no usuario y password para conectarse.
	        props.setProperty("mail.smtp.auth", "true");
	         
	        Session session = Session.getDefaultInstance(props);
	        session.setDebug(true);
	 
	        try {
	            Message msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress("noreply@something.com"));
	            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailUser));
	            msg.setSubject("Compra realizada");
	            msg.setText(msgBody);
	            Transport t = session.getTransport("smtp");
	            t.connect("libreriavirtuallv@gmail.com","ventadelibros");
	            t.sendMessage(msg, msg.getAllRecipients());
	 
	        } catch (AddressException e) {
	            e.printStackTrace();
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	}
}
