package com.itcr.demoscratos;

import org.springframework.stereotype.Controller;
import java.util.Locale;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String logedIn(Locale locale, Model model) {		
		return "about";
	}
}