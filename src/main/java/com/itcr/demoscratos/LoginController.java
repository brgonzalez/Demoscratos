package com.itcr.demoscratos;

import org.springframework.stereotype.Controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcr.demoscratos.api.RequestController;

@Controller
public class LoginController {
	
	private RequestController request = RequestController.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logedIn(Locale locale, Model model) {
		if(request.isLoggedIn()){
			logger.info("Usuario se encuentra logueado", locale);
			return "redirect:/forums";
		}
		logger.info("Usuario no se encuentra logueado", locale);
		return "login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Locale locale, Model model) {
		if(request.isLoggedIn()){
			logger.info("Usuario se encuentra logueado", locale);
			return "redirect:/forums";
		}
		logger.info("Proceso de registro", locale);
		return "signup";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale,@RequestParam("email") String email,@RequestParam("password") String password) {
		logger.info("Se esta intentando hacer login.", locale);
		request.signIn(email, password);
		if(request.isLoggedIn()){
			logger.info("El usuario se ha logueado", locale);
			return "redirect:/forums";
		}
		logger.info("El usuario no se ha podido autentificar", locale);
		return "login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignUp(Locale locale,
			@RequestParam("email") String email,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("password") String password) {
		logger.info("Se esta intentando hacer signUp.", locale);
		request.signIn(email, password);
		request.signUp(email, firstName, lastName, password);
		logger.info("Se ha registrado", locale);
		return "login";
	}
	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	public String signOut(Locale locale, Model model) {
		request.signOut();
		return "redirect:/login";
	}
}