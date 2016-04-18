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
import com.itcr.demoscratos.models.Topic;
@Controller
public class TopicController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	private RequestController request = new RequestController("brarigoch@gmail.com","12345678");
	@RequestMapping(value = "/forum/topics", method = RequestMethod.GET)
	public String topics(Locale locale, Model model) {
		/*
		String id ="57092bb2b732ab3e1f533d4a";
		logger.info("Welcome home! The client locale is {}.", locale);
		
		if(request.isLogIn()){
			ArrayList<Topic> topics = request.getTopics(id);
			model.addAttribute("topics", topics );
			logger.info("El usuario está activo. \n forums:"+request.getForums().toString(), locale);

		}
*/
		return "topics";
	}

}
