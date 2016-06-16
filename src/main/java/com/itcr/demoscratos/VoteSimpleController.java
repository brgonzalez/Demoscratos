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
		FullTopic topic = request.getFullTopic(idTopic);
		User user = request.getCurrentUser();
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

		boolean isVoted = topic.userAlreadyVoted();

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
		System.out.println(isVoted);
		if(isVoted || request.doesGivenVoteExist(idTopic)){
			model.addAttribute("voted", "block");
			model.addAttribute("displayVote", "none");

		}else{
			model.addAttribute("voted", "none");
			model.addAttribute("displayVote", "block");
		}
		
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
		FullTopic topic = request.getFullTopic(idTopic);
		User user = request.getCurrentUser();
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

		boolean isVoted = topic.userAlreadyVoted();
		
		//view rings
		if(!request.doesGivenVoteExist(idTopic) && !isVoted ){
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
			isVoted = true;
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
		return "topic-simple";
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