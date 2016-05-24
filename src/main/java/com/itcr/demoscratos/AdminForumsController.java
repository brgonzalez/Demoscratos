package com.itcr.demoscratos;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Tag;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;
import com.itcr.demoscratos.models.VisibleVote;
import com.itcr.demoscratos.services.Messages;
import com.itcr.demoscratos.services.ServiceDate;

/*
 * 			Controlador para admin
 */

@Controller 
public class AdminForumsController {
	
	private Messages messages = new Messages();
	private static final Logger logger = LoggerFactory.getLogger(AdminForumsController.class);
	
	private RequestController request = RequestController.getInstance();
		
	@RequestMapping(value = "/admin/forums" , method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		ArrayList<Forum> forums = request.getForums();
		model.addAttribute("forums", forums );
		
		logger.info(messages.getForums(), locale);
		return "admin-forums";
	}
	@RequestMapping(value = "/admin/forum/{idForum} " , method = RequestMethod.GET)
	public String displayTopiscForum(Locale locale, Model model,@PathVariable(value="idForum") String idForum) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		ArrayList<Topic> topics = request.getTopics(idForum);
		model.addAttribute("idForum",idForum);
		if(topics.size() > 0){
			for(Topic topic : topics){
				ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
				if(serviceDate.isClose()){
					topic.setClosingAt("Cerrado");
				}
				else{
					topic.setClosingAt(serviceDate.getCloseDate());
				}
			}
			model.addAttribute("topics",topics);
		}

		return "admin-topics";
	}
	
	@RequestMapping(value = "admin/forum/{idForum}/topic/{idTopic}" , method = RequestMethod.GET)
	public String showTopic(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic
			) throws ParseException {
		logger.info("forum = "+ idForum +", topic = " + idTopic, locale);
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		FullTopic topic = request.getFullTopic(idTopic);
		model.addAttribute("topic", topic );

		ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
		boolean isClosed = serviceDate.isClose();
		
		topic.setClosingAt(serviceDate.getCloseDate());
		
		if(topic.isSecret()){
			model.addAttribute("modality", "Semipúblico");
		}
		else{
			model.addAttribute("modality", "Privado");

		}
		if(topic.getType().equals("simple")){
			model.addAttribute("simple","block");
			model.addAttribute("noSimple","none");
		}
		else{
			model.addAttribute("simple","none");
			model.addAttribute("noSimple","block");
		}

		return "admin-topic";
	}
	
}