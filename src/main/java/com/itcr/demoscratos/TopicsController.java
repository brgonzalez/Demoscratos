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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;


/**
 * Handles requests for the application home page.
 */
@Controller
public class TopicsController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	private RequestController request = new RequestController("brarigoch@gmail.com","12345678");


	@RequestMapping(value = "/topics", method = RequestMethod.GET)
	public String topics(Locale locale, Model model) {
		
		logger.info("Obteniendo temas de una democracia.", locale);
		
		

		return "topics";
	}
	
	@RequestMapping(value = "forums/{key}" , method = RequestMethod.GET)
	public String displayTopiscForum(Locale locale, Model model,@PathVariable(value="key") String key) {
		logger.info("El key es topic "+ key, locale);
		
		ArrayList<Topic> topics = request.getTopics(key);
		
		if(topics.size() > 0){
			model.addAttribute("topics",topics);
		}

		
		//model.addAttribute("topics", topics);
		
		return "topics";
	}
	
	@RequestMapping(value = "forums/topic/{key}" , method = RequestMethod.GET)
	public String showTopic(Locale locale, Model model,@PathVariable(value="key") String key) {
		logger.info("Show topic "+ key, locale);

		
		//model.addAttribute("topics", topics);
		
		return "showTopic";
	}

}