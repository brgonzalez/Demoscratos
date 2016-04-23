package com.itcr.demoscratos;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ForumsController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	private RequestController request = new RequestController("brarigoch@gmail.com","12345678");
	@RequestMapping(value = "/forums" , method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Obteniedo forums", locale);
		
		if(request.isLoggedIn()){
			ArrayList<Forum> forums = request.getForums();
			
			model.addAttribute("forums", forums );
			logger.info("El usuario está activo. \n forums:"+request.getForums().toString(), locale);
			return "forums";
			

		}

		return "login";
	}
	
	@RequestMapping(value = "/forums" , method = RequestMethod.POST)
	public String forumsPost(Locale locale, Model model) {
		logger.info("Obteniedo forums", locale);
		
		if(request.isLoggedIn()){
			ArrayList<Forum> forums = request.getForums();
			
			model.addAttribute("forums", forums );
			logger.info("El usuario está activo. \n forums:"+request.getForums().toString(), locale);
			return "forums";

		}

		return "login";
	}
	



	
	

}
