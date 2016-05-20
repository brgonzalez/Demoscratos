package com.itcr.demoscratos;

import java.util.ArrayList;
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
import com.itcr.demoscratos.services.Messages;


@Controller
public class RingController {
	
	private Messages messages = new Messages();
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);
	private RequestController request =  RequestController.getInstance();

	@RequestMapping(value = "/settings-ring", method = RequestMethod.GET)
	public String settingsPerfil(Locale locale, Model model) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		ArrayList<User> members = request.getRing();
		if(members.size() > 0){
			model.addAttribute("member1", members.get(0));
			model.addAttribute("member2",  members.get(1) );
			model.addAttribute("member3",  members.get(2) );
			model.addAttribute("displayButton", "none" );
			//model.addAttribute("displayShow-ring", "none" );*/
		}
		else{
			model.addAttribute("displayButton", "block" );
			model.addAttribute("sring", "none" );
		}
		logger.info(messages.getRing(), locale);
		return "settings-ring";
	}
	
	@RequestMapping(value = "/settings-ring", method = RequestMethod.POST)
	public String modifyRing(Locale locale,Model model,
			@RequestParam("emailMember1") String emailMember1 ,
			@RequestParam("emailMember2") String emailMember2,
			@RequestParam("emailMember3") String emailMember3) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		try{
			request.postRing(emailMember1, emailMember2, emailMember3);

		}catch(RuntimeException e ){
			e.getMessage();
		}
		finally{
			
		}
		ArrayList<User> members = request.getRing();
		if(members.size() > 0){
			model.addAttribute("displayButton", "none" );
			model.addAttribute("member1", members.get(0));
			model.addAttribute("member2",  members.get(1) );
			model.addAttribute("member3",  members.get(2) );
		}
		logger.info(messages.updatedRing(), locale);
		return "settings-ring";
	}
}
	