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
import org.springframework.web.bind.annotation.RequestParam;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Tag;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;

@Controller
public class TopicsController {
		
	private Messages messages = new Messages();
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
			model.addAttribute("topics",topics);
		}

		logger.info(messages.getForum(key), locale);
		return "topics";
	}
	
	

	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/simple" , method = RequestMethod.GET)
	public String showTopic(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic
			/*@PathVariable(value="typeTopic") String typeTopic*/) {
		logger.info("forum = "+ idForum +", topic = " + idTopic, locale);
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}//******realiozar que se reciba en el URL el tipo del topic y hacer un if)
		FullTopic topic = request.getFullTopic(idTopic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		return "topic-simple";
	}
	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/simple" , method = RequestMethod.POST)
	public String simpleVote(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="vote") String vote,
			@PathVariable(value="idTopic") String idTopic) {
		logger.info(vote, locale); 
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		FullTopic topic = request.getFullTopic(idTopic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
		}
		User user = request.getCurrentUser();
		System.out.println("El voto es :" +vote);
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		switch(vote){
			case "positive":
				request.postPositiveVote(idTopic);
				break;
			case "negative":
				request.postNegativeVote(idTopic);
				break;
			case "abstentionism":
				request.postAbstentionVote(idTopic);
				break;
		}
			
		return "topic-simple";
	}
	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/unique" , method = RequestMethod.GET)
	public String showTopicUnique(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		FullTopic topic = request.getFullTopic(idTopic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
		}
		User user = request.getCurrentUser();
		model.addAttribute("question", topic.getQuestion());
		model.addAttribute("options", topic.getOptions());
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		return "topic-unique";
	}
	
	

	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/unique" , method = RequestMethod.POST)
	public String postVoteUnique(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="idOption") String idOption,
			@PathVariable(value="idTopic") String idTopic) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		FullTopic topic = request.getFullTopic(idTopic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
		}
		User user = request.getCurrentUser();
		model.addAttribute("question", topic.getQuestion());
		model.addAttribute("options", topic.getOptions());
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		request.postUniqueVote(idTopic, Integer.parseInt(idOption));
		return "topic-unique";
	}
	
	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/multiple" , method = RequestMethod.GET)
	public String showTopicMulti(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		FullTopic topic = request.getFullTopic(idTopic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
		}
		User user = request.getCurrentUser();
		model.addAttribute("question", topic.getQuestion());
		model.addAttribute("options", topic.getOptions());
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		return "topic-multi";
	}
	
	

	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/multiple" , method = RequestMethod.POST)
	public String postVoteMulti(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="idOption") ArrayList<String> idOption,
			@PathVariable(value="idTopic") String idTopic) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		FullTopic topic = request.getFullTopic(idTopic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
		}
		User user = request.getCurrentUser();
		model.addAttribute("question", topic.getQuestion());
		model.addAttribute("options", topic.getOptions());
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		for(String id : idOption){
			request.postMultipleVote(idTopic, Integer.parseInt(id));
		}
		return "topic-multi";
	}
	
	@RequestMapping(value = "forum/{idForum}/topic/new" , method = RequestMethod.GET)
	public String newTopic(Locale locale, Model model,@PathVariable(value="idForum") String idForum) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		model.addAttribute("idForum", idForum);

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
		System.out.println("Fecha: "+ closingAt);
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		ArrayList<Tag> tags = request.getTags();
		model.addAttribute("tags",tags);
		System.out.println(title);
		System.out.println(tag);
		System.out.println("Votable"+votablex);
		System.out.println("Secret:"+secretx);
		System.out.println("Semipublic"+semipublicx);
		System.out.println("Simple"+simplex);
		System.out.println("Selection"+selectionx);
		System.out.println("Multiselection"+multiselectionx);
		System.out.println(options);
		boolean simple = Boolean.valueOf(simplex);
		boolean votable = Boolean.valueOf(votablex);
		boolean secret = Boolean.valueOf(secretx);
		boolean multiple = Boolean.valueOf(multiselectionx);

		String[] splitDate = closingAt.split(" ");
		closingAt = splitDate[0]+"T"+splitDate[1]+".000Z";
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
		
		model.addAttribute("idForum", idForum);

		System.out.println("La pregunta desde new es: "+question);
		return "redirect:/forum/"+idForum;
	}
}









