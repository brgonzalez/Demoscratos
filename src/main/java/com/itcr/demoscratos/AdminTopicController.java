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
import com.itcr.demoscratos.services.MessagesService;
import com.itcr.demoscratos.services.DateService;
import com.itcr.demoscratos.services.LaTeXReportService;

/*
 * 			Controlador para admin
 */

@Controller 
public class AdminTopicController {
	
	private MessagesService messages = new MessagesService();
	private static final Logger logger = LoggerFactory.getLogger(AdminTopicController.class);
	
	private RequestController request = RequestController.getInstance();
	private DateService dateService = new DateService();
		

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
		
		DateService serviceDate = new DateService();
		boolean isClosed = serviceDate.isClose((String) topic.getClosingAt());
		
		topic.setClosingAt(serviceDate.getCloseDate((String) topic.getClosingAt()));
		
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
		
		DateService serviceDate = new DateService();
		boolean isClosed = serviceDate.isClose((String) topic.getClosingAt());
		
		topic.setClosingAt(serviceDate.getCloseDate((String) topic.getClosingAt()));
		
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
	@RequestMapping(value = {"/admin/forum/{idForum}/topic/{idTopic}/report","/forum/{idForum}/topic/{idTopic}/report" }, method = {RequestMethod.GET})
	public String report(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic){
		if(!request.isLoggedIn()){
			return "redirect:/admin/login";
		}
		
		if(request.getCurrentUser().isAdmin()){
			model.addAttribute("formReport", "block");
		}else{
			model.addAttribute("formReport", "none");
		}
		model.addAttribute("generateReport", "none");
		

		Report report = request.getReport(idTopic);
		User user = request.getCurrentUser();
		FullTopic topic = request.getFullTopic(idTopic);
		
		topic.setClosingAt(dateService.normalizeDate((String) topic.getClosingAt()));
		
		topic.setCreatedAt(dateService.normalizeDate((String) topic.getCreatedAt()));

		
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
	
	@RequestMapping(value = {"/admin/forum/{idForum}/topic/{idTopic}/report","/forum/{idForum}/topic/{idTopic}/report" }, method = RequestMethod.POST)
	public String reportLatex(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic){
		if(!request.isLoggedIn()){
			return "redirect:/admin/login";
		}
		
		if(request.getCurrentUser().isAdmin()){
			model.addAttribute("formReport", "block");
			LaTeXReportService reportService = new LaTeXReportService();
			reportService.generateReport(idTopic);
			System.out.println("Genera");
		}else{
			model.addAttribute("formReport", "none");
		}
		
		model.addAttribute("generateReport", "block");

		Report report = request.getReport(idTopic);
		User user = request.getCurrentUser();
		FullTopic topic = request.getFullTopic(idTopic);
		
		topic.setClosingAt(dateService.normalizeDate((String) topic.getClosingAt()));
		
		topic.setCreatedAt(dateService.normalizeDate((String) topic.getCreatedAt()));

		
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

