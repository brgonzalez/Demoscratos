package com.itcr.demoscratos;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.User;

@Controller
public class ForumsController {
	
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);
	
	private RequestController request = RequestController.getInstance();
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Página princial", locale);
		
		if(request.isLoggedIn()){
			
			User user = request.getCurrentUser();
			model.addAttribute("user", user );
			
			ArrayList<Forum> forums = request.getForums();
			
			model.addAttribute("forums", forums );
			logger.info("El usuario está activo. \n forums:"+request.getForums().toString(), locale);
			return "forums";
		}
		logger.info("El usuario no se encuentra logueado", locale);

		return "redirect:/login";
	}
	@RequestMapping(value = "/forums" , method = RequestMethod.GET)
	public String homeForums(Locale locale, Model model) {
		logger.info("Página princial", locale);
		
		if(request.isLoggedIn()){

			
			User user = request.getCurrentUser();
			System.out.println(request.getUserByEmail("brarigoch@gmail.com"));
			model.addAttribute("user", user );
			
			ArrayList<Forum> forums = request.getForums();
			
			model.addAttribute("forums", forums );
			logger.info("El usuario está activo. \n forums:"+request.getForums().toString(), locale);
			return "forums";
		}
		logger.info("El usuario no se encuentra logueado", locale);

		return "redirect:/login";
	}
	
	@RequestMapping(value = "/forums" , method = RequestMethod.POST)
	public String forumsPost(Locale locale, Model model) {
		logger.info("Página princial", locale);		
		
		if(request.isLoggedIn()){
			
			ArrayList<Forum> forums = request.getForums();			
			model.addAttribute("forums", forums );
			logger.info("El usuario está activo. \n forums:"+request.getForums().toString(), locale);
			return "forums";
		}
		logger.info("El usuario no se encuentra logueado", locale);

		return "redirect:/login";
	}
}