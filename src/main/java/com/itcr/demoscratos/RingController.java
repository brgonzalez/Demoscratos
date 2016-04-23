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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.User;


/**
 * Handles requests for the application home page.
 */
@Controller
public class RingController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	private RequestController request = new RequestController("brarigoch@gmail.com","12345678");


	@RequestMapping(value = "/settings-ring", method = RequestMethod.GET)
	public String settingsPerfil(Locale locale, Model model) {
		
		logger.info("Obteniendo settings-ring.", locale);
		String none = "none";
		String block ="block";
		
		ArrayList<User> members = request.getRing();
		if(members.size() > 0){
			model.addAttribute("member1", members.get(0));
			model.addAttribute("member2",  members.get(1) );
			model.addAttribute("member3",  members.get(2) );
			/*
			model.addAttribute("displayButton", "none" );
			model.addAttribute("displayShow-ring", "none" );*/
		}
		else{
			model.addAttribute("displayButton", block );
			model.addAttribute("displayShow-ring", none );
		}
		return "settings-ring";
	}
	
	@RequestMapping(value = "/settings-ring", method = RequestMethod.POST)
	public String modifyRing(Locale locale,
			@RequestParam("emailMember1") String emailMember1 ,
			@RequestParam("emailMember2") String emailMember2,
			@RequestParam("emailMember3") String emailMember3) {
		logger.info("Petición de modificación de anillo", locale);

		request.postRing(emailMember1, emailMember2, emailMember3);
		
		logger.info("Se ha modificado el anido", locale);


		return "settings-ring";
	}
}
	