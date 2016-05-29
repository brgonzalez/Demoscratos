package com.itcr.demoscratos.services;

public class Messages {
	
	public String voted(){
		return "Ya has realizado el voto";
	}
	public String userLoggedIn(){
		return "El usuario no está autentificado";
	}
	
	public String login(){
		return "Usuario conectado";
	}
	
	public String userRegistered(){
		return "Usuario se ha registrado";
	}
	
	public String signOut(){
		return "El usuario desconectado";
	}
	
	public String errorAuth(){
		return "Error en autentificación de usuario";
	}
	
	public String userNoAuth(){
		return "Usuario no autentificado";
	}
	
	public String getLogin(){
		return "Proceso de autentificación";
	}
	
	public String userSignedUp(){
		return "Proceso de autentificación";
	}
	
	public String getSignUp(){
		return "Proceso de registro";
	}
	
	public String getForums(){
		return "Obtención de democracias";
	}
	
	public String getTopics(){
		return "Obtención de temas";
	}
	
	public String getForum(String key){
		return "obtención de democracia con clave "+key;
	}
	
	public String getProfile(){
		return "Obtención de perfil";
	}
	
	public String updatedProfile(){
		return "Perfil actualizado";
	}
	
	public String getRing(){
		return "Obtención de democracias";
	}
	
	public String ringNull(){
		return "Usuario no posee anillo";
	}
	
	public String updatedRing(){
		return "Anillo actualizado";
	}
	
	public String getChangePassword(){
		return "Proceso de cambio de contraseña";
	}
	
	public String updatedPassword(){
		return "Contraseña actualizada";
	}
	
}
