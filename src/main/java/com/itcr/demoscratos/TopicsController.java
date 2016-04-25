package com.itcr.demoscratos;

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
import com.itcr.demoscratos.models.Topic;

@Controller
public class TopicsController {
		
	private static final Logger logger = LoggerFactory.getLogger(ForumsController.class);
	private RequestController request = RequestController.getInstance();

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
		return "privateTopic";
	}
	
	@RequestMapping(value = "forums/topic/{key}" , method = RequestMethod.GET)
	public String showTopic(Locale locale, Model model,@PathVariable(value="key") String key) {
		logger.info("Show topic "+ key, locale);
		//model.addAttribute("topics", topics);
		return "showTopic";
	}
	
	@RequestMapping(value = "forums/topic/new}" , method = RequestMethod.GET)
	public String newTopic(Locale locale, Model model,@PathVariable(value="key") String key) {
		logger.info("Show topic "+ key, locale);
		//model.addAttribute("topics", topics);
		return "showTopic";
	}
}