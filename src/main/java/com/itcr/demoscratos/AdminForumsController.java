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
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;
import com.itcr.demoscratos.services.MessagesService;
import com.itcr.demoscratos.services.DateService;

/*
 * 			Controlador para admin
 */

@Controller 
public class AdminForumsController {
	
	private MessagesService messages = new MessagesService();
	private static final Logger logger = LoggerFactory.getLogger(AdminForumsController.class);
	
	private RequestController request = RequestController.getInstance();
		
	@RequestMapping(value = "/admin/forums" , method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		User user = request.getCurrentUser();
		model.addAttribute("user", user);
		
		ArrayList<Forum> forums = request.getForums();
		model.addAttribute("forums", forums );
		
		logger.info(messages.getForums(), locale);
		return "admin-forums";
	}
	@RequestMapping(value = "/admin/forum/{idForum} " , method = RequestMethod.GET)
	public String displayTopiscForum(Locale locale, Model model,@PathVariable(value="idForum") String idForum) {
		
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		Forum forum= null;
		
		ArrayList<Forum> forums = request.getForums();
		
		for (Forum f : forums){
			if(f.getId().equals(idForum)){
				forum = f;
				break;
			}
		}
		
		
		model.addAttribute("forum", forum);
		
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		ArrayList<Topic> topics = request.getTopicsAdmin(idForum);
		model.addAttribute("idForum",idForum);
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

		return "admin-topics";
	}
	
	@RequestMapping(value = "/admin/forum/{idForum}/delete/{nameForum} " , method = RequestMethod.POST)
	public String deleteForum(Locale locale, Model model,@PathVariable(value="idForum") String idForum, @PathVariable("nameForum") String nameForum) {
		
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
			
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		
		request.deleteForum(nameForum);
	
	
		return "redirect:/admin/forums";
	}
	
	@RequestMapping(value = "admin/forum/{idForum}/topic/{idTopic}" , method = RequestMethod.GET)
	public String showTopic(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic
			) {
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
			
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		FullTopic topic = request.getFullTopic(idTopic);
		model.addAttribute("topic", topic );

		DateService serviceDate = new DateService();
		boolean isClosed = serviceDate.isClose((String) topic.getClosingAt());
		
		topic.setClosingAt(serviceDate.getCloseDate((String) topic.getClosingAt()));
		
		if(request.isTopicApprove(idTopic)){
			model.addAttribute("unpublish", "block");
			model.addAttribute("publish", "none");
		}else{
			model.addAttribute("unpublish", "none");
			model.addAttribute("publish", "block");
		}
		
		
		if(!topic.isSecret()){
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
		
		model.addAttribute("publishMessage", "none");
		model.addAttribute("noPublishMessage", "none");

		return "admin-topic";
	}
	

	@RequestMapping(value = "admin/forums/new" , method = RequestMethod.GET)
	public String getPostForum(Locale locale, Model model) {
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		model.addAttribute("existForum", "none");


		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		
		model.addAttribute("success", "none");

		return "admin-new-forum";
	}
	
	@RequestMapping(value = "admin/forums/new" , method = RequestMethod.POST)
	public String postForum(Locale locale, Model model,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description) {
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		
		String name =title.replaceAll("\\P{L}+", "");
		name = name.replaceAll("[^\\p{ASCII}]", "");
		boolean exist = false;
		description = description.replaceAll("[\n\r]", " ");
		ArrayList<Forum> forums = request.getForums();
		for(Forum forum : forums){
			if(forum.getName().equals(name)){
				exist = true;
			}
		}
		if(!exist){
			request.postForum(name, title, description);
			model.addAttribute("success", "block");

			model.addAttribute("existForum", "none");

		}else{
			model.addAttribute("existForum", "block");
			model.addAttribute("success", "none");

		}
		


		return "admin-new-forum";
	}
	
	@RequestMapping(value = "/admin/forum/{idForum}/delete" , method = RequestMethod.POST)
	public String getDeleteForum(Locale locale, Model model,
			@RequestParam(value="idForum") String idForum) {
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		
		ArrayList<Forum> forums = request.getForums();
		for(Forum forum : forums){
			if(forum.getId().equals(idForum)){
				request.deleteForum(forum.getName());
			}
		}


		return "redirect:/admin/forum";
	}
	
}