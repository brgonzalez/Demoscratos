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
import org.springframework.web.bind.annotation.RequestParam;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.Forum;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Report;
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
public class AdminTopicController {
	
	private Messages messages = new Messages();
	private static final Logger logger = LoggerFactory.getLogger(AdminTopicController.class);
	
	private RequestController request = RequestController.getInstance();
		

	@RequestMapping(value = "/admin/forum/{idForum}/topic/{idTopic}/publish" , method = RequestMethod.POST)
	public String publish(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic){
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		Report report = request.getReport(idTopic);
		User user = request.getCurrentUser();
		FullTopic topic = request.getFullTopic(idTopic);
		
		model.addAttribute("publishMessage", "block");
		model.addAttribute("noPublishMessage", "none");

		request.postTopicApproved(idTopic);
		
		if(request.isTopicApprove(idTopic)){
			model.addAttribute("unpublish", "block");
			model.addAttribute("publish", "none");
		}else{
			model.addAttribute("unpublish", "none");
			model.addAttribute("publish", "block");
		}
		
		ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
		boolean isClosed = serviceDate.isClose();
		
		topic.setClosingAt(serviceDate.getCloseDate());
		
		model.addAttribute("user", user );
		model.addAttribute("topic", topic );
		model.addAttribute("report", report );
		
		if(topic.isSecret()){
			model.addAttribute("modality", "Privado");
		}else{
			model.addAttribute("modality", "Semipúblico");
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
	
	@RequestMapping(value = "/admin/forum/{idForum}/topic/{idTopic}/unpublish" , method = RequestMethod.POST)
	public String unpublish(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic){
		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		Report report = request.getReport(idTopic);
		User user = request.getCurrentUser();
		FullTopic topic = request.getFullTopic(idTopic);
		request.postTopicDisapprove(idTopic);
		model.addAttribute("publishMessage", "none");
		model.addAttribute("noPublishMessage", "block");
		
		ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
		boolean isClosed = serviceDate.isClose();
		
		topic.setClosingAt(serviceDate.getCloseDate());
		
		model.addAttribute("user", user );
		model.addAttribute("topic", topic );
		model.addAttribute("report", report );
		
		request.postTopicDisapprove(idTopic);
		
		if(request.isTopicApprove(idTopic)){
			model.addAttribute("unpublish", "block");
			model.addAttribute("publish", "none");
		}else{
			model.addAttribute("unpublish", "none");
			model.addAttribute("publish", "block");
		}
		
		if(topic.isSecret()){
			model.addAttribute("modality", "Privado");
		}else{
			model.addAttribute("modality", "Semipúblico");
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
	@RequestMapping(value = {"/admin/forum/{idForum}/topic/{idTopic}/report","/forum/{idForum}/topic/{idTopic}/report" }, method = {RequestMethod.POST,RequestMethod.GET})
	public String report(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic){
		if(!request.isLoggedIn()){
			return "redirect:/admin/login";
		}

		Report report = request.getReport(idTopic);
		User user = request.getCurrentUser();
		FullTopic topic = request.getFullTopic(idTopic);
		
		model.addAttribute("user", user );
		model.addAttribute("topic", topic );
		model.addAttribute("report", report );
		

		if(request.isTopicApprove(idTopic)){
			model.addAttribute("unpublish", "block");
			model.addAttribute("publish", "none");
		}else{
			model.addAttribute("unpublish", "none");
			model.addAttribute("publish", "block");
		}
		
		if(topic.isSecret()){
			model.addAttribute("modality", "Privado");
		}else{
			model.addAttribute("modality", "Semipúblico");
		}
		
		return "admin-report";
	}
	
	@RequestMapping(value = "/admin/forum/{idForum}/topic/{idTopic}/delete" , method = RequestMethod.POST)
	public String delete(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic){

		if(!request.isLoggedIn() || !request.getCurrentUser().isAdmin()){
			return "redirect:/admin/login";
		}
		
		request.deleteTopic(idTopic);
		

		if(request.isTopicApprove(idTopic)){
			model.addAttribute("unpublish", "block");
			model.addAttribute("publish", "none");
		}else{
			model.addAttribute("unpublish", "none");
			model.addAttribute("publish", "block");
		}
		
		return "redirect:/admin/forum/"+idForum;
	}
}

