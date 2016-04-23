package com.itcr.demoscratos;

import org.springframework.stereotype.Controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itcr.demoscratos.api.RequestController;

@Controller

public class LoginController {
	
	private RequestController request = new RequestController("brarigoch@gmail.com","12345678");

	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);

	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logedIn(Locale locale, Model model) {

		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale,@RequestParam("email") String email,@RequestParam("password") String password) {
		logger.info("Se esta intentando hacer login.", locale);
		logger.info(email, locale);

		
		if(request.isLoggedIn()){
			logger.info("Usuario se encuentra logueado", locale);

			return "forums";
		}
		logger.info("Usuario no se encuentra logueado", locale);

		return "login";
	}



}
