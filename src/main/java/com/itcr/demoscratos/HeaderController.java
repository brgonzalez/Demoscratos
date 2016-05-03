package com.itcr.demoscratos;

import org.springframework.stereotype.Controller;
import java.util.Locale;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.User;

@Controller
public class HeaderController {
	
	private RequestController request =  RequestController.getInstance();

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String logedIn(Locale locale, Model model) {
		User user = request.getCurrentUser();
		model.addAttribute("user", user );
		return "about";
	}
}