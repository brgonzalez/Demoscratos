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
import com.itcr.demoscratos.models.User;

@Controller
public class ProfileController {
	
	private Messages messages = new Messages();
	private RequestController request =  RequestController.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);

	@RequestMapping(value = "/settings-profile", method = RequestMethod.GET)
	public String getProfile(Locale locale, Model model) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user);
		logger.info(messages.getProfile(), locale);
		return "settings-profile";
	}
	
	@RequestMapping(value = "/settings-profile", method = RequestMethod.POST)
	public String modifyProfile(Locale locale,
			@RequestParam("name") String name ,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email, Model model) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		request.postProfile(name, lastName, "");
		
		User user = request.getCurrentUser();
		model.addAttribute("user", user);
		
		logger.info(messages.updatedProfile(), locale);
		return "settings-profile";
	}
}