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
public class VoteSimpleController {
		
	private Messages messages = new Messages();
	private static final Logger logger = LoggerFactory.getLogger(VoteSimpleController.class);
	private RequestController request = RequestController.getInstance();

	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/simple" , method = RequestMethod.GET)
	public String showTopic(Locale locale, Model model,@PathVariable(value="idForum") String idForum, @PathVariable(value="idTopic") String idTopic){
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
		
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		FullTopic topic = request.getFullTopic(idTopic);
		
		ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
		boolean isClosed = serviceDate.isClose();
		boolean isVoted =topic.userAlreadyVoted();
		
		model.addAttribute("members", request.getRing());
		
		if(isClosed | isVoted){
			model.addAttribute("voted", "block");
			model.addAttribute("displayVote", "none");
			model.addAttribute("close", serviceDate.getCloseDate());
			if(isClosed){
				model.addAttribute("close", "Cerrado");
				model.addAttribute("message", "No se aceptan más votos");
			}
			if(isVoted && !isClosed){
				model.addAttribute("message", messages.voted());
			}
		}else{
			model.addAttribute("voted", "none");
			model.addAttribute("displayVote", "block");
			model.addAttribute("close", serviceDate.getCloseDate());
		}
	
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
			model.addAttribute("modality", "Privado" );
		}
		else{
			ArrayList<VisibleVote> votes = topic.getVisibleVotes();
			model.addAttribute("votes", votes);
			model.addAttribute("modality", "Semipúblico" );
		}
		
		
		System.out.println("*+++++++++++++++++++++++++"+topic.getGivenVotes());
		model.addAttribute("givenVotes", topic.getGivenVotes());
		return "topic-simple";
	}
	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/simple" , method = RequestMethod.POST)
	public String simpleVote(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="vote") String vote,
			@PathVariable(value="idTopic") String idTopic) {
		if(!request.isLoggedIn()){
			logger.info(messages.userLoggedIn(), locale);
			return "redirect:/login";
		}
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
		FullTopic topic = request.getFullTopic(idTopic);
		if(topic.isSecret()){
			model.addAttribute("isSecret", "none" );
			model.addAttribute("modality", "Privado" );
		}
		else{
			ArrayList<VisibleVote> votes = topic.getVisibleVotes();
			model.addAttribute("votes", votes);
			model.addAttribute("modality", "Semipúblico" );
		}
		User user = request.getCurrentUser();

		ServiceDate serviceDate = new ServiceDate((String) topic.getClosingAt());
		boolean isClosed = serviceDate.isClose();
		boolean isVoted =topic.userAlreadyVoted();
		if(isClosed | isVoted){
			model.addAttribute("voted", "block");
			model.addAttribute("displayVote", "none");
			if(isClosed){
				model.addAttribute("close", "Cerrado");
				model.addAttribute("message", "No se aceptan más votos");
			}else{
				model.addAttribute("close", serviceDate.getCloseDate());
			}
			if(isVoted && !isClosed){
				model.addAttribute("message", messages.voted());
			}
		}else{
			model.addAttribute("voted", "none");
			model.addAttribute("displayVote", "block");
			model.addAttribute("close", serviceDate.getCloseDate());
		}
		
		model.addAttribute("user", user );
		model.addAttribute("idForum", idForum);
		model.addAttribute("topic", topic);
		
		
			
		return "redirect:/forum/"+idForum;
	}
	
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/simple" ,params="memberRing", method = RequestMethod.POST)
	public String giveSimpleVote(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="memberRing") String memberRing,
			@PathVariable(value="idTopic") String idTopic) {
		request.postGiveVote(idTopic, memberRing);
			
		return "redirect:/forum/"+idForum+"/topic/"+idTopic+"/simple";
	}
	@RequestMapping(value = "forum/{idForum}/topic/{idTopic}/simple/{idGivenVote}" ,params="idOption", method = RequestMethod.POST)
	public String voteGivenVote(Locale locale, Model model,
			@PathVariable(value="idForum") String idForum,
			@RequestParam(value="idOption") String idOption,
			@PathVariable(value="idTopic") String idTopic,
			@PathVariable(value="idGivenVote") String idGivenVote) {
		request.postGivenVote(Integer.parseInt(idGivenVote), Integer.parseInt(idOption));
			
		return "redirect:/forum/"+idForum+"/topic/"+idTopic+"/simple";
	}
	
}