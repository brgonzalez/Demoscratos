package com.itcr.demoscratos;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.User;

@Controller
public class PasswordController {
	
	private Messages messages = new Messages();
	private RequestController request =  RequestController.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);

	@RequestMapping(value = "/settings-password", method = RequestMethod.GET)
	public String getPassword(Locale locale, Model model) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user);
		logger.info(messages.getChangePassword(), locale);
		return "settings-password";
	}
	
	@RequestMapping(value = "/settings-password", method = RequestMethod.POST)
	public String modifyPassword(Locale locale,
			@RequestParam("currentPassword") String currentPassword ,
			@RequestParam("newPassword") String newPassword, Model model) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		logger.info(messages.updatedPassword(), locale);

		User user = request.getCurrentUser();
		model.addAttribute("user", user);
		request.postPassword(currentPassword, newPassword);
				
		logger.info(messages.updatedPassword(), locale);
		return "settings-password";
	}

}
