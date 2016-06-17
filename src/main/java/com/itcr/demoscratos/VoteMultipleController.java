package com.itcr.demoscratos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Option;
import com.itcr.demoscratos.models.Tag;
import com.itcr.demoscratos.models.Topic;
import com.itcr.demoscratos.models.User;
import com.itcr.demoscratos.models.VisibleVote;
import com.itcr.demoscratos.models.Vote;
import com.itcr.demoscratos.services.Messages;
import com.itcr.demoscratos.services.ServiceDate;

@Controller
public class VoteMultipleController {
		
	private Messages messages = new Messages();
	private static final Logger logger = LoggerFactory.getLogger(VoteMultipleController.class);
	private RequestController request = RequestController.getInstance();


	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/multiple" , method = RequestMethod.GET)
	public String showTopicMulti(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@PathVariable(value="idTopic") String idTopic) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		FullTopic topic = request.getFullTopic(idTopic);
		User user = request.getCurrentUser();
		model.addAttribute("question", topic.getQuestion());
		model.addAttribute("options", topic.getOptions());
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		
		//votos cedidos
		model.addAttribute("givenVotes", topic.getGivenVotes());
		ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
		boolean isClosed = serviceDate.isClose();
		
		if(isClosed){
			return "redirect:/forum/{idForum}/topic/{idTopic}/report";
		}
		else{
			model.addAttribute("close", serviceDate.getCloseDate());
		}


		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
			model.addAttribute("modality", "Privado" );
		}
		else{
			ArrayList<VisibleVote> votes = topic.getVisibleVotes();
			model.addAttribute("votes", votes);
			model.addAttribute("modality", "Semipúblico" );
		}

		boolean isVoted = false;
		for(Option o : topic.getOptions()){
			if (topic.userAlreadyVoted(o.getId())){
				isVoted = true;
				break;
			}
		}
		
		//view rings
		if(!request.doesGivenVoteExist(idTopic) && !isVoted ){
			if(request.getRing().size() > 0){
				model.addAttribute("hasRing", "selection-ring");
				model.addAttribute("members", request.getRing());
			}
			else{
				model.addAttribute("hasRing", "no-ring");
			}
		}else{
			model.addAttribute("hasRing", "voteGiven");
		}
		
		if(isVoted || request.doesGivenVoteExist(idTopic)){
			model.addAttribute("voted", "block");
			model.addAttribute("displayVote", "none");

		}else{
			model.addAttribute("voted", "none");
			model.addAttribute("displayVote", "block");
		}
		
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
		User user = request.getCurrentUser();
		model.addAttribute("question", topic.getQuestion());
		model.addAttribute("options", topic.getOptions());
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		
		//votos cedidos
		model.addAttribute("givenVotes", topic.getGivenVotes());
		ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
		boolean isClosed = serviceDate.isClose();
		
		if(isClosed){
			return "redirect:/forum/{idForum}/topic/{idTopic}/report";
		}
		else{
			model.addAttribute("close", serviceDate.getCloseDate());
		}

		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
			model.addAttribute("modality", "Privado" );
		}
		else{
			ArrayList<VisibleVote> votes = topic.getVisibleVotes();
			model.addAttribute("votes", votes);
			model.addAttribute("modality", "Semipúblico" );
		}

		boolean isVoted = false;
		for(Option o : topic.getOptions()){
			if (topic.userAlreadyVoted(o.getId())){
				isVoted = true;
				break;
			}
		}
		//view rings
		
		System.out.println("Lo ha cedido :" + request.doesGivenVoteExist(idTopic)+" , lo ha votado "+ isVoted);
		if(!request.doesGivenVoteExist(idTopic) && !isVoted ){
			for(String id: idOption){
				request.postMultipleVote(idTopic, Integer.parseInt(id));
			}
			isVoted = true;
			model.addAttribute("hasRing", "voteGiven");
			if(request.getRing().size() > 0){
				model.addAttribute("hasRing", "selection-ring");
				model.addAttribute("members", request.getRing());
			}
			else{
				model.addAttribute("hasRing", "no-ring");
			}
		}else{
			model.addAttribute("hasRing", "voteGiven");
		}
		
		if(isVoted || request.doesGivenVoteExist(idTopic)){
			model.addAttribute("voted", "block");
			model.addAttribute("displayVote", "none");

		}else{
			model.addAttribute("voted", "none");
			model.addAttribute("displayVote", "block");
		}

		return "redirect:/forum/"+idForum;
	}

	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/multiple" ,params="memberRing", method = RequestMethod.POST)
	public String giveSimpleVote(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="memberRing") String memberRing,
			@PathVariable(value="idTopic") String idTopic) {
		request.postGiveVote(idTopic, memberRing);
			
		return "redirect:/forum/"+idForum+"/topic/"+idTopic+"/multiple";
	}
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/multiple/givenVote/{idGivenVote}" ,params="idOption", method = RequestMethod.POST)
	public String voteGivenVote(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="idOption") ArrayList<String> idOption,
			@PathVariable(value="idTopic") String idTopic,
			@PathVariable(value="idGivenVote") String idGivenVote) {
		
		for (String id :idOption ){
			request.postGivenVote(Integer.parseInt(idGivenVote), Integer.parseInt(id));
		}
		
			
		return "redirect:/forum/"+idForum+"/topic/"+idTopic+"/multiple";
	}
}