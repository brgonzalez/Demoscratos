package com.itcr.demoscratos;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.Forums;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SettingsController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	private RequestController request = new RequestController("brarigoch@gmail.com","12345678");
	@RequestMapping(value = "/settings-profile", method = RequestMethod.GET)
	public String settingsProfile(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		boolean exist = true;
		String none = "none";
		String block ="block";
		if(exist){
			model.addAttribute("displayButton", none );
			model.addAttribute("displayButton", block );
		}
		else{
			model.addAttribute("displayButton", block );
			model.addAttribute("displayButton", none );
		}
		
		
		Object o = new Object();
		model.addAttribute("users", o);
		

		return "settings-profile";
	}
	
	
	
	@RequestMapping(value = "/settings-password", method = RequestMethod.GET)
	public String settingsPassword(Locale locale, Model model) {
		

		return "settings-password";
	}
	
	@RequestMapping(value = "/settings-notification", method = RequestMethod.GET)
	public String settingsNotifications(Locale locale, Model model) {
		

		return "settings-notification";
	}
	
	@RequestMapping(value = "/settings-ring", method = RequestMethod.GET)
	public String settingsPerfil(Locale locale, Model model) {
		

		return "settings-ring";
	}
}
	