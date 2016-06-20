package com.itcr.demoscratos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Option;
import com.itcr.demoscratos.models.Tag;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;
import com.itcr.demoscratos.models.VisibleVote;
import com.itcr.demoscratos.models.Vote;
import com.itcr.demoscratos.services.MessagesService;
import com.itcr.demoscratos.services.DateService;
import com.itcr.demoscratos.services.EmailService;

@Controller
public class TopicsController {
		
	private MessagesService messages = new MessagesService();
	private static final Logger logger = LoggerFactory.getLogger(TopicsController.class);
	private RequestController request = RequestController.getInstance();

	
	@RequestMapping(value = "forum/{key} " , method = RequestMethod.GET)
	public String displayTopiscForum(Locale locale, Model model,@PathVariable(value="key") String key) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		ArrayList<Topic> topics = request.getTopics(key);
		model.addAttribute("idForum",key);
		if(topics.size() > 0){
			for(Topic topic : topics){
				
				DateService serviceDate = new DateService();
				if(serviceDate.isClose((String) topic.getClosingAt())){
					topic.setClosingAt("Cerrado");
				}
				else{
					topic.setClosingAt(serviceDate.getCloseDate((String) topic.getClosingAt()));
				}
			}
			model.addAttribute("topics",topics);
		}
		logger.info(messages.getForum(key), locale);
		return "topics";
	}
	

	@RequestMapping(value = "forum/{idForum}/topic/new" , method = RequestMethod.GET)
	public String newTopic(Locale locale, Model model,@PathVariable(value="idForum") String idForum) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		model.addAttribute("idForum", idForum);
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		
		model.addAttribute("errorDate", "none");
		model.addAttribute("successNewTopic", "none");

		
		ArrayList<Tag> tags = request.getTags();
		model.addAttribute("tags",tags);
		return "new-topic";
	}
	
	@RequestMapping(value = "forum/{idForum}/topic/new" , method = RequestMethod.POST)
	public String postNewTopic(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="title") String title,
			@RequestParam(value="tag") String tag,
			@RequestParam(value="content") String content,
			@RequestParam(value="source") String source,
			@RequestParam(value="votable",defaultValue = "false") String votablex,
			@RequestParam(value="secret",defaultValue = "false") String secretx,
			@RequestParam(value="semiPublic",defaultValue = "false") String semipublicx,
			@RequestParam(value="simple",defaultValue = "false") String simplex,
			@RequestParam(value="selection",defaultValue = "false") String selectionx,
			@RequestParam(value="multiselection",defaultValue = "false") String multiselectionx,
			@RequestParam(value="question") String question,
			@RequestParam(value="closingAt") String closingAt,
			@RequestParam(value="optionsQuestion[]") ArrayList<String> options) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		ArrayList<Tag> tags = request.getTags();
		model.addAttribute("tags",tags);
		
		content = content.replaceAll("[\n\r]", " ");
		
		model.addAttribute("idForum", idForum);
		System.out.println(question);
		
		boolean simple = Boolean.valueOf(simplex);
		boolean votable = Boolean.valueOf(votablex);
		boolean secret = Boolean.valueOf(secretx);
		boolean multiple = Boolean.valueOf(multiselectionx);

		String[] splitDate = closingAt.split(" ");
		closingAt = splitDate[0]+"T"+splitDate[1]+".000Z";
		
		DateService serviceDate = new DateService();
		
		if(serviceDate.isClose(closingAt)){
			model.addAttribute("errorDate", "block");
			model.addAttribute("successNewTopic", "none");

			return "new-topic";
		}
		
		if(votable){ 
			if(!simple){
				request.postTopic(idForum, title, tag, closingAt, source, content, 
						multiple, secret, question, options);
			}
			else{
				request.postTopic(idForum, title, tag, closingAt, source, content, votable, secret);
			}
		}else{
			request.postTopic(idForum, title, tag, closingAt, source, content, votable, secret);
		}
		
		List<Forum> forums = request.getForums();
		String forumName =null;
		for(Forum forum : forums){
			if (forum.getId().equals(idForum)){
				forumName = forum.getTitle();
				break;
			}
		}
		
		
		EmailService emailService = new EmailService();
		emailService.sendEmail("brgonzalezcr@gmail.com", request.getCurrentUser().getEmail(), forumName, title);
		
		model.addAttribute("errorDate", "none");
		model.addAttribute("successNewTopic", "block");

		return "new-topic";
	}
}