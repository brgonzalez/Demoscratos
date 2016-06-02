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
import com.itcr.demoscratos.services.Messages;

@Controller
public class LoginController {
	
	private Messages messages = new Messages();
	private RequestController request = RequestController.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logedIn(Locale locale, Model model) {
		if(request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/forums";
		}
		model.addAttribute("errorLogin", "none");
		logger.info(messages.getLogin(), locale);
		return "login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Locale locale, Model model) {
		if(request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/forums";
		}
		logger.info(messages.getSignUp(), locale);
		return "signup";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale,Model model, @RequestParam("email") String email,@RequestParam("password") String password) {
		request.signIn(email, password);
		if(request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/forums";
		}
		model.addAttribute("errorLogin", "block");

		logger.info(messages.errorAuth(), locale);
		return "login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignUp(Locale locale,
			@RequestParam("email") String email,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("password") String password) {
		request.signIn(email, password);
		request.signUp(email, firstName, lastName, password);
		logger.info(messages.userRegistered(), locale);
		return "redirect:login";
	}
	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	public String signOut(Locale locale, Model model) {
		request.signOut();
		return "redirect:/login";
	}
}